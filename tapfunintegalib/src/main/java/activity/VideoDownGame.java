package activity;

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
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bean.AppofferBean;
import constant.Constant;
import mojin.from.com.tapfunintegalib.R;
import utils.AppofferUtil;
import view.VideoDownGameView;

public class VideoDownGame extends Activity{
	private ImageView img_layout,img_close,img_reboot,img_icon;
	private TextView te_titile,te_title1;
	private Button btn_down;
	private AppofferBean appofferBean=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		VideoDownGameView videoDownGameView=new VideoDownGameView(this);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
			this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(videoDownGameView);
		img_close=videoDownGameView.getImg_close();
		img_reboot=videoDownGameView.getImg_reboot();
		img_icon=videoDownGameView.getImg_icon();
		te_titile=videoDownGameView.getTe_titile();
		te_title1=videoDownGameView.getTe_title1();
		btn_down=videoDownGameView.getBtn_down();
		img_layout=videoDownGameView.getImg_layout();
		initImageLoader(this);
		img_close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		img_reboot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(VideoDownGame.this,
						TapfunsVideoActivity.class);
				startActivity(intent);
				finish();
			}
		});
		btn_down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					
						// TODO Auto-generated method stub
//						Intent intent=new Intent(VideoDownGame.this, TapfunsWebActivity.class);
//						Bundle bundle=new Bundle();
//						bundle.putString("gameurl", AppofferUtil.getIntsance().getList().get(0).getTracking_link());
//						intent.putExtras(bundle);
//						startActivity(intent);
				//String name=AppofferUtil.getIntsance().getList().get(0).getAd_slogan();
				if (TextUtils.isEmpty(appofferBean.getPackageName())) {
					return;
				}

				Uri uri = Uri.parse("market://details?id="
						+ appofferBean.getPackageName());
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				if (isPkgInstalled(VideoDownGame.this, "com.android.vending")) {
					intent.setPackage("com.android.vending");
				}else{
					return;
				}
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				VideoDownGame.this.startActivity(intent);
			}
		});
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.appofferUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + Constant.appid);
		sb.append("&ingetral=" + "No");
		sb.append("&type=" + "2");
		TapfunsCommandExecute.getInstance().executeGet(this, sb.toString(),
				new RequestCallBack() {
					@Override
					public void getRequestResult(String command) {
						AppofferUtil.getIntsance().StrToAppofferParams(command);
						ImageLoader.getInstance().displayImage(
								AppofferUtil.getIntsance().getList().get(0).getBanner_img(), img_layout);
						ImageLoader.getInstance().displayImage(
								AppofferUtil.getIntsance().getList().get(0).getLogo(), img_icon);
						appofferBean=AppofferUtil.getIntsance().getList().get(0);
						te_title1.setText(AppofferUtil.getIntsance().getList().get(0).getAd_desc());
						te_titile.setText(AppofferUtil.getIntsance().getList().get(0).getAd_slogan());
					}

				});
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppofferUtil.getIntsance().getList().clear();
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
	public boolean isPkgInstalled(Context context, String packageName) {
		if ((packageName == null) || ("".equals(packageName)))
			return false;
		ApplicationInfo info = null;
		try {
			info = context.getPackageManager().getApplicationInfo(packageName,
					0);
			return (info != null);
		} catch (PackageManager.NameNotFoundException e) {
		}
		return false;
	}
}
