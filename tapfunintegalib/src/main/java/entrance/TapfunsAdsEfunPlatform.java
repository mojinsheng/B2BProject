package entrance;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.tapfuns.utils.log.TapfunsLogUtil;
import com.tapfuns.utils.task.RequestCallBack;
import com.tapfuns.utils.task.TapfunsCommandExecute;
import com.tapfuns.utils.tool.Utils;

import activity.AdsInformationActivity;
import activity.AlertVideoActivity;
import activity.TapfunsAdsInergral;
import activity.TapfunsVideoActivity;
import activity.WallActivity;
import constant.Constant;
import controls.Controls;

public class TapfunsAdsEfunPlatform {
	public static TapfunsAdsEfunPlatform tapfunsAdsEfunPlatform;

	private TapfunsAdsEfunPlatform() {

	}

	public static TapfunsAdsEfunPlatform getInstance() {
		if (tapfunsAdsEfunPlatform == null) {
			return tapfunsAdsEfunPlatform = new TapfunsAdsEfunPlatform();
		} else {
			return tapfunsAdsEfunPlatform;
		}
	}
	/**
	 * 初始化
	 * @param context
	 * @param appid
	 * @param app_key
	 */

	public void tapfunsAdsInit(final Context context, String appid,
			String app_key) {
		Constant.app_key = app_key;
		Constant.appid = appid;
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.adsInitUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + appid);
		sb.append("&app_key=" + app_key);
		sb.append("&app_package=" + context.getPackageName());
		Constant.getGoogle_advertising_id(context);
		TapfunsCommandExecute.getInstance().executeGet(context, sb.toString(),
				new RequestCallBack() {
					@Override
					public void getRequestResult(String command) {
						try {
							JSONObject jb = new JSONObject(command);
							int status = Integer.parseInt(jb
									.optString("status"));
							if (status != 200) {
								Toast.makeText(context, "初始化失败",
										Toast.LENGTH_LONG).show();
							}
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				});

	}
	/**
	 * 設置语言
	 * @param language
	 */
	public void tapfunsSetLanguage(String language){
		Controls.getInstance().setLanguage(language);
	}
	/**
	 * 积分墙
	 * @param context
	 */
	public void tapfunsWallAd(Context context){
		Intent intent = new Intent(context,
				WallActivity.class);
		context.startActivity(intent);
	}
	/**
	 * 弹屏广告TapfunsAdsInergral
	 * @param context
	 * @param flags
	 */
	public void tapfunsAlertAD(Context context,String flags){
		Intent intent = new Intent(context,
				TapfunsAdsInergral.class);
		Bundle bundle=new Bundle();
		bundle.putString("flags", flags);
		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	/**
	 * 全屏广告TapfunsVideoActivity
	 * @param context
	 */
	public void tapfunsFullVideoAd(Context context){
		Intent intent = new Intent(context,
				TapfunsVideoActivity.class);
		context.startActivity(intent);
	}
	/**
	 * 弹屏屏广告AlertVideoActivity
	 * @param context
	 */
	public void tapfunsAlertVideoAd(Context context){
		Intent intent = new Intent(context,
				AlertVideoActivity.class);
		context.startActivity(intent);
	}
	/**
	 * 广告信息流AdsInformationActivity
	 * @param context
	 */
	public void tapfunsADInformation(Context context){
		Intent intent = new Intent(context,
				AdsInformationActivity.class);
		context.startActivity(intent);
	}
	/**
	 * 增加积分
	 * @param context
	 * @param integral
	 * @param desc
	 */
    public void tapfunsAddPoint(final Context context,String integral,String desc,String userID){

		String androidId = ""
				+ android.provider.Settings.Secure.getString(
						context.getContentResolver(),
						android.provider.Settings.Secure.ANDROID_ID);
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.createofferUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + Constant.appid);
		sb.append("&ingetral=No");
		sb.append("&app_user_id="+userID);
		sb.append("&integral="+integral);
		sb.append("&desc="+desc);
		sb.append("&type=3");
		sb.append("&clint_id="+Constant.getAndroidID(context));
	
		TapfunsCommandExecute.getInstance().executeGet(context, sb.toString(),new RequestCallBack() {
			
			@Override
			public void getRequestResult(String paramString) {
				// TODO Auto-generated method stub
				TapfunsLogUtil.logI(paramString);
				Toast.makeText(context, "Increase Integrals Success!", Toast.LENGTH_LONG).show();
			}
		});
	
    }
    /**
     * 减少积分
     * @param context
     * @param integral
     * @param desc
     */
    public void tapfunsReducePoint(final Context context,String integral,String desc,String userID){

		String androidId = ""
				+ android.provider.Settings.Secure.getString(
						context.getContentResolver(),
						android.provider.Settings.Secure.ANDROID_ID);
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.deleteofferUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + Constant.appid);
		sb.append("&ingetral=No");
		sb.append("&app_user_id="+userID);
		sb.append("&integral="+integral);
		sb.append("&desc="+desc);
		sb.append("&type=3");
		sb.append("&clint_id="+Constant.getAndroidID(context));
		TapfunsCommandExecute.getInstance().executeGet(context, sb.toString(),new RequestCallBack() {
			
			@Override
			public void getRequestResult(String paramString) {
				// TODO Auto-generated method stub
				TapfunsLogUtil.logI(paramString);
				Toast.makeText(context, "Decrease Integrals Success!", Toast.LENGTH_LONG).show();
			}
		});
	
    }
	

}
