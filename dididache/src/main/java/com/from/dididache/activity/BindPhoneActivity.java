package com.from.dididache.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.from.dididache.view.BindPhoneView;

/**
 * Created by USER on 2018/5/12.
 */

public class BindPhoneActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BindPhoneView bindPhoneView=new BindPhoneView(this);
        setContentView(bindPhoneView);
    }
}
