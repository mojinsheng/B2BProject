package activity;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tapfuns.utils.task.RequestCallBack;
import com.tapfuns.utils.task.TapfunsCommandExecute;
import com.tapfuns.utils.tool.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import adapter.WallAdapter;
import constant.Constant;
import mojin.from.com.tapfunintegalib.R;
import utils.AppofferUtil;
import view.DepthPageTransformer;
import view.FixedSpeedScroller;
import view.WallView;

public class WallActivity extends Activity {
	private ViewPager mViewPager;
	private TextView btn_back;
	private ListView listView;
	private Handler v_handler;
	private TextView t_integral;
	private FixedSpeedScroller mScroller;
	private List<ImageView> mImageViews = new ArrayList<ImageView>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		WallView wallActivity=new WallView(this);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//setContentView(new WallActivity());
		setContentView(wallActivity);
		//setContentView(new WallActivity());
		
		mViewPager = wallActivity.getViewPager();
		btn_back=wallActivity.getTe_back();
		listView = wallActivity.getListView();
		t_integral = (TextView) wallActivity.getTe_inregra();
		v_handler = new Handler();
		v_handler.postDelayed(new TimerRunnable(), 2500);
		//initData();
		
		
//		btn_back = (TextView) findViewById(R.id.btn_back);
//		listView = (ListView) findViewById(R.id.walllist);
//		t_integral = (TextView) findViewById(R.id.t_integral);
		
		listView.setDivider(new ColorDrawable(Color.GRAY));
		listView.setDividerHeight(1);
		 listView.addHeaderView(new ViewStub(this));
		initImageLoader(this);


		// http://www.qzjweb.com/api/appoffer/getoffer?
		// auth=987d8898d1adb1eebb6b5ce803a98c08&time=2017-09-07%2012:35:24&
		// appid=596c5ee8a3687&ingetral=Yes&type=1
		// 请求积分墙数据
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.appofferUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + Constant.appid);
		sb.append("&ingetral=" + "Yes");
		sb.append("&type=" + "1");
		TapfunsCommandExecute.getInstance().executeGet(this, sb.toString(),
				new RequestCallBack() {
					@Override
					public void getRequestResult(String command) {
						AppofferUtil.getIntsance().StrToAppofferParams(command);
						WallAdapter adapter = new WallAdapter(AppofferUtil
								.getIntsance().getList(), WallActivity.this);
						listView.setAdapter(adapter);
						StringBuffer sb = new StringBuffer();
						sb.append(Constant.appofferUrl);
						sb.append("auth="
								+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
						sb.append("&time=" + Constant.getCurrentTime());
						sb.append("&appid=" + Constant.appid);
						sb.append("&ingetral=" + "Yes");
						sb.append("&type=" + "5");
						TapfunsCommandExecute.getInstance().executeGet(WallActivity.this, sb.toString(),
								new RequestCallBack() {
									@Override
									public void getRequestResult(String command) {
//										AppofferUtil.getIntsance().StrToAppofferParams(command);
//										WallAdapter adapter = new WallAdapter(AppofferUtil
//												.getIntsance().getList(), WallActivity.this);
//										listView.setAdapter(adapter);
										initData();
										mViewPager.setAdapter(new PagerAdapter() {
											@Override
											public int getCount() {
												// return imageViews.size(); 修改如下
												return 10000;
											}

											@Override
											public boolean isViewFromObject(View view, Object object) {
												return view == object;
											}

											@Override
											public void destroyItem(ViewGroup container, int position,
													Object object) {
												// container.removeView(imageViews.get(position%imageViews.size()));
												// 删除此句 此句不删除 会出现 滑动中 布局消失的情况 因为被移除了 此处这样修改会影响一些性能。。。。。
											}

											@Override
											public Object instantiateItem(ViewGroup container, int position) {
												// container.addView(imageViews.get(position));
												// return imageViews.get(position); 修改如下
												try {
													container.addView(mImageViews.get(position
															% mImageViews.size()));
												} catch (Exception e) {

												}
												return mImageViews.get(position % mImageViews.size());
											}
										});
										Field field;
										try {
											field = ViewPager.class.getDeclaredField("mScroller");
											field.setAccessible(true);
											mScroller = new FixedSpeedScroller(WallActivity.this);
											mScroller.setmDuration(1000);
											field.set(mViewPager, mScroller);
										} catch (NoSuchFieldException | IllegalAccessException
												| IllegalArgumentException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										mViewPager.setPageTransformer(true, new DepthPageTransformer());
										// mViewPager.setCurrentItem(1000*mImageViews.size());
										mScroller.setmDuration(2 * 1000);
									}

								});

					}

				});

		// 返回鍵按鈕
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
//		// 积分墙按钮
		t_integral.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(WallActivity.this,
						Inregralwallactivity.class);
				startActivity(intent);
			}
		});
	}

	class TimerRunnable implements Runnable {

		@Override
		public void run() {
			int curItem = mViewPager.getCurrentItem();
			mViewPager.setCurrentItem(curItem + 1);
			if (v_handler != null) {
				v_handler.postDelayed(this, 2500);
			}
		}
	}

	private final static void initImageLoader(Context context) {
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).defaultDisplayImageOptions(getDefaultDisplayOption())
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.imageDownloader(new BaseImageDownloader(context))
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(config);
	}

	private final static DisplayImageOptions getDefaultDisplayOption() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageForEmptyUri(R.drawable.icon) // 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.icon) // 设置图片加载或解码过程中发生错误显示的图片
				.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
				.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
				.showImageOnFail(R.drawable.icon).build(); // 创建配置过得DisplayImageOption对象
		return options;
	}

	private void initData() {
		if(AppofferUtil.getIntsance().getList().size()>5){
			for (int i=0;i<5;i++) {
				ImageView imageView = new ImageView(getApplicationContext());
				imageView.setScaleType(ScaleType.CENTER_CROP);
				ImageLoader.getInstance().displayImage(
			AppofferUtil.getIntsance().getList().get(i).getBanner_img(), imageView);
				mImageViews.add(imageView);
			}
		}else{
			for (int i=0;i<AppofferUtil.getIntsance().getList().size();i++) {
				ImageView imageView = new ImageView(getApplicationContext());
				imageView.setScaleType(ScaleType.CENTER_CROP);
				ImageLoader.getInstance().displayImage(
			AppofferUtil.getIntsance().getList().get(i).getBanner_img(), imageView);
				mImageViews.add(imageView);
			}
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppofferUtil.getIntsance().getList().clear();
	}
}
