package activity;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tapfuns.utils.log.TapfunsLogUtil;
import com.tapfuns.utils.res.TapfunsResourceUtil;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import constant.Constant;
import controls.Controls;
import mojin.from.com.tapfunintegalib.R;
import utils.AppofferUtil;
import view.BaseTapfunAdsDisplayView;

public class TapfunsAdsInergral extends Activity {
	private ImageView img_close;
	public ImageView img_icon,img_content,img_icon_close;
	private TextView te_title,te_desc,te_point;
	private LinearLayout lin_imag,lin_content;
	private RelativeLayout re_pro;
	private BaseTapfunAdsDisplayView adsDisplayView;
	private Button btn_desc;
	private String language;
	private boolean isPortrait;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
//		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		final String flags=bundle.getString("flags");
		adsDisplayView=new BaseTapfunAdsDisplayView(this,flags);
	
			this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(adsDisplayView);
		initImageLoader(this);
		img_close=adsDisplayView.getImg_close();
		img_content=adsDisplayView.getImg_content();
		img_icon=adsDisplayView.getImg_icon();
		img_icon_close=adsDisplayView.getImg_content_close();
		te_title=adsDisplayView.getTe_title();
		te_desc=adsDisplayView.getTe_desc();
		btn_desc=adsDisplayView.getBtn_desc();
		te_point=adsDisplayView.getTe_point();
//		lin_imag=(LinearLayout)findViewById(R.id.lin_imag);
//		lin_content=(LinearLayout)findViewById(R.id.lin_content);
//		re_pro=(RelativeLayout)findViewById(R.id.re_pro);

		language= Controls.getInstance().getLanguage().toLowerCase();
//		if(flags.equals(Constant.IMAGEVIEW_SIMPLEININSERT)){
//			lin_imag.setVisibility(View.GONE);
//			lin_content.setVisibility(View.GONE);
//			re_pro.setVisibility(View.VISIBLE);
//		}
		
//		http://www.qzjweb.com/api/appoffer/getoffer?auth=987d8898d1adb1eebb6b5ce803a98c08&
//			time=2017-09-07%2012:35:24&appid=596c5ee8a3687&ingetral=Yes&type=2
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.appofferUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + Constant.appid);
		if(flags.equals(Constant.IMAGEVIEW_WITH_INTEGRAL)){
			sb.append("&ingetral=" + "Yes");
			
		}else if(flags.equals(Constant.IMAGEVIEW_WITHOUT_INTEGRAL)){
			sb.append("&ingetral=" + "No");
			te_point.setVisibility(View.GONE);
		}else if(flags.equals(Constant.IMAGEVIEW_SIMPLEININSERT)){
			sb.append("&ingetral=" + "No");
			img_icon_close.setVisibility(View.VISIBLE);
			img_close.setVisibility(View.GONE);
			adsDisplayView.getLinearLayoutGameDesc().setVisibility(View.GONE);
			adsDisplayView.getLinearLayoutGameDesc2().setVisibility(View.GONE);
		}
		sb.append("&type=" + "2");
		TapfunsCommandExecute.getInstance().executeGet(this, sb.toString(),
				new RequestCallBack() {
					@Override
					public void getRequestResult(String command) {
						AppofferUtil.getIntsance().StrToAppofferParams(command);
					ImageLoader.getInstance().displayImage(
  		AppofferUtil.getIntsance().getList().get(0).getBanner_img(), img_content);
					ImageLoader.getInstance().displayImage(
				AppofferUtil.getIntsance().getList().get(0).getLogo(), img_icon);
					te_desc.setText(AppofferUtil.getIntsance().getList().get(0).getAd_desc());
					te_title.setText(AppofferUtil.getIntsance().getList().get(0).getAd_slogan());
					te_point.setText("+  "+AppofferUtil.getIntsance().getList().get(0).getIntegral()+"  "+createString(TapfunsAdsInergral.this, "textview_point"));

					StringBuffer sbf = new StringBuffer();
					sbf.append(Constant.appAppCpmApi);
					sbf.append("offer_id="
							+AppofferUtil.getIntsance().getList().get(0).getOffer_id());
					sbf.append("&dev_id=" + AppofferUtil.getIntsance().getList().get(0).getDev_id());
					sbf.append("&app_id=" +  AppofferUtil.getIntsance().getList().get(0).getApp_id());
					sbf.append("&is_integral=" + AppofferUtil.getIntsance().getList().get(0).getIs_integral());
					sbf.append("&ad_type=" + AppofferUtil.getIntsance().getList().get(0).getApp_type());
					sbf.append("&android_id=" + Constant.getAndroidID(TapfunsAdsInergral.this));
					TapfunsCommandExecute.getInstance().executeGet(TapfunsAdsInergral.this, sbf.toString(),
							new RequestCallBack() {

								@Override
								public void getRequestResult(String msg) {
									// TODO Auto-generated method stub
									TapfunsLogUtil.logI(msg);
								}
						
					});
					}

				});
		img_close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		img_icon_close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		img_content.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(TapfunsAdsInergral.this, TapfunsWebActivity.class);
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
				if (isPkgInstalled(TapfunsAdsInergral.this, "com.android.vending")) {
					intent.setPackage("com.android.vending");
				}else{
					return;
				}
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				TapfunsAdsInergral.this.startActivity(intent);
			}
		});
		btn_desc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (TextUtils.isEmpty(AppofferUtil.getIntsance().getList().get(0).getPackageName())) {
					return;
				}

				Uri uri = Uri.parse("market://details?id="
						+ AppofferUtil.getIntsance().getList().get(0).getPackageName());
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				if (isPkgInstalled(TapfunsAdsInergral.this, "com.android.vending")) {
					intent.setPackage("com.android.vending");
				}else{
					return;
				}
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				TapfunsAdsInergral.this.startActivity(intent);
			}
		});
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppofferUtil.getIntsance().getList().clear();
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
	public String createString(Context mContext,String filename){
		if(!TextUtils.isEmpty(language)){
			filename = language+"_"+filename;
		return TapfunsResourceUtil.findStringByName(mContext, filename);
	}else{
		TapfunsLogUtil.logE("請先設置语言");
		return "";
	}
		
}
	
}
