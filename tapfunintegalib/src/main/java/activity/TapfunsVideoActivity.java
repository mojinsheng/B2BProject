package activity;

import com.tapfuns.utils.log.TapfunsLogUtil;
import com.tapfuns.utils.res.TapfunsResourceUtil;
import com.tapfuns.utils.task.RequestCallBack;
import com.tapfuns.utils.task.TapfunsCommandExecute;
import com.tapfuns.utils.tool.Utils;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import constant.Constant;
import utils.AppofferUtil;
import view.AdsVideoView;

public class TapfunsVideoActivity extends Activity {
	private VideoView videoView;
	private ImageView ima_close, img_download, img_voice, img_enlarge;
	final String url = null;
	public static MediaPlayer player;
	private ProgressBar bar;
	private static boolean isVoiceFlags=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		AdsVideoView adsVideoView = new AdsVideoView(this);
		setContentView(adsVideoView);
		videoView = adsVideoView.getVideoView();
		ima_close = adsVideoView.getIma_close();
		img_download = adsVideoView.getImg_download();
		img_voice = adsVideoView.getImg_voice();
		img_enlarge = adsVideoView.getImg_enlarge();
		bar=adsVideoView.getPb();


	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// 设置视频控制器
		// videoView.setMediaController(new MediaCont);
		// http: //
		// www.qzjweb.com/api/appoffer/getoffer?auth=987d8898d1adb1eebb6b5ce803a98c08&
		// time=2017-09-07%2012:35:24&appid=596c5ee8a3687&ingetral=No&type=3
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
						// 设置视频路径
						String url = AppofferUtil.getIntsance().getList()
								.get(0).getVedio_url();
						Uri uri = Uri.parse(url);
						videoView.setVideoURI(uri);

						// 开始播放视频
						videoView.start();
					}
				});
		// 播放完成回调
		videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
		videoView.setOnPreparedListener(new MyPreparedListenerionListener());
		ima_close.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		// img_voice.setOnClickListener(new MyPlayerOnCompletionListener());
		img_voice.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				 if(!isVoiceFlags){
					 player.setVolume(0f, 0f);
					 videoView.start();
					 isVoiceFlags=true;
					 img_voice.setBackgroundResource(TapfunsResourceUtil.findDrawableIdByName(TapfunsVideoActivity.this, "volumvideo"));
				 }else{
					 player.setVolume(1f, 1f);
					 videoView.start();
					 isVoiceFlags=false;
					 img_voice.setBackgroundResource(TapfunsResourceUtil.findDrawableIdByName(TapfunsVideoActivity.this, "volumclosevideo"));
				 }
			}
		});
		img_download.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(TapfunsVideoActivity.this, TapfunsWebActivity.class);
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
				if (isPkgInstalled(TapfunsVideoActivity.this, "com.android.vending")) {
					intent.setPackage("com.android.vending");
				}else{
					return;
				}
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				TapfunsVideoActivity.this.startActivity(intent);
			}
		});
		img_enlarge.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(TapfunsVideoActivity.this.getResources().getConfiguration().orientation ==Configuration.ORIENTATION_PORTRAIT){  
				      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);  
				}else{
					 setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  
				}
			}
		});
	}

	class MyPlayerOnCompletionListener implements
			MediaPlayer.OnCompletionListener {

		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(TapfunsVideoActivity.this,
					VideoDownGame.class);
			startActivity(intent);
			finish();
			StringBuffer sbfs = new StringBuffer();
			sbfs.append(Constant.AppVideoEndApi);
			sbfs.append("offer_id="
					+AppofferUtil.getIntsance().getList().get(0).getOffer_id());
			sbfs.append("&dev_id=" + AppofferUtil.getIntsance().getList().get(0).getDev_id());
			sbfs.append("&app_id=" +  AppofferUtil.getIntsance().getList().get(0).getApp_id());
			sbfs.append("&is_integral=" + AppofferUtil.getIntsance().getList().get(0).getIs_integral());
			sbfs.append("&ad_type=" + AppofferUtil.getIntsance().getList().get(0).getApp_type());
			sbfs.append("&android_id=" + Constant.getAndroidID(TapfunsVideoActivity.this));
			TapfunsCommandExecute.getInstance().executeGet(TapfunsVideoActivity.this, sbfs.toString(),
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
			OnPreparedListener {

		@Override
		public void onPrepared(MediaPlayer mp) {
			// TODO Auto-generated method stub
			player=mp;
			bar.setVisibility(View.GONE);
			StringBuffer sbf = new StringBuffer();
			sbf.append(Constant.AppVideoApi);
			sbf.append("offer_id="
					+AppofferUtil.getIntsance().getList().get(0).getOffer_id());
			sbf.append("&dev_id=" + AppofferUtil.getIntsance().getList().get(0).getDev_id());
			sbf.append("&app_id=" +  AppofferUtil.getIntsance().getList().get(0).getApp_id());
			sbf.append("&is_integral=" + AppofferUtil.getIntsance().getList().get(0).getIs_integral());
			sbf.append("&ad_type=" + AppofferUtil.getIntsance().getList().get(0).getApp_type());
			sbf.append("&android_id=" + Constant.getAndroidID(TapfunsVideoActivity.this));
			TapfunsCommandExecute.getInstance().executeGet(TapfunsVideoActivity.this, sbf.toString(),
					new RequestCallBack() {
						@Override
						public void getRequestResult(String command) {
							
							TapfunsLogUtil.logI(command);
							
						}
			});
		}

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
