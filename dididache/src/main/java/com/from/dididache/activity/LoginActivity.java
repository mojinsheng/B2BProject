package com.from.dididache.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.from.dididache.view.LoginView;
import com.from.molibrary.logUtil.LogUtil;

/**
 * 司机登录
 * Created by USER on 2018/4/3.
 */

public class LoginActivity extends Activity {
    private TextView text_forget,text_register;
    private Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.getInstance().isFlag=true;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        LoginView loginView=new LoginView(this);
        setContentView(loginView);
        text_forget=loginView.getTextForget();
        text_register=loginView.getTextRegister();
        btn_login=loginView.getBtnLogin();
        text_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
        text_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,PercenterActivity.class);
                startActivity(intent);
            }
        });
    }
}
