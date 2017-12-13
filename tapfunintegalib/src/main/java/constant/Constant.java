package constant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.tapfuns.utils.log.TapfunsLogUtil;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

public class Constant {
	
	public static String appid, app_key = null;
	// key值
	public static String tapfunsKeys = "promaodx_nxRlfpLujGCjWfxOmP2c86IATWCH5_zx";
	// 初始化的链接
	public static String adsInitUrl = "http://sdk.promoadx.com/api/appauth/check?";
	// 应用广告链接
	public static String appofferUrl = "http://sdk.promoadx.com/api/appoffer/getoffer?";
	//CPM展示数
	public static String appAppCpmApi = "http://sdk.promoadx.com/promoadxAppCpmApi.php?";
	// 增加积分链接
	public static String createofferUrl = "http://sdk.promoadx.comapi/integral/create?";
	// 减少积分链接
	public static String deleteofferUrl = "http://sdk.promoadx.com/api/integral/delete?";
	// 积分墙链接
	public static String inregralUrl = "http://sdk.promoadx.com/api/integral/getuser?";
    //視頻開始
	public static String AppVideoApi="http://sdk.promoadx.com/promoadxAppVideoApi.php?";
	//視頻結束
	public static String AppVideoEndApi="http://sdk.promoadx.com/promoadxAppVideoEndApi.php?";
	//google ID
	public static String google_advertising_id=null;
	// 获取当前时间
	public static String getCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		return df.format(new Date()) + "";// new Date()为获取当前系统时间
	}
	public static String getCurrentTime(Long date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		return df.format(date) + "";// new Date()为获取当前系统时间
	}
	public static String getAndroidID(Context context){
		String androidId = ""
				+ android.provider.Settings.Secure.getString(
						context.getContentResolver(),
						android.provider.Settings.Secure.ANDROID_ID);
			return androidId;
	}
	
	@SuppressLint("NewApi") 
	public static void getGoogle_advertising_id (final Context context){
		AsyncTask.execute(new Runnable() {
	        @Override
	        public void run() {
	            try {
	            	google_advertising_id= AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
		            if (google_advertising_id != null) {
		            	google_advertising_id = google_advertising_id;
		            	TapfunsLogUtil.logI("google_advertising_id:>>>>>>" + google_advertising_id);		            	
		            }else{
		            	TapfunsLogUtil.logI("gaid(google_advertising_id) is null");
		            }
		        } catch (IllegalStateException e) {
		            e.printStackTrace();
		        } catch (GooglePlayServicesRepairableException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (GooglePlayServicesNotAvailableException e) {
		            e.printStackTrace();
		        }
	        }
	    });	
	}

	public static String IMAGEVIEW_WITH_INTEGRAL = "IMAGEVIEW_WITH_INTEGRAL";
	public static String IMAGEVIEW_WITHOUT_INTEGRAL = "IMAGEVIEW_WITHOUT_INTEGRAL";
	public static String IMAGEVIEW_SIMPLEININSERT = "IMAGEVIEW_SIMPLEININSERT";
  

}
