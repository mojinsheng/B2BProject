package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.from.dididache.R;
import com.from.molibrary.res.EfunResourceUtil;

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

        text_phone.setText(EfunResourceUtil.findStringByName(mContext,"xmy_text_phone"));
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
        e_inputName.setHint(EfunResourceUtil.findStringByName(mContext,"xmy_input_hint_phone"));
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
        e_smsNumber.setHint(EfunResourceUtil.findStringByName(mContext,"xmy_input_hint_smscode"));
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
        e_newpassword.setHint(EfunResourceUtil.findStringByName(mContext,"xmy_input_new_password"));
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

        //下一步，验证手机号
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
        btn_login.setText(EfunResourceUtil.findStringByName(mContext,"xmy_btn_verificationphone"));
        btn_login.setTextColor(Color.WHITE);
        btn_login.setTextSize(20);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        forgetBtnLinearLayout.addView(btn_login,params);

        //设置新密码
        btn_Password=new Button(mContext);
        btn_Password.setBackgroundColor(Color.rgb(26,180,255));
        btn_Password.setText(EfunResourceUtil.findStringByName(mContext,"xmy_btn_newpassword"));
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
            public String getSetName() {
                return null;
            }

            @Override
            public boolean hasSetText() {
                return false;
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
