package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 输入框
 * @author Jesse
 *
 */
public abstract class BaseInputView extends BaseLinearLayout {


	public BaseInputView(Context context) {
		super(context);
		init(context);
	}

	public BaseInputView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		this.setOrientation(LinearLayout.VERTICAL);
		//this.setBackgroundResource(createDrawable("input_shape"));
		LinearLayout linearLayout=null;
		EditText e_inputName;
		LayoutParams params;
		for(int i=0;i<inputNums();i++){
			linearLayout=new LinearLayout(context);
			params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0544)));
			params.gravity = Gravity.CENTER_VERTICAL;
			if (passwordTypes()[i]) {
				params.topMargin=marginSize;
			}
			linearLayout.setBackgroundResource(createDrawable("input_shape"));
			this.addView(linearLayout,params);
			TextView t_phone = new TextView(context);
			t_phone.setText(setInputHints()[i]);
			t_phone.setTextSize(17);
			t_phone.setTextColor(Color.BLACK);
			t_phone.setText(setInputName()[i]);
			//t_phone.getPaint().setFakeBoldText(true);
			t_phone.setGravity(Gravity.CENTER);
			params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
			linearLayout.addView(t_phone, params);

			e_inputName = new EditText(context);
			e_inputName.setBackgroundResource(0);
			e_inputName.setHint(setInputHints()[i]);
			e_inputName.setSingleLine(true);
			params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			params.gravity = Gravity.CENTER_VERTICAL;
			if (passwordTypes()[i]) {
				e_inputName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				//params.topMargin=marginSize;
			}
			e_inputName.setTextColor(Color.BLACK);
			e_inputName.setHintTextColor(Color.GRAY);


			linearLayout.addView(e_inputName, params);
		}

	}


	/**
	 * 设置Hint默认值
	 *
	 * @return
	 */
	public abstract String[] setInputHints();
	public abstract String[] setInputName();
	/**
	 * 设置软键盘点击动作
	 *
	 * @return
	 */
	public abstract int[] setInputImeOptions();

	/**
	 * 设置是否是密码类型
	 *
	 * @return
	 */
	public abstract boolean[] passwordTypes();

	/**
	 * 输入框个数
	 *
	 * @return
	 */
	public abstract int inputNums();
}