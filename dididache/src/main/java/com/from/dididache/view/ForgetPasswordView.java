package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.from.dididache.R;

/**
 * Created by USER on 2018/5/10.
 */

public class ForgetPasswordView extends BaseLinearLayout {

    private Context mContext;
    private BaseTitleView baseTitleView;
    private LinearLayout mContainerLayout;
    private LinearLayout forgetPwdLinearLayout,forgetPwdContentLinearLayout,forgetBtnLinearLayout;
    private LinearLayout phoneLinearLayout,loginInputLinearLayout,underlineLinearLayout;
    private LayoutParams params;
    private TextView text_phone,sms_infornation,time_phone;
    private Button btn_login,btn_Password,btn_NewPassword;
    private  LineEditText e_inputName,e_smsNumber,e_newpassword;
    public ForgetPasswordView(Context _context) {
        super(_context);
        mContext=_context;
        init(_context);
    }

    public void init(Context context){

        mContainerLayout=new LinearLayout(mContext);
        mContainerLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mContainerLayout.setBackgroundColor(Color.rgb(242,242,242));
        this.addView(mContainerLayout,params);

        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0607)));
        mContainerLayout.addView(baseTitleView, params);

       //找回密码布局
        forgetPwdLinearLayout=new LinearLayout(mContext);
        forgetPwdLinearLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.4085)));
        mContainerLayout.addView(forgetPwdLinearLayout,params);

        forgetPwdContentLinearLayout=new LinearLayout(mContext);
        forgetPwdContentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.285)));
        params.topMargin=((int)(mHeight*0.1));
        forgetPwdLinearLayout.addView(forgetPwdContentLinearLayout,params);

        //输入手机号文字显示

        phoneLinearLayout=new LinearLayout(context);
        //phoneLinearLayout.setBackgroundColor(Color.BLUE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(marginSize*1.5)));
        forgetPwdContentLinearLayout.addView(phoneLinearLayout,params);


        text_phone=new TextView(mContext);

        text_phone.setText("请输入手机号码");
        text_phone.setTextSize(16);
        text_phone.setTextColor(Color.BLACK);
        text_phone.setGravity(Gravity.CENTER);


        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        params.gravity=Gravity.CENTER;
        phoneLinearLayout.addView(text_phone,params);


        //输入手机号文字显示

        phoneLinearLayout=new LinearLayout(context);
        //phoneLinearLayout.setBackgroundColor(Color.BLUE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(marginSize*1.5)));
        forgetPwdContentLinearLayout.addView(phoneLinearLayout,params);


        sms_infornation=new TextView(mContext);

        sms_infornation.setText("短信验证嘛已发送至");
        sms_infornation.setTextSize(16);
        sms_infornation.setTextColor(Color.GRAY);
        sms_infornation.setGravity(Gravity.CENTER);
        sms_infornation.setVisibility(View.GONE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        params.gravity=Gravity.CENTER;
        phoneLinearLayout.addView(sms_infornation,params);

        //输入手机号
        loginInputLinearLayout=new LinearLayout(mContext);
        loginInputLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.topMargin=marginSize;
        params.leftMargin=marginSize*3;
        params.rightMargin=marginSize*3;
        forgetPwdContentLinearLayout.addView(loginInputLinearLayout,params);

        e_inputName=new LineEditText(mContext);
        e_inputName.setBackgroundResource(0);
        e_inputName.setHint("手机号码");
        e_inputName.setSingleLine(true);
        e_inputName.setLines(R.color.start_button_color);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        if (false) {
            e_inputName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            //params.topMargin=marginSize;
        }
        e_inputName.setTextColor(Color.BLACK);
        e_inputName.setHintTextColor(Color.GRAY);
        loginInputLinearLayout.addView(e_inputName,params);

        //验证码
        e_smsNumber=new LineEditText(mContext);
        e_smsNumber.setBackgroundResource(0);
        e_smsNumber.setHint("短信验证码");
        e_smsNumber.setSingleLine(true);
        e_smsNumber.setLines(R.color.start_button_color);
        params=new LayoutParams((int)(mWidth*0.6),LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        if (false) {
            e_inputName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            //params.topMargin=marginSize;
        }
        e_smsNumber.setTextColor(Color.BLACK);
        e_smsNumber.setHintTextColor(Color.GRAY);
        e_smsNumber.setVisibility(View.GONE);
        loginInputLinearLayout.addView(e_smsNumber,params);

        //新密码
        e_newpassword=new LineEditText(mContext);
        e_newpassword.setBackgroundResource(0);
        e_newpassword.setHint("新登录密码");
        e_newpassword.setSingleLine(true);
        e_newpassword.setLines(R.color.start_button_color);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        if (false) {
            e_inputName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            //params.topMargin=marginSize;
        }
        e_newpassword.setTextColor(Color.BLACK);
        e_newpassword.setHintTextColor(Color.GRAY);
        e_newpassword.setVisibility(View.GONE);
        loginInputLinearLayout.addView(e_newpassword,params);

        time_phone=new TextView(mContext);
        //time_phone.setBackgroundColor(Color.BLUE);
        time_phone.setText("");
        time_phone.setTextSize(16);
        time_phone.setTextColor(Color.BLACK);
        time_phone.setGravity(Gravity.CENTER);
        time_phone.setVisibility(View.GONE);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        params.gravity=Gravity.CENTER;
       // phoneLinearLayout.addView(text_phone,params);
        loginInputLinearLayout.addView(time_phone,params);




        //下划线
        underlineLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize/8);
        params.leftMargin=marginSize*3;
        params.rightMargin=marginSize*3;
        underlineLinearLayout.setBackgroundResource(createDrawable("xmy_underline"));
        forgetPwdContentLinearLayout.addView(underlineLinearLayout,params);

        //找回密码按钮
        forgetBtnLinearLayout=new LinearLayout(mContext);
        forgetBtnLinearLayout.setBackgroundColor(Color.BLUE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.leftMargin=marginSize*3;
        params.rightMargin=marginSize*3;
        params.topMargin=marginSize;
        forgetBtnLinearLayout.setBackgroundResource(createDrawable("xmy_underline"));
        forgetPwdContentLinearLayout.addView(forgetBtnLinearLayout,params);

        btn_login=new Button(mContext);
        btn_login.setBackgroundColor(Color.rgb(26,180,255));
        btn_login.setText("下一步，验证手机号");
        btn_login.setTextColor(Color.WHITE);
        btn_login.setTextSize(20);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        forgetBtnLinearLayout.addView(btn_login,params);

        //设置验证码按钮
        btn_Password=new Button(mContext);
        btn_Password.setBackgroundColor(Color.rgb(26,180,255));
        btn_Password.setText("下一步，设置新密码");
        btn_Password.setTextColor(Color.WHITE);
        btn_Password.setTextSize(20);
        btn_Password.setVisibility(View.GONE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        forgetBtnLinearLayout.addView(btn_Password,params);

        //设置新密码
        btn_NewPassword=new Button(mContext);
        btn_NewPassword.setBackgroundColor(Color.rgb(26,180,255));
        btn_NewPassword.setText("完成");
        btn_NewPassword.setTextColor(Color.WHITE);
        btn_NewPassword.setTextSize(20);
        btn_NewPassword.setVisibility(View.GONE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        forgetBtnLinearLayout.addView(btn_NewPassword,params);
    }
    public Button getBtnLogin(){
        return btn_login;
    }
    public Button getbtnPassword(){
        return btn_Password;
    }
    public LineEditText getInputName(){
        return e_inputName;
    }
    public TextView getSmsInfornation(){
        return sms_infornation;
    }
    public TextView getTimePhone(){
        return time_phone;
    }
    public EditText getSmsNumber(){
        return e_smsNumber;
    }
    public EditText geteNewPassword(){
        return e_newpassword;
    }
    public Button btnNewPassword(){
        return btn_NewPassword;
    }
    public ImageView getImgBcak(){
        return baseTitleView.backIV;
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(mContext) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_forgetpwd";
            }

            @Override
            public int[] getTitleSize() {
                height = (int) ( marginSize*1.5);
                width = (int) (marginSize*3.5);
                return new int[] { LayoutParams.WRAP_CONTENT, height };
            }

            @Override
            public int[] getBackSize() {
                height = (int) ( marginSize*2);
                width = height;
                return new int[] { width, height };
            }

            @Override
            public int[] getSetSize() {
                height = (int) ( marginSize);
                width = height;
                return new int[] { width, height };
            }

            @Override
            public String getImageViewName() {
                return "xmy_back";
            }

            @Override
            public boolean hasSetButton() {
                return true;
            }

        };
    }

}
