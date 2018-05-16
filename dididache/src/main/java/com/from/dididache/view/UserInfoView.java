package com.from.dididache.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by USER on 2018/4/3.
 */

public class UserInfoView extends BaseLinearLayout {
    private Context context;

    private LinearLayout userLinearLayout,timeLinearLayout,currentLinearLayout,endLinearLayout;
    private LinearLayout mContainerLayout,moneyLinearLayout;
    private LayoutParams params;
    private TextView textView,textViewUserDesc;
    private TextView textView2,textViewTime;
    private TextView textView3,textViewCurrent;
    private TextView textView4,textViewEnd;
    private TextView textViewMoney;
    private  RelativeLayout receivablesRela;
    private RelativeLayout.LayoutParams layoutParams;
    public UserInfoView(Context _context) {
        super(_context);
        context = _context;
        init();
    }

    public UserInfoView(Context _context, AttributeSet attrs) {
        super(_context, attrs);
        context = _context;
        init();
    }
    private void init(){

        mContainerLayout=new LinearLayout(context);
        mContainerLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        params.setMargins(marginSize/3,marginSize/2,marginSize,marginSize);
        this.addView(mContainerLayout,params);

        //用户信息
        userLinearLayout=new LinearLayout(context);
        userLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize);
        mContainerLayout.addView(userLinearLayout,params);


        textView=new TextView(context);
        textView.setText("用 户:");
        textView.setTextSize(20);
        textView.getPaint().setFakeBoldText(true);
        textView.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        userLinearLayout.addView(textView,params);

        textViewUserDesc=new TextView(context);
        textViewUserDesc.setTextSize(20);
        textViewUserDesc.getPaint().setFakeBoldText(true);
        textViewUserDesc.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/3;
        userLinearLayout.addView(textViewUserDesc,params);

         receivablesRela=new RelativeLayout(mContext);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        receivablesRela.setVisibility(View.GONE);
        userLinearLayout.addView(receivablesRela,layoutParams);
        textView=new TextView(context);
        textView.setText("已付款");
        textView.setTextSize(20);
        textView.getPaint().setFakeBoldText(true);
        textView.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        receivablesRela.addView(textView,layoutParams);
        //时间
        //用户信息
        timeLinearLayout=new LinearLayout(context);
        timeLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize);
        mContainerLayout.addView(timeLinearLayout,params);


        textView2=new TextView(context);
        textView2.setText("时 间:");
        textView2.setTextSize(20);
        textView2.getPaint().setFakeBoldText(true);
        textView2.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        timeLinearLayout.addView(textView2,params);

        textViewTime=new TextView(context);
        textViewTime.setTextSize(20);
        textViewTime.getPaint().setFakeBoldText(true);
        textViewTime.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/3;
        timeLinearLayout.addView(textViewTime,params);


        //当前位置
        currentLinearLayout=new LinearLayout(context);
        currentLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize);
        mContainerLayout.addView(currentLinearLayout,params);


        textView3=new TextView(context);
        textView3.setText("开始位置:");
        textView3.setTextSize(20);
        textView3.getPaint().setFakeBoldText(true);
        textView3.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,marginSize);
        currentLinearLayout.addView(textView3,params);

        textViewCurrent=new TextView(context);
        textViewCurrent.setTextSize(20);
        textViewCurrent.getPaint().setFakeBoldText(true);
        textViewCurrent.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/3;
        currentLinearLayout.addView(textViewCurrent,params);

        //目的位置
        endLinearLayout=new LinearLayout(context);
        endLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize);
        mContainerLayout.addView(endLinearLayout,params);


        textView4=new TextView(context);
        textView4.setText("目的地:");
        textView4.setTextSize(20);
        textView4.getPaint().setFakeBoldText(true);
        textView4.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        endLinearLayout.addView(textView4,params);

        textViewEnd=new TextView(context);
        textViewEnd.setTextSize(20);
        textViewEnd.getPaint().setFakeBoldText(true);
        textViewEnd.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/3;
        endLinearLayout.addView(textViewEnd,params);

        //金额
        moneyLinearLayout=new LinearLayout(context);
        endLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize);
        mContainerLayout.addView(moneyLinearLayout,params);


        textView4=new TextView(context);
        textView4.setText("金额:");
        textView4.setTextSize(20);
        textView4.getPaint().setFakeBoldText(true);
        textView4.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        moneyLinearLayout.addView(textView4,params);

        textViewMoney=new TextView(context);
        textViewMoney.setTextSize(20);
        textViewMoney.getPaint().setFakeBoldText(true);
        textViewMoney.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/3;
        moneyLinearLayout.addView(textViewMoney,params);
    }
    public TextView gettextViewUserDesc(){
        return textViewUserDesc;
    }
    public TextView gettextViewTime(){
        return textViewTime;
    }
    public TextView gettextViewEnd(){
        return textViewEnd;
    }
    public TextView gettextViewCurrent(){
        return textViewCurrent;
    }
    public TextView gettextViewMoney(){return textViewMoney;}
    public RelativeLayout getReceivablesRela(){
        return receivablesRela;
    }
}
