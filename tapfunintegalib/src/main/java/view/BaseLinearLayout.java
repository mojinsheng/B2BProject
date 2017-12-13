package view;

import com.tapfuns.utils.log.TapfunsLogUtil;
import com.tapfuns.utils.res.TapfunsResourceUtil;
import com.tapfuns.utils.tool.TapfunsScreenUtil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import controls.Controls;


public class BaseLinearLayout extends LinearLayout{
	protected int index;
	/**
	 * 屏幕帮助类
	 */
	/**
	 * 屏幕帮助类
	 */
	protected TapfunsScreenUtil mScreen;
	
	/**
	 * 上线文对象
	 */
	protected Context mContext;
	/**
	 * 判断是否是手机设备
	 */
	protected boolean isPhone;
	/**
	 * 设备宽度
	 */
	protected int mWidth;
	/**
	 * 设备高度
	 */
	protected int mHeight;
	/**
	 * margin大小
	 */
	protected int marginSize;
	protected String appPlatform, version, packageName;
	
	protected boolean _isPortrait;
	private String language;
	public BaseLinearLayout(Context context) {
		super(context);
		init(context);
	}
	public BaseLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(context);
	}
	private void init(Context context){
		mContext = context;
		mScreen = TapfunsScreenUtil.getInStance((Activity)mContext);
		_isPortrait = mScreen.isPortrait((Activity)mContext);
		language= Controls.getInstance().getLanguage().toLowerCase();
		//Controls.instance().setPortrait(isPortrait);
		mWidth = mScreen.getPxWidth();
		mHeight= mScreen.getPxHeight();
		isPhone=this.isPhone(context);
		if(_isPortrait){
			marginSize = mWidth / 20;
			index = 1;
		}else{
			marginSize = mWidth / 50;
			index = 0;
		}
	}
	public boolean isPhone(Context context) {

		DisplayMetrics dm = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay()
				.getMetrics(dm);
		int screenX = dm.widthPixels;
		int screenY = dm.heightPixels;
		int dpi = dm.densityDpi;
		float a = screenX / dpi;
		float b = screenY / dpi;
		double screenIn = Math.sqrt(a * a + b * b);

		return (screenIn <= 5.0D);
	}
	public int color(int[] colors){
		return Color.rgb(colors[0], colors[1], colors[2]);
	}
	
	public int createDrawable(String filename){
		return TapfunsResourceUtil.findDrawableIdByName(mContext, filename);
	}
	public String createString(String filename){
			if(!TextUtils.isEmpty(language)){
				filename = language+"_"+filename;
			return TapfunsResourceUtil.findStringByName(mContext, filename);
		}else{
			TapfunsLogUtil.logE("請先設置语言");
			return "";
		}
	}

}
