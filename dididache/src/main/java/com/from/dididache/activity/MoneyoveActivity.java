package com.from.dididache.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.from.dididache.view.MoneyoveView;

/**
 * 显示余额
 * Created by USER on 2018/5/16.
 */

public class MoneyoveActivity extends Activity{
    private MoneyoveView moneyoveView=null;
    private Button btn_extract;
    private ImageView img_back;
    private TextView text_mneyDateils;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moneyoveView=new MoneyoveView(this);
        setContentView(moneyoveView);
        btn_extract=moneyoveView.getBtnExtract();
        text_mneyDateils=moneyoveView.getTextMoneyDetails();
        btn_extract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MoneyoveActivity.this,ExtractMoneyActivity.class);
                startActivity(intent);
            }
        });
        img_back=moneyoveView.getBack();
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();;
            }
        });
        text_mneyDateils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MoneyoveActivity.this,MoneyDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
