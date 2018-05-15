package com.from.dididache.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.from.dididache.view.RegisterView;

/**
 * Created by USER on 2018/5/10.
 */

public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegisterView registerView=new RegisterView(this);
        setContentView(registerView);
        //返回键
        registerView.getImgBcak().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
