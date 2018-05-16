package com.from.dididache.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.from.dididache.view.OrderInfrontionView;

/**
 * 订单明细
 * Created by USER on 2018/5/16.
 */

public class OrderInfromationActivity extends Activity{
    private OrderInfrontionView orderInfrontionView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderInfrontionView=new OrderInfrontionView(this);
        setContentView(orderInfrontionView);
        orderInfrontionView.getback().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
