package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.from.molibrary.res.EfunResourceUtil;

/**
 * 显示余额
 * Created by USER on 2018/5/16.
 */

public class MoneyoveView extends BaseLinearLayout {
    private LinearLayout mContainerLayout;
    private RelativeLayout.LayoutParams layoutParams;
    private BaseTitleView baseTitleView;
    private LayoutParams params;
    private RelativeLayout imgmoneyRelativeLayout,textRelativeLayout,moneyRelativeLayout;
    private ImageView img_moneyover;
    private TextView text_money;
    //显示金额
    private TextView text_showmoney;
    //提现
    private Button btn_extract;
    public MoneyoveView(Context context) {
        super(context);
        init();
    }
    public void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        this.setBackgroundColor(Color.rgb(240,239,245));
        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0607)));
        this.addView(baseTitleView, params);

        //内容布局
        mContainerLayout=new LinearLayout(mContext);
        mContainerLayout.setOrientation(LinearLayout.VERTICAL);
        mContainerLayout.setBackgroundColor(Color.rgb(240,239,245));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mHeight*0.6));
        params.setMargins(marginSize,marginSize*3,marginSize,0);
        this.addView(mContainerLayout,params);

        //余额图标
        imgmoneyRelativeLayout=new RelativeLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mHeight*0.12));
        mContainerLayout.addView(imgmoneyRelativeLayout,params);

        img_moneyover=new ImageView(mContext);
        img_moneyover.setBackgroundResource(createDrawable("xmy_moneyver"));
        layoutParams=new RelativeLayout.LayoutParams((int)(mWidth*0.2),
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        imgmoneyRelativeLayout.addView(img_moneyover,layoutParams);

        //余额标题
        textRelativeLayout=new RelativeLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        params.topMargin=marginSize;
        mContainerLayout.addView(textRelativeLayout,params);
       // mContainerLayout.addView(textRelativeLayout,);

        //我的零钱
        text_money=new TextView(mContext);
        text_money.setText(createString("xmy_mymoneyover"));
        text_money.setTextSize(18);
        text_money.setTextColor(Color.BLACK);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        textRelativeLayout.addView(text_money,layoutParams);

        //显示余额标题
        moneyRelativeLayout=new RelativeLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        params.topMargin=marginSize;
        mContainerLayout.addView(moneyRelativeLayout,params);
        // mContainerLayout.addView(textRelativeLayout,);

        //显示零钱
        text_showmoney=new TextView(mContext);
        text_showmoney.setText("¥234");
        text_showmoney.setTextSize(35);
        text_showmoney.setTextColor(Color.BLACK);
        text_showmoney.getPaint().setFakeBoldText(true);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        moneyRelativeLayout.addView(text_showmoney,layoutParams);

        //提现
        btn_extract=new Button(mContext);
        btn_extract.setText(EfunResourceUtil.findStringByName(mContext,"xmy_btn_extactl"));
        btn_extract.setTextSize(25);
        btn_extract.setTextColor(Color.WHITE);
        btn_extract.getPaint().setFakeBoldText(true);
        btn_extract.setBackgroundColor(Color.rgb(26,180,255));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mWidth*0.102)));
        params.setMargins(marginSize,marginSize,marginSize,marginSize);
        params.gravity= Gravity.CENTER;
        mContainerLayout.addView(btn_extract,params);

    }
    public Button getBtnExtract(){
        return btn_extract;
    }
    public ImageView getBack(){
        return baseTitleView.backIV;
    }
    public TextView getTextMoneyDetails(){
        return baseTitleView.settingIV;
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(mContext) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_moneyover";
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
                return "xmy_moneyoverinfromation";
            }

            @Override
            public boolean hasSetText() {
                return true;
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
