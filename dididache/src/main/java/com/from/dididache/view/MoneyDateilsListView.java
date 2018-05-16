package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by USER on 2018/5/16.
 */

public class MoneyDateilsListView extends BaseLinearLayout{
    private RelativeLayout clientPayRelativeLayout;
    private RelativeLayout.LayoutParams layoutParams;
    private LinearLayout clientPayLinearLayout;
    private LayoutParams params;
    private TextView text_cientPay,tetx_payDate,text_payMoney;
    private View lineView;
    public MoneyDateilsListView(Context context) {
        super(context);
        init();
    }
    public void init(){
        clientPayRelativeLayout=new RelativeLayout(mContext);
        clientPayRelativeLayout.setBackgroundColor(Color.WHITE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0987)));
        this.addView(clientPayRelativeLayout,params);

        //显示乘客付款和付款时间
        clientPayLinearLayout=new LinearLayout(mContext);
        clientPayLinearLayout.setOrientation(LinearLayout.VERTICAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.setMargins(marginSize/2,marginSize/2,0,marginSize/2);
        clientPayRelativeLayout.addView(clientPayLinearLayout,layoutParams);

        text_cientPay=new TextView(mContext);
        text_cientPay.setText("乘客付款");
        text_cientPay.setTextSize(20);
        text_cientPay.setGravity(Gravity.CENTER);
        text_cientPay.setTextColor(Color.BLACK);
        text_cientPay.getPaint().setFakeBoldText(true);
        params=new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,1);
        clientPayLinearLayout.addView(text_cientPay,params);

        tetx_payDate=new TextView(mContext);
        tetx_payDate.setText("2018-05-05 12:12");
        tetx_payDate.setTextSize(16);
        tetx_payDate.setGravity(Gravity.CENTER);
        tetx_payDate.setTextColor(Color.GRAY);
        tetx_payDate.getPaint().setFakeBoldText(true);
        params=new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,1);
        clientPayLinearLayout.addView(tetx_payDate,params);

        text_payMoney=new TextView(mContext);
        text_payMoney.setText("+100");
        text_payMoney.setTextSize(20);
        text_payMoney.setGravity(Gravity.CENTER);
        text_payMoney.setTextColor(Color.BLACK);
        text_payMoney.getPaint().setFakeBoldText(true);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams.setMargins(0,marginSize/2,marginSize/2,marginSize/2);
        clientPayRelativeLayout.addView(text_payMoney,layoutParams);

        lineView=new View(mContext);
        lineView.setBackgroundColor(Color.rgb(216,216,216));
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                marginSize/8);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        clientPayRelativeLayout.addView(lineView,layoutParams);
    }
    public TextView getTetxPayDate(){
        return tetx_payDate;
    }
    public TextView getTextPayMoney(){
        return text_payMoney;
    }
}
