package com.from.dididache.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListView;

import com.from.dididache.Adaper.MoneyDateilsAdapter;
import com.from.dididache.Adaper.UserAdapter;
import com.from.dididache.Entity.MoneyDateilsBean;
import com.from.dididache.Entity.UserIfon;
import com.from.dididache.view.MoneyDetalisView;

import java.util.ArrayList;
import java.util.List;

/**
 * 余额明细
 * Created by USER on 2018/5/16.
 */

public class MoneyDetailsActivity extends Activity{
    private ListView listView;
    private MoneyDateilsAdapter moneyDateilsAdapter;
    List<MoneyDateilsBean> moneyDateilList=new ArrayList<MoneyDateilsBean>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MoneyDetalisView moneyDetalisView=new MoneyDetalisView(this);
        setContentView(moneyDetalisView);
        init();
        listView=moneyDetalisView.getListView();
        moneyDateilsAdapter=new MoneyDateilsAdapter(moneyDateilList,this);
        listView.setAdapter(moneyDateilsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //我们需要的内容，跳转页面或显示详细信息
                Intent intent=new Intent(MoneyDetailsActivity.this,OrderInfromationActivity.class);
                startActivity(intent);
            }
        });
        moneyDetalisView.getback().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void init() {
        MoneyDateilsBean moneyDateils = new MoneyDateilsBean();
        moneyDateils.setDate("2018-09-09 12:10");
        moneyDateils.setMoney("100");
        moneyDateilList.add(moneyDateils);

        MoneyDateilsBean moneyDateils1 = new MoneyDateilsBean();
        moneyDateils1.setDate("2018-09-09 12:10");
        moneyDateils1.setMoney("100");
        moneyDateilList.add(moneyDateils1);

        MoneyDateilsBean moneyDateils2 = new MoneyDateilsBean();
        moneyDateils2.setDate("2018-09-09 12:10");
        moneyDateils2.setMoney("100");
        moneyDateilList.add(moneyDateils2);

        MoneyDateilsBean moneyDateils3 = new MoneyDateilsBean();
        moneyDateils3.setDate("2018-09-09 12:10");
        moneyDateils3.setMoney("100");
        moneyDateilList.add(moneyDateils3);

        MoneyDateilsBean moneyDateils4 = new MoneyDateilsBean();
        moneyDateils4.setDate("2018-09-09 12:10");
        moneyDateils4.setMoney("100");
        moneyDateilList.add(moneyDateils4);
    }
}
