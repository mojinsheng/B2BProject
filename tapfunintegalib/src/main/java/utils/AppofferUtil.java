package utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import bean.AppofferBean;


public class AppofferUtil {
	List<AppofferBean> list = new ArrayList<AppofferBean>();
	private AppofferBean appofferBean;

	private AppofferUtil() {

	}

	public static AppofferUtil appofferUtil;

	public static AppofferUtil getIntsance() {
		if (appofferUtil == null) {
			return appofferUtil = new AppofferUtil();
		} else {
			return appofferUtil;
		}
	}

	public void StrToAppofferParams(String params) {
		try {
			JSONArray ja = new JSONArray(params);
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jb = ja.getJSONObject(i);
				Log.i("tapfuns", "banner_img=" + jb.optString("banner_img")
						+ ",ad_slogan=" + jb.optString("ad_slogan")
						+ ",ad_desc=" + jb.optString("ad_desc") + ",integral="
						+ jb.optString("integral"));
				appofferBean = new AppofferBean();
				appofferBean.setBanner_img(jb.optString("banner_img", null));
				appofferBean.setAd_slogan(jb.optString("ad_slogan", null));
				appofferBean.setAd_desc(jb.optString("ad_desc", null));
				appofferBean.setIntegral(jb.optString("integral", null));
				appofferBean.setLogo(jb.optString("logo", null));
				appofferBean.setVedio_url(jb.optString("vedio_url", null));
				appofferBean.setTracking_link(jb.optString("tracking_link", ""));
				appofferBean.setApp_id(jb.optString("app_id",""));
				appofferBean.setOffer_id(jb.optString("offer_id"));
				appofferBean.setApp_type(jb.optString("app_type",""));
				appofferBean.setIs_integral(jb.optString("is_integral",""));
				appofferBean.setPackageName(jb.optString("pkg",""));
				list.add(appofferBean);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<AppofferBean> getList() {
		return list;
	}

	public void setList(List<AppofferBean> list) {
		this.list = list;
	}

}
