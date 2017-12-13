package activity;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tapfuns.utils.log.TapfunsLogUtil;
import com.tapfuns.utils.res.TapfunsResourceUtil;
import com.tapfuns.utils.task.RequestCallBack;
import com.tapfuns.utils.task.TapfunsCommandExecute;
import com.tapfuns.utils.tool.Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import constant.Constant;
import mojin.from.com.tapfunintegalib.R;
import utils.AppofferUtil;
import view.AlertVideoView;
import view.video.FullScreenVideoView;

public class AlertVideoActivity extends Activity {
	private static boolean isVoiceFlags=false;
	private TextView te_title, te_desc;
	private ImageView img_volumvideo,img_icon,img_close;
	private Button btn_down;
	private FullScreenVideoView videoView;
	public static MediaPlayer player;
	private ProgressBar pb;
	private boolean isPortrait;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		AlertVideoView alertVideoView = new AlertVideoView(this);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(alertVideoView);
		te_title = alertVideoView.getTe_title();
		te_desc = alertVideoView.getTe_desc();
		btn_down = alertVideoView.getBtn_desc();
		videoView = alertVideoView.getVideoView();
		img_close=alertVideoView.getImg_close();
		img_icon=alertVideoView.getImg_icon();
		img_volumvideo=alertVideoView.getImg_volumvideo();
		pb=alertVideoView.getPb();
		initImageLoader(this);
		String androidId = ""
				+ android.provider.Settings.Secure.getString(
						getContentResolver(),
						android.provider.Settings.Secure.ANDROID_ID);
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.appofferUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + Constant.appid);
		sb.append("&ingetral=No");
		sb.append("&type=3");
		TapfunsCommandExecute.getInstance().executeGet(this, sb.toString(),
				new RequestCallBack() {
					@Override
					public void getRequestResult(String command) {
						AppofferUtil.getIntsance().StrToAppofferParams(command);
						AppofferUtil.getIntsance().getList().get(0)
								.getAd_desc();
						te_desc.setText(AppofferUtil.getIntsance().getList().get(0).getAd_desc());
						te_title.setText(AppofferUtil.getIntsance().getList().get(0).getAd_slogan());
						// 设置视频路径
						String url = AppofferUtil.getIntsance().getList()
								.get(0).getVedio_url();
						Uri uri = Uri.parse(url);
						videoView.setVideoURI(uri);
						ImageLoader.getInstance().displayImage(
								AppofferUtil.getIntsance().getList().get(0).getLogo(), img_icon);
						// 开始播放视频
						videoView.start();
						//videoView.setBackgroundColor(Color.TRANSPARENT);
					}
				});
		// 播放完成回调
		videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
		videoView.setOnPreparedListener(new MyPreparedListenerionListener());
		btn_down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(AlertVideoActivity.this, TapfunsWebActivity.class);
//				Bundle bundle=new Bundle();
//				bundle.putString("gameurl", AppofferUtil.getIntsance().getList().get(0).getTracking_link());
//				intent.putExtras(bundle);
//				startActivity(intent);
				if (TextUtils.isEmpty(AppofferUtil.getIntsance().getList().get(0).getPackageName())) {
					return;
				}

				Uri uri = Uri.parse("market://details?id="
						+ AppofferUtil.getIntsance().getList().get(0).getPackageName());
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				if (isPkgInstalled(AlertVideoActivity.this, "com.android.vending")) {
					intent.setPackage("com.android.vending");
				}else{
					return;
				}
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				AlertVideoActivity.this.startActivity(intent);
			}
		});
		img_volumvideo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(player!=null){
					if(!isVoiceFlags){
						player.setVolume(0f, 0f);
						videoView.start();
						isVoiceFlags=true;
						img_volumvideo.setBackgroundResource(TapfunsResourceUtil.findDrawableIdByName(AlertVideoActivity.this, "volumvideo"));
					}else{
						player.setVolume(1f, 1f);
						videoView.start();
						isVoiceFlags=false;
						img_volumvideo.setBackgroundResource(TapfunsResourceUtil.findDrawableIdByName(AlertVideoActivity.this, "volumclosevideo"));
					}
				}
			}
		});
		img_close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	class MyPlayerOnCompletionListener implements
			MediaPlayer.OnCompletionListener {

		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
//			Intent intent = new Intent(AlertVideoActivity.this,
//					VideoDownGame.class);
//			startActivity(intent);
//			finish();
			
			StringBuffer sbfs = new StringBuffer();
			sbfs.append(Constant.AppVideoEndApi);
			sbfs.append("offer_id="
					+AppofferUtil.getIntsance().getList().get(0).getOffer_id());
			sbfs.append("&dev_id=" + AppofferUtil.getIntsance().getList().get(0).getDev_id());
			sbfs.append("&app_id=" +  AppofferUtil.getIntsance().getList().get(0).getApp_id());
			sbfs.append("&is_integral=" + AppofferUtil.getIntsance().getList().get(0).getIs_integral());
			sbfs.append("&ad_type=" + AppofferUtil.getIntsance().getList().get(0).getApp_type());
			sbfs.append("&android_id=" + Constant.getAndroidID(AlertVideoActivity.this));
			TapfunsCommandExecute.getInstance().executeGet(AlertVideoActivity.this, sbfs.toString(),
					new RequestCallBack() {
						@Override
						public void getRequestResult(String command) {
							
							TapfunsLogUtil.logI(command);
							
						}
			});
		}

	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppofferUtil.getIntsance().getList().clear();
	}
	class MyPreparedListenerionListener implements
			MediaPlayer.OnPreparedListener {

		@SuppressLint("NewApi") @Override
		public void onPrepared(MediaPlayer mp) {
			// TODO Auto-generated method stub
			//videoView.setBackgroundColor(Color.TRANSPARENT);
			player = mp;
			pb.setVisibility(View.GONE);
			//img_volumvideo.setVisibility(View.VISIBLE);
			 mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
				StringBuffer sbf = new StringBuffer();
				sbf.append(Constant.AppVideoApi);
				sbf.append("offer_id="
						+AppofferUtil.getIntsance().getList().get(0).getOffer_id());
				sbf.append("&dev_id=" + AppofferUtil.getIntsance().getList().get(0).getDev_id());
				sbf.append("&app_id=" +  AppofferUtil.getIntsance().getList().get(0).getApp_id());
				sbf.append("&is_integral=" + AppofferUtil.getIntsance().getList().get(0).getIs_integral());
				sbf.append("&ad_type=" + AppofferUtil.getIntsance().getList().get(0).getApp_type());
				sbf.append("&android_id=" + Constant.getAndroidID(AlertVideoActivity.this));
				TapfunsCommandExecute.getInstance().executeGet(AlertVideoActivity.this, sbf.toString(),
						new RequestCallBack() {
							@Override
							public void getRequestResult(String command) {
								
								TapfunsLogUtil.logI(command);
								
							}
				});
				   mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
					      @Override
					      public boolean onInfo(MediaPlayer mp, int what, int extra) {

					        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
					          // video started
					           videoView.setBackgroundColor(Color.TRANSPARENT);
					          return true;
					        }
					        return false;
					      }
				   });
				   mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
					
					@Override
					public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
						// TODO Auto-generated method stub
					          // video started
					           videoView.setBackgroundColor(Color.TRANSPARENT);
					}
				}); 
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
