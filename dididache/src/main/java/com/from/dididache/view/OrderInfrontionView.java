package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 订单明细
 * Created by USER on 2018/5/16.
 */

public class OrderInfrontionView extends BaseLinearLayout{
    private LinearLayout mContainerLayout,clientPayLinearLayout;
    private BaseTitleView baseTitleView;
    private RelativeLayout orderRelativeLayout,clientPayRelativeLayout;
    private LayoutParams params;
    private TextView text_cientPay,text_payMoney,text_payType,text_datekey,text_dateValue
            ,text_orderkey,text_orderValue;
    private RelativeLayout.LayoutParams layoutParams;
    private View lineView;
    public OrderInfrontionView(Context context) {
        super(context);
        init();
    }
    private void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        this.setBackgroundColor(Color.WHITE);
        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0607)));
        this.addView(baseTitleView, params);

        clientPayRelativeLayout=new RelativeLayout(mContext);
        clientPayRelativeLayout.setBackgroundColor(Color.WHITE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.15987)));
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
        text_cientPay.setText("入账金额");
        text_cientPay.setTextSize(18);
        text_cientPay.setGravity(Gravity.CENTER);
        text_cientPay.setTextColor(Color.rgb(175,175,175));
        text_cientPay.getPaint().setFakeBoldText(true);
        params=new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,1);
        clientPayLinearLayout.addView(text_cientPay,params);

        text_payMoney=new TextView(mContext);
        text_payMoney.setText("+100");
        text_payMoney.setTextSize(30);
        text_payMoney.setGravity(Gravity.CENTER);
        text_payMoney.setTextColor(Color.BLUE);
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

        //收入明细

        //输入类型
        clientPayRelativeLayout=new RelativeLayout(mContext);
        clientPayRelativeLayout.setBackgroundColor(Color.WHITE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        params.setMargins(marginSize,marginSize,marginSize,0);
        this.addView(clientPayRelativeLayout,params);

        text_payType=new TextView(mContext);
        text_payType.setText("类型");
        text_payType.setTextSize(18);
        text_payType.setGravity(Gravity.CENTER);
        text_payType.setTextColor(Color.rgb(175,175,175));
        text_payType.getPaint().setFakeBoldText(true);
        params=new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1);

        clientPayRelativeLayout.addView(text_payType,params);

        text_payMoney=new TextView(mContext);
        text_payMoney.setText("收入");
        text_payMoney.setTextSize(18);
        text_payMoney.setGravity(Gravity.CENTER);
        text_payMoney.setTextColor(Color.BLACK);
        text_payMoney.getPaint().setFakeBoldText(true);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        //layoutParams.setMargins(0,marginSize/2,marginSize/2,marginSize/2);
        clientPayRelativeLayout.addView(text_payMoney,layoutParams);


        //s时间
        clientPayRelativeLayout=new RelativeLayout(mContext);
        clientPayRelativeLayout.setBackgroundColor(Color.WHITE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        params.setMargins(marginSize,marginSize,marginSize,0);
        this.addView(clientPayRelativeLayout,params);

        text_datekey=new TextView(mContext);
        text_datekey.setText("时间:");
        text_datekey.setTextSize(18);
        text_datekey.setGravity(Gravity.CENTER);
        text_datekey.setTextColor(Color.rgb(175,175,175));
        text_datekey.getPaint().setFakeBoldText(true);
        params=new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1);

        clientPayRelativeLayout.addView(text_datekey,params);

        text_dateValue=new TextView(mContext);
        text_dateValue.setText("2018-09-09 12:00");
        text_dateValue.setTextSize(18);
        text_dateValue.setGravity(Gravity.CENTER);
        text_dateValue.setTextColor(Color.BLACK);
        text_dateValue.getPaint().setFakeBoldText(true);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        //layoutParams.setMargins(0,marginSize/2,marginSize/2,marginSize/2);
        clientPayRelativeLayout.addView(text_dateValue,layoutParams);

        //订单
        clientPayRelativeLayout=new RelativeLayout(mContext);
        clientPayRelativeLayout.setBackgroundColor(Color.WHITE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        params.setMargins(marginSize,marginSize,marginSize,0);
        this.addView(clientPayRelativeLayout,params);

        text_orderkey=new TextView(mContext);
        text_orderkey.setText("订单");
        text_orderkey.setTextSize(18);
        text_orderkey.setGravity(Gravity.CENTER);
        text_orderkey.setTextColor(Color.rgb(175,175,175));
        text_orderkey.getPaint().setFakeBoldText(true);
        params=new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1);

        clientPayRelativeLayout.addView(text_orderkey,params);

        text_orderValue=new TextView(mContext);
        text_orderValue.setText("201809091200");
        text_orderValue.setTextSize(18);
        text_orderValue.setGravity(Gravity.CENTER);
        text_orderValue.setTextColor(Color.BLACK);
        text_orderValue.getPaint().setFakeBoldText(true);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        //layoutParams.setMargins(0,marginSize/2,marginSize/2,marginSize/2);
        clientPayRelativeLayout.addView(text_orderValue,layoutParams);

        lineView=new View(mContext);
        lineView.setBackgroundColor(Color.rgb(216,216,216));
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                marginSize/8);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        clientPayRelativeLayout.addView(lineView,layoutParams);

    }
    public ImageView getback(){
        return baseTitleView.backIV;
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(mContext) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_moneydateils";
            }

            @Override
            public int[] getTitleSize() {
                height = (int) ( marginSize*1.5);
                width = (int) (marginSize*3.5);
                return new int[] { LayoutParams.WRAP_CONTENT, height };
            }

            @Override
            public int[] getBackSize() {
                height = (int) ( marginSize*2);
                width = height;
                return new int[] { width, height };
            }

            @Override
            public int[] getSetSize() {
                height = (int) ( marginSize);
                width = LayoutParams.WRAP_CONTENT;
                return new int[] { width, height };
            }

            @Override
            public String getSetName() {
                return "";
            }

            @Override
            public boolean hasSetText() {
                return false;
            }

            @Override
            public String getImageViewName() {
                return "xmy_back";
            }
            @Override
            public boolean hasSetButton() {
                return true;
            }
        };
    }
}
