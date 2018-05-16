package com.from.dididache.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.from.dididache.view.ExtractMoneyView;

/**
 * 提取现金
 * Created by USER on 2018/5/16.
 */

public class ExtractMoneyActivity extends Activity {
    private ExtractMoneyView extractMoneyView;
    private ImageView img_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extractMoneyView=new ExtractMoneyView(this);
        setContentView(extractMoneyView);
        img_back=extractMoneyView.getBack();
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();;
            }
        });

    }
}
