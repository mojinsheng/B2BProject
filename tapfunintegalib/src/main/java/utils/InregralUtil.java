package utils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import bean.InregralBean;


public class InregralUtil {
	List<InregralBean> list = new ArrayList<InregralBean>();
	private InregralBean inregralBean;

	private InregralUtil() {

	}

	public static InregralUtil inregralUtil;

	public static InregralUtil getIntsance() {
		if (inregralUtil == null) {
			return inregralUtil = new InregralUtil();
		} else {
			return inregralUtil;
		}
	}

	public void StrToInregralParams(String params) {
		try {
			JSONArray ja = new JSONArray(params);
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jb = ja.getJSONObject(i);
				Log.i("tapfuns",
						"total_integral=" + jb.optString("total_integral")
								+ ",integral=" + jb.optString("integral")
								+ ",desc=" + jb.optString("desc") + ",logo="
								+ jb.optString("logo"));
				inregralBean = new InregralBean();
				inregralBean.setTotal_integral(jb.optString("total_integral",
						""));
				inregralBean.setIntegral(Double.parseDouble(jb.optString(
						"integral", "-1")));
				inregralBean.setDesc(jb.optString("desc", ""));
				// inregralBean.setConversion_time(jb.optString("conversion_time",""));
				String conversion_time = jb.optString("conversion_time", "");
				if (conversion_time.equals("null")
						|| conversion_time.equals("")
						|| conversion_time == null) {
					inregralBean.setConversion_time(0);
				} else {
					inregralBean.setConversion_time(Long.parseLong(conversion_time));
				}
				String offer_name = jb.optString("offer_name", "");
				if (offer_name.equals("null") || offer_name.equals("")
						|| offer_name == null) {
					inregralBean.setOffer_name("");
				} else {

					inregralBean.setOffer_name(offer_name);
				}
				inregralBean.setLogo(jb.optString("logo", ""));
				list.add(inregralBean);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<InregralBean> getList() {
		return list;
	}

	public void setList(List<InregralBean> list) {
		this.list = list;
	}

}
