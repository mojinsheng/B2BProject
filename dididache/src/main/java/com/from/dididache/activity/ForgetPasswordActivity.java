package com.from.dididache.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.from.dididache.view.ForgetPasswordView;
import com.from.dididache.view.LineEditText;
import com.from.molibrary.logUtil.LogUtil;
import com.from.molibrary.util.XmyRegular;

/**
 * 忘记密码
 * Created by USER on 2018/5/10.
 */

public class ForgetPasswordActivity extends Activity {
    private Button btn_Login,btn_Password,btnNewPassword;
    private String phone;
    private TextView sms_infornation,time_phone;
    private EditText e_smsNumber,e_inputName,e_newPassword;
    private ForgetPasswordView forgetView;
    private TimeCount time;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         forgetView=new ForgetPasswordView(this);
        setContentView(forgetView);

        btn_Login=forgetView.getBtnLogin();
        sms_infornation=forgetView.getSmsInfornation();
        time_phone=forgetView.getTimePhone();
        e_inputName=forgetView.getInputName();

        e_smsNumber=forgetView.getSmsNumber();
        btn_Password=forgetView.getbtnPassword();
        btnNewPassword=forgetView.btnNewPassword();
        e_newPassword=forgetView.geteNewPassword();
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone=forgetView.getInputName().getText().toString();
                LogUtil.getInstance().logI("手机号码:"+phone);
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(ForgetPasswordActivity.this,"手机号不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!XmyRegular.isMobile(phone)){
                    Toast.makeText(ForgetPasswordActivity.this,"请输入正确的手机号",Toast.LENGTH_LONG).show();
                    return;
                }

                sms_infornation.setVisibility(View.VISIBLE);
                time_phone.setVisibility(View.VISIBLE);
                sms_infornation.setText("短信验证嘛已发送至"+phone);
                //btnLogin.setText("下一步，设置新密码");
                e_smsNumber.setVisibility(View.VISIBLE);
                e_inputName.setVisibility(View.GONE);
                btn_Login.setVisibility(View.GONE);
                btn_Password.setVisibility(View.VISIBLE);
                time = new TimeCount(30000, 1000);
                time.start();
            }
        });
        btn_Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e_smsNumber.setVisibility(View.GONE);
                time_phone.setVisibility(View.GONE);
                btn_Password.setVisibility(View.GONE);
                btnNewPassword.setVisibility(View.VISIBLE);
                e_newPassword.setVisibility(View.VISIBLE);
                sms_infornation.setVisibility(View.GONE);
            }
        });
        //返回键
        forgetView.getImgBcak().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            //time_phone.setBackgroundColor(Color.parseColor("#B6B6D8"));
            time_phone.setClickable(false);
            time_phone.setText(millisUntilFinished / 1000 +"s");
        }

        @Override
        public void onFinish() {
            time_phone.setVisibility(View.GONE);
//            btnGetcode.setText("重新获取验证码");
//            btnGetcode.setClickable(true);
//            btnGetcode.setBackgroundColor(Color.parseColor("#4EB84A"));

        }
    }

}
