package com.from.dididache.view;



import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Title
 * @author Jesse
 *
 */
public abstract class BaseTitleView extends BaseRelativeLayout{
	/**
	 * 返回按钮
	 */
	protected ImageView backIV;  //后退键
	protected TextView settingIV;  //修改、绑定
	/**
	 * 标题栏
	 */
	private TextView titleIV;
	public BaseTitleView(Context context) {
		super(context);
		init(context);
	}
	public BaseTitleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	public BaseTitleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}
	private void init(Context context){
		setBackgroundColor(Color.rgb(26,180,255));
		backIV = new ImageView(mContext);
		backIV.setBackgroundResource(createDrawable(getImageViewName()));
		LayoutParams params = new LayoutParams(getBackSize()[0], getBackSize()[1]);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		params.setMargins(marginSize/4, 0, 0, 0);
		if(hasSetButton()){
			this.addView(backIV, params);
		}

		
		titleIV= new TextView(mContext);
		titleIV.setText(createString(titleName()));
		titleIV.setTextColor(Color.WHITE);
		titleIV.setTextSize(23);
		titleIV.setGravity(Gravity.CENTER);
		params = new LayoutParams(getTitleSize()[0], getTitleSize()[1]);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		this.addView(titleIV, params);
//
		settingIV = new TextView(mContext);
		//settingIV.setBackgroundResource(BitmapUtil.createDrawable(mContext, ViewSelecter.EFUN_SET_SELECTER));
		settingIV.setText(createString(getSetName()));
		settingIV.setTextColor(Color.WHITE);
		settingIV.setTextSize(20);
		settingIV.setGravity(Gravity.CENTER);
		params = new LayoutParams(getSetSize()[0], getSetSize()[1]);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		params.setMargins(0, 0, marginSize, 0);
		this.addView(settingIV, params);

		if (hasSetText()) {
			settingIV.setVisibility(View.VISIBLE);
		}
		
	}
	/**
	 * 标题资源名称
	 * @return
	 */
	public abstract String titleName();
	/**
	 * 返回按钮长宽
	 * @return
	 */
	public abstract int[] getBackSize();
	/**
	 * 标题长宽
	 * @return
	 */
	public abstract int[] getTitleSize();
	/**
	 * 设置按钮长宽
	 * @return
	 */
	public abstract int[] getSetSize();
	/**
	 * 是否包含设置按钮
	 * @return
	 */
	public abstract boolean hasSetButton();
	/**
	 * 设置按钮名称
	 * @return
	 */
	public abstract String getSetName();
	/**
	 * 图片名称
	 * @return
	 */
	public abstract String getImageViewName();
	/**
	* 是否包含设置按钮
	* @return
	*/
	public abstract boolean hasSetText();
	
}
