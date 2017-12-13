package view.widow;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tapfuns.utils.log.TapfunsLogUtil;
import com.tapfuns.utils.task.RequestCallBack;
import com.tapfuns.utils.task.TapfunsCommandExecute;
import com.tapfuns.utils.tool.TapfunsScreenUtil;
import com.tapfuns.utils.tool.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import constant.Constant;
import mojin.from.com.tapfunintegalib.R;
import utils.AppofferUtil;

public class TapfunsWindow {

	private static boolean isFlags=false;

	private TapfunsWindow(){
		
	}
	public static TapfunsWindow efunWindowView;
	public static TapfunsWindow getInstances(){
		if(efunWindowView==null){
			return efunWindowView=new TapfunsWindow();
		}else{
			return efunWindowView;
		}
	}
	private int mWidth,mHeight;
	private TapfunsScreenUtil mScreen;
	public static WindowManager wm=null;
	private WindowManager.LayoutParams wmParams=null;
	private TapfunsWindowView tapfunsWindowView=null;
	private boolean isPortrait;
	  public void createView(final Context context){
		  initImageLoader(context); 
		  if(wm==null){
			  wm=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		  }
	    	              //设置LayoutParams(全局变量）相关参数
	    	 //context.setWindowManager(wm);
		  Log.i("mojin", wm+"======================");
	    	 mScreen = TapfunsScreenUtil.getInStance((Activity)context);
	 		//Controls.instance().setPortrait(isPortrait);
	    	 isPortrait = mScreen.isPortrait((Activity)context);
	    	 mWidth = mScreen.getPxWidth();
	 		mHeight= mScreen.getPxHeight();
	        wmParams=new LayoutParams();
	    	 //this.wmParams = _wmParams;
	    	
	    	             /**
	    	              *以下都是WindowManager.LayoutParams的相关属性
	    	              * 具体用途可参考SDK文档.LAST_SUB_WINDOW;
	    	              */
	    	             wmParams.type= WindowManager.LayoutParams.LAST_SUB_WINDOW;   //设置window type
	    	            wmParams.format=PixelFormat.RGBA_8888;   //设置图片格式，效果为背景透明
	    	 
	                 //设置Window flag
	    	             wmParams.flags=LayoutParams.FLAG_NOT_TOUCH_MODAL
	    	                                  | LayoutParams.FLAG_NOT_FOCUSABLE;
	    	            /*
	    	              * 下面的flags属性的效果形同“锁定”。
	    	             * 悬浮窗不可触摸，不接受任何事件,同时不影响后面的事件响应。
	    	              wmParams.flags=LayoutParams.FLAG_NOT_TOUCH_MODAL 
	                                        | LayoutParams.FLAG_NOT_FOCUSABLE
	    	                                   | LayoutParams.FLAG_NOT_TOUCHABLE;
	                 */
	    	             
	    	            
	    	             wmParams.gravity=Gravity.BOTTOM;   //调整悬浮窗口至左上角
	    	             //以屏幕左上角为原点，设置x、y初始值
	    	            wmParams.x=0;
	    	            wmParams.y=0;
	    	             
	    	             //设置悬浮窗口长宽数据
//	                   if(Controls.instance().isPortrait()){
	                	
//	                   }else{
	                	   wmParams.width=android.view.ViewGroup.LayoutParams.MATCH_PARENT;
	                	   if(isPortrait){
	                		   wmParams.height=mHeight/8;  
	                	   }else{
	                		   wmParams.height=mHeight/5;  
	                	   }
	                	 
//	                   }
	                		tapfunsWindowView=new TapfunsWindowView(context);
	                	   StringBuffer sb = new StringBuffer();
	               		sb.append(Constant.appofferUrl);
	               		sb.append("auth="
	               				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
	               		sb.append("&time=" + Constant.getCurrentTime());
	               		sb.append("&appid=" + Constant.appid);
	               			sb.append("&ingetral=" + "No");
	               		sb.append("&type=" + "1");
	            		TapfunsCommandExecute.getInstance().executeGet(context, sb.toString(),
	            				new RequestCallBack() {
	            					@Override
	            					public void getRequestResult(String command) {
	            						AppofferUtil.getIntsance().StrToAppofferParams(command); 
	            						isFlags=true;
	            		 					ImageLoader.getInstance().displayImage(
	            		 							AppofferUtil.getIntsance().getList().get(0).getLogo(), tapfunsWindowView.getImageView());
	            		 					if(wm!=null){
	            		 						wm.addView(tapfunsWindowView, wmParams);
	            		 					}
	            		    	             tapfunsWindowView.getTe_title().setText(AppofferUtil.getIntsance().getList().get(0).getAd_slogan());
	            		    	             tapfunsWindowView.getTe_title1().setText(AppofferUtil.getIntsance().getList().get(0).getAd_desc());
	            					
	            		 					StringBuffer sbf = new StringBuffer();
	            							sbf.append(Constant.appAppCpmApi);
	            							sbf.append("offer_id="
	            									+AppofferUtil.getIntsance().getList().get(0).getOffer_id());
	            							sbf.append("&dev_id=" + AppofferUtil.getIntsance().getList().get(0).getDev_id());
	            							sbf.append("&app_id=" +  AppofferUtil.getIntsance().getList().get(0).getApp_id());
	            							sbf.append("&is_integral=" + AppofferUtil.getIntsance().getList().get(0).getIs_integral());
	            							sbf.append("&ad_type=" + AppofferUtil.getIntsance().getList().get(0).getApp_type());
	            							sbf.append("&android_id=" + Constant.getAndroidID(context));
	            							TapfunsCommandExecute.getInstance().executeGet(context, sbf.toString(),
	            									new RequestCallBack() {

	            										@Override
	            										public void getRequestResult(String msg) {
	            											// TODO Auto-generated method stub
	            											TapfunsLogUtil.logI(msg);
	            										}
	            								
	            							});
	            					
	            					}
	            					});
	            		tapfunsWindowView.getImg_close().setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								  Log.i("mojin", wm+"======================");
								if(wm!=null){
									
									wm.removeView(tapfunsWindowView);
									wm=null;
									isFlags=false;
								}
							}
						});
	            		tapfunsWindowView.getBtn_down().setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
