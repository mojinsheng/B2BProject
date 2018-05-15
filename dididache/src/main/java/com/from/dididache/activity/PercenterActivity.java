package com.from.dididache.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.from.dididache.Adaper.UserAdapter;
import com.from.dididache.Entity.UserIfon;
import com.from.dididache.MainActivity;
import com.from.dididache.view.PercenterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2018/4/3.
 */

public class PercenterActivity extends Activity{
    private ListView listView;
    private List<UserIfon> userList=new ArrayList<UserIfon>();
    private Button btn_Shuttle;
    private LinearLayout orderLinearLayout,unorderLinearLayout;
    private View unorderView,orderView;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        init();
        PercenterView percenterView=new PercenterView(this);
        setContentView(percenterView);
        //信息列表
        listView=percenterView.getListView();
        //待接单
        orderLinearLayout=percenterView.getOrderLinearLayout();
        //已接单
        unorderLinearLayout=percenterView.getUnorderLinearLayout();
        //蓝色下划线
        unorderView=percenterView.getUnorderView();
        orderView=percenterView.getorderView();

        listView.setDivider(new ColorDrawable(Color.GRAY));
        listView.setDividerHeight(1);
        listView.addHeaderView(new ViewStub(this));
        userAdapter=new UserAdapter(userList,this,false);
        listView.setAdapter(userAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //我们需要的内容，跳转页面或显示详细信息
                Intent intent=new Intent(PercenterActivity.this,ShuttlePassengerActivity.class);
                startActivity(intent);
            }
        });
        //已接单
        orderLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unorderView.setVisibility(View.GONE);
                orderView.setVisibility(View.VISIBLE);
                userAdapter=new UserAdapter(userList,PercenterActivity.this,true);
                listView.setAdapter(userAdapter);
            }
        });
        //未接待
        unorderLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderView.setVisibility(View.GONE);
                unorderView.setVisibility(View.VISIBLE);
                userAdapter=new UserAdapter(userList,PercenterActivity.this,false);
                listView.setAdapter(userAdapter);
            }
        });

        percenterView.getPersonCenter().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PercenterActivity.this,PersonCenterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init(){
        UserIfon userIfon=new UserIfon();
        userIfon.setUername("张三");
        userIfon.setToDayDate("今天"+"17:00");
        userIfon.setStartPosition("天河商社");
        userIfon.setEndPostition("番禺塘步东");
        userIfon.setMoney("50");
        userList.add(userIfon);

        UserIfon userIfon2=new UserIfon();
        userIfon2.setUername("李四张三");
        userIfon2.setToDayDate("今天"+"17:00");
        userIfon2.setStartPosition("天河商社");
        userIfon2.setEndPostition("番禺塘步东");
        userIfon2.setMoney("60");
        userList.add(userIfon2);

        UserIfon userIfon3=new UserIfon();
        userIfon3.setUername("王五");
        userIfon3.setToDayDate("今天"+"17:00");
        userIfon3.setStartPosition("天河商社");
        userIfon3.setEndPostition("番禺塘步东");
        userIfon3.setMoney("70");
        userList.add(userIfon3);

        UserIfon userIfon4=new UserIfon();
        userIfon4.setUername("刘六");
        userIfon4.setToDayDate("今天"+"17:00");
        userIfon4.setStartPosition("天河商社");
        userIfon4.setEndPostition("番禺塘步东");
        userIfon4.setMoney("80");
        userList.add(userIfon4);

        UserIfon userIfon5=new UserIfon();
        userIfon5.setUername("何七");
        userIfon5.setToDayDate("今天"+"17:00");
        userIfon5.setStartPosition("天河商社");
        userIfon5.setEndPostition("番禺塘步东");
        userIfon5.setMoney("90");
        userList.add(userIfon5);

        UserIfon userIfon6=new UserIfon();
        userIfon6.setUername("陈八");
        userIfon6.setToDayDate("今天"+"17:00");
        userIfon6.setStartPosition("天河商社");
        userIfon6.setEndPostition("番禺塘步东");
        userIfon6.setMoney("100");
        userList.add(userIfon6);

        UserIfon userIfon7=new UserIfon();
        userIfon7.setUername("麦九");
        userIfon7.setToDayDate("今天"+"17:00");
        userIfon7.setStartPosition("天河商社");
        userIfon7.setEndPostition("番禺塘步东");
        userIfon7.setMoney("110");
        userList.add(userIfon7);

        UserIfon userIfon8=new UserIfon();
        userIfon8.setUername("莫十");
        userIfon8.setToDayDate("今天"+"17:00");
        userIfon8.setStartPosition("天河商社");
        userIfon8.setEndPostition("番禺塘步东");
        userIfon8.setMoney("120");
        userList.add(userIfon8);


    }
}
