package com.from.dididache.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.from.dididache.view.PercenterView;
import com.from.dididache.view.PersonCenterView;

/**
 * 个人信息
 * Created by USER on 2018/5/12.
 */

public class PersonCenterActivity extends Activity{
    private RelativeLayout personRelativeLayout,orderRelativeLayout,moneyoveRelativeLayout;
    private LinearLayout bindLinearLayout;
    private ImageView img_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PersonCenterView percenterView=new PersonCenterView(this);
        setContentView(percenterView);
        //个人信息
        personRelativeLayout=percenterView.getPersonRelativeLayout();
        bindLinearLayout=percenterView.getLinearLayout();
        img_back=percenterView.getImgBcak();
        //订单
        orderRelativeLayout=percenterView.getOrderRelativeLayout();
        //余额
        moneyoveRelativeLayout=percenterView.getMoneyoveRelativeLayout();
        personRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonCenterActivity.this,PersonInfornationActivity.class);
                startActivity(intent);
            }
        });
        bindLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonCenterActivity.this,BindPhoneActivity.class);
                startActivity(intent);
            }
        });
        orderRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonCenterActivity.this,OrderDetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putBoolean("flag",true);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        moneyoveRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonCenterActivity.this,MoneyoveActivity.class);
                startActivity(intent);
            }
        });
    }
}
