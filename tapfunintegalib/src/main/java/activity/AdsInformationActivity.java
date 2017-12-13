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
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import adapter.AdsInformationAdapter;
import constant.Constant;
import mojin.from.com.tapfunintegalib.R;
import utils.AppofferUtil;
import view.TapfunsListView;

public class AdsInformationActivity extends Activity{
	private ListView listView;
	private TextView te_back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		TapfunsListView alertVideoView = new TapfunsListView(this);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(alertVideoView);
		listView=alertVideoView.getListView();
		te_back=alertVideoView.getTe_back();
		listView.setDivider(new ColorDrawable(Color.GRAY));
		listView.setDividerHeight(1);
		 listView.addHeaderView(new ViewStub(this));
		initImageLoader(this);
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.appofferUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + Constant.appid);
		sb.append("&ingetral=No" );
		
		sb.append("&type=4");

		TapfunsCommandExecute.getInstance().executeGet(this, sb.toString(),
				new RequestCallBack() {
					@Override
					public void getRequestResult(String command) {
						AppofferUtil.getIntsance().StrToAppofferParams(command);
	
						AdsInformationAdapter adapter = new AdsInformationAdapter(AppofferUtil.getIntsance().getList(),
								AdsInformationActivity.this);
						listView.setAdapter(adapter);
					}

				});
		te_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
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
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppofferUtil.getIntsance().getList().clear();
	}
}