//								Intent intent=new Intent(context, TapfunsWebActivity.class);
//								Bundle bundle=new Bundle();
//								bundle.putString("gameurl", AppofferUtil.getIntsance().getList().get(0).getTracking_link());
//								intent.putExtras(bundle);
//								context.startActivity(intent);
								if (TextUtils.isEmpty(AppofferUtil.getIntsance().getList().get(0).getPackageName())) {
									return;
								}

								Uri uri = Uri.parse("market://details?id="
										+ AppofferUtil.getIntsance().getList().get(0).getPackageName());
								Intent intent = new Intent(Intent.ACTION_VIEW, uri);
								if (isPkgInstalled(context, "com.android.vending")) {
									intent.setPackage("com.android.vending");
								}else{
									return;
								}
								intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								context.startActivity(intent);
								tapfunsWindowView.setVisibility(View.GONE);
//								if(wm!=null){
//									wm.removeView(tapfunsWindowView);
//									wm=null;
//								}
							}
						});
	            		tapfunsWindowView.getLinearLayout3().setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								if (TextUtils.isEmpty(AppofferUtil.getIntsance().getList().get(0).getPackageName())) {
									return;
								}

								Uri uri = Uri.parse("market://details?id="
										+ AppofferUtil.getIntsance().getList().get(0).getPackageName());
								Intent intent = new Intent(Intent.ACTION_VIEW, uri);
								if (isPkgInstalled(context, "com.android.vending")) {
									intent.setPackage("com.android.vending");
								}else{
									return;
								}
								intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								context.startActivity(intent);
								tapfunsWindowView.setVisibility(View.GONE);
							}
						});
	    	             //显示myFloatView图像
	          	    	

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
	  
	  public void onDestroy(){
		  if(wm!=null){
			  if(tapfunsWindowView!=null){
				  
				  wm.removeView(tapfunsWindowView);
			  }
		  }
		  Log.i("mojin", "onDestroy");
		  wm=null;
			isFlags=false;
	  }
    public void onResume(Context context){
    	Log.i("tapfuns", "tapfun Flags ="+isFlags);
    	if(tapfunsWindowView!=null){
    		tapfunsWindowView.setVisibility(View.VISIBLE);
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
