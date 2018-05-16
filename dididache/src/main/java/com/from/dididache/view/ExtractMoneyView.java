package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.from.dididache.R;
import com.from.molibrary.res.EfunResourceUtil;

/**
 * 提现界面View
 * Created by USER on 2018/5/16.
 */

public class ExtractMoneyView extends BaseLinearLayout {
    private LayoutParams params;
    private BaseTitleView baseTitleView;
    private LinearLayout mContainerLayout,moneyLinearLayout;
    private RelativeLayout.LayoutParams layoutParams;
    private TextView text_money,text_showmoney;
    private TextView text_moneyover,text_allmoney;
    private View lineView;
    private Button btn_extract;
    public ExtractMoneyView(Context context) {
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
        mContainerLayout.setBackgroundColor(Color.WHITE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mHeight*0.6));
        params.setMargins(marginSize,marginSize*3,marginSize,0);
        this.addView(mContainerLayout,params);


        //提取金额的标签
        text_money=new TextView(mContext);
        text_money.setTextColor(Color.BLACK);
        text_money.setText(EfunResourceUtil.findStringByName(mContext,"xmy_extractmoney"));
        text_money.setTextSize(18);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.setMargins(marginSize,marginSize,marginSize,marginSize);
        mContainerLayout.addView(text_money,params);


        //显示提取的金额

        moneyLinearLayout=new LinearLayout(mContext);
        moneyLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.setMargins(marginSize,marginSize,marginSize,marginSize);
        mContainerLayout.addView(moneyLinearLayout,params);


        //显示零钱
        text_showmoney=new TextView(mContext);
        text_showmoney.setText("¥");
        text_showmoney.setTextSize(35);
        text_showmoney.setTextColor(Color.BLACK);
        text_showmoney.getPaint().setFakeBoldText(true);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        moneyLinearLayout.addView(text_showmoney,params);

        //输入金额
        LineEditText e_inputName=new LineEditText(mContext);
        e_inputName.setBackgroundResource(0);
        e_inputName.setHint(EfunResourceUtil.findStringByName(mContext,"xmy_inpurmoney"));
        e_inputName.setSingleLine(true);
        e_inputName.setLines(R.color.start_button_color);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        if (false) {
            e_inputName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            //params.topMargin=marginSize;
        }
        e_inputName.setTextColor(Color.BLACK);
        e_inputName.setHintTextColor(Color.GRAY);
        e_inputName.setTextSize(30);
        moneyLinearLayout.addView(e_inputName,params);


        //横线
        lineView=new View(mContext);
        lineView.setBackgroundColor(Color.rgb(232,232,232));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize/8);
        params.setMargins(marginSize,0,marginSize,marginSize);
        mContainerLayout.addView(lineView,params);

        //零钱余额，全部提现
        moneyLinearLayout=new LinearLayout(mContext);
        moneyLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.setMargins(marginSize,0,marginSize,marginSize);
        mContainerLayout.addView(moneyLinearLayout,params);

        text_moneyover=new TextView(mContext);
        text_moneyover.setTextSize(16);
        text_moneyover.setText("零钱余额¥1000");
        text_moneyover.setTextColor(Color.rgb(180,188,197));
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        moneyLinearLayout.addView(text_moneyover,params);

        //全部提现
        text_allmoney=new TextView(mContext);
        text_allmoney.setTextSize(16);
        text_allmoney.setText(EfunResourceUtil.findStringByName(mContext,"xmy_extractallmoney"));
        text_allmoney.setTextColor(Color.rgb(96,109,124));
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/2;
        moneyLinearLayout.addView(text_allmoney,params);

        //提现
        btn_extract=new Button(mContext);
        btn_extract.setText(EfunResourceUtil.findStringIdByName(mContext,"xmy_btn_extactl"));
        btn_extract.setTextSize(25);
        btn_extract.setTextColor(Color.WHITE);
        btn_extract.getPaint().setFakeBoldText(true);
        btn_extract.setBackgroundColor(Color.rgb(26,180,255));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mWidth*0.102)));
        params.setMargins(marginSize,0,marginSize,marginSize);
        mContainerLayout.addView(btn_extract,params);

    }
    public ImageView getBack(){
        return baseTitleView.backIV;
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(mContext) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_extrabtmoney";
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
