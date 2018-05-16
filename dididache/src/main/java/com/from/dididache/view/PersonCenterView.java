package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.from.molibrary.res.EfunResourceUtil;

/**
 * Created by USER on 2018/5/12.
 */

public class PersonCenterView extends BaseLinearLayout {
    private LinearLayout mContainerLayout,logoPhoneLayout,logoPhoneContentLayout;
    private LinearLayout bindphoneLinearLayout;
    private LayoutParams params;
    private BaseTitleView baseTitleView;
    private TextView text_name,text_bindphone;
    private RelativeLayout mListRelativeLayout,mpersonRelativeLayout,orderRelativeLayout,moneyoveRelativeLayout;
    private RelativeLayout.LayoutParams layoutParams;
    private LinearLayout citySelectLayout,underlineLinearLayout;
    private TextView text_infornation,text_version,text_company;
    private ImageView img_downloaddriver;
    private LinearLayout personListLinearLayout;
    private TextView text_moneyover;
    public PersonCenterView(Context context) {
        super(context);
        init();
    }


    public void  init(){


        this.setOrientation(LinearLayout.VERTICAL);
        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0607)));
        this.addView(baseTitleView, params);

        //内容布局
        mContainerLayout=new LinearLayout(mContext);
        mContainerLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        this.addView(mContainerLayout,params);

        //显示头像，更新电话
        logoPhoneLayout=new LinearLayout(mContext);
        logoPhoneLayout.setOrientation(LinearLayout.HORIZONTAL);
        logoPhoneLayout.setBackgroundColor(Color.rgb(204,204,204));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.11307)));
        params.setMargins(marginSize,marginSize/2,marginSize,marginSize/2);
        mContainerLayout.addView(logoPhoneLayout,params);

        LinearLayout iconLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(marginSize*4,LayoutParams.MATCH_PARENT);
        params.setMargins(marginSize/2,marginSize/4,marginSize/2,marginSize/4);
        logoPhoneLayout.addView(iconLinearLayout,params);
        //显示头像
        XCRoundImageView xcRoundImageView=new XCRoundImageView(mContext);
        xcRoundImageView.setImageDrawable(getResources().getDrawable(createDrawable("xmy_logo")));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
       // params.setMargins(0,marginSize/4,marginSize/2,marginSize/4);
        iconLinearLayout.addView(xcRoundImageView,params);

        bindphoneLinearLayout=new LinearLayout(mContext);
        bindphoneLinearLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        params.setMargins(marginSize/2,marginSize,marginSize/2,marginSize/2);
        logoPhoneLayout.addView(bindphoneLinearLayout,params);

        text_name=new TextView(mContext);
        text_name.setText("莫进生");
        text_name.setTextSize(16);
        //text_name.getPaint().setFakeBoldText(true);
        text_name.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,1);
        bindphoneLinearLayout.addView(text_name,params);

        text_bindphone=new TextView(mContext);
        text_bindphone.setTextSize(16);
        text_bindphone.setText("18665053437 更换手机>>");
        //text_bindphone.getPaint().setFakeBoldText(true);
        text_bindphone.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,1);
        bindphoneLinearLayout.addView(text_bindphone,params);


        //显示个人功能列表
         personListLinearLayout=new LinearLayout(mContext);
        personListLinearLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.6)));
        params.setMargins(marginSize,marginSize/2,marginSize,marginSize/2);
        mContainerLayout.addView(personListLinearLayout,params);

        //个人信息
        mpersonRelativeLayout=new RelativeLayout(mContext);
        mpersonRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        personListLinearLayout.addView(mpersonRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("个人信息");
        text_infornation.setTextSize(16);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        mpersonRelativeLayout.addView(text_infornation,layoutParams);

        //请上传
        citySelectLayout=new LinearLayout(mContext);
        citySelectLayout.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mpersonRelativeLayout.addView(citySelectLayout,layoutParams);

        //调整图标
        img_downloaddriver=new ImageView(mContext);
        img_downloaddriver.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_downloaddriver,params);
        personUnderline();

        //订单详情
        orderRelativeLayout=new RelativeLayout(mContext);
        orderRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        personListLinearLayout.addView(orderRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("订单详情");
        text_infornation.setTextSize(16);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        orderRelativeLayout.addView(text_infornation,layoutParams);

        //跳转图标
        citySelectLayout=new LinearLayout(mContext);
        citySelectLayout.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        orderRelativeLayout.addView(citySelectLayout,layoutParams);

        //调整图标
        img_downloaddriver=new ImageView(mContext);
        img_downloaddriver.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_downloaddriver,params);
        //下划线
        personUnderline();

        //余额
        moneyoveRelativeLayout=new RelativeLayout(mContext);
        moneyoveRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        personListLinearLayout.addView(moneyoveRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("余额");
        text_infornation.setTextSize(16);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        moneyoveRelativeLayout.addView(text_infornation,layoutParams);

        //跳转图标
        citySelectLayout=new LinearLayout(mContext);
        citySelectLayout.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        moneyoveRelativeLayout.addView(citySelectLayout,layoutParams);

        //显示金额
        text_moneyover=new TextView(mContext);
        text_moneyover.setText("1000元");
        text_moneyover.setTextSize(16);
        text_moneyover.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.rightMargin=marginSize/3;
        citySelectLayout.addView(text_moneyover,layoutParams);

        //调整图标
        img_downloaddriver=new ImageView(mContext);
        img_downloaddriver.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_downloaddriver,params);
        //下划线
        personUnderline();

        //版本
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        personListLinearLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("版本号");
        text_infornation.setTextSize(16);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        mListRelativeLayout.addView(text_infornation,layoutParams);

        //请上传
        citySelectLayout=new LinearLayout(mContext);
        citySelectLayout.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mListRelativeLayout.addView(citySelectLayout,layoutParams);

        //调整图标
        text_version=new TextView(mContext);
        text_version.setText("1.0.0");
        text_version.setTextSize(16);
        text_version.setTextColor(Color.BLACK);
        text_version.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        // params.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        citySelectLayout.addView(text_version,layoutParams);
        personUnderline();


        RelativeLayout textRe=new RelativeLayout(mContext);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mContainerLayout.addView(textRe,layoutParams);

        //调整图标
        text_company=new TextView(mContext);
        text_company.setText(EfunResourceUtil.findStringByName(mContext,"xmy_text_company"));
        text_company.setTextSize(16);
        text_company.setTextColor(Color.BLACK);
        text_company.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        textRe.addView(text_company,layoutParams);
    }
    public void personUnderline(){
        underlineLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize/8);
        params.leftMargin=marginSize/2;
        params.rightMargin=marginSize/2;
        underlineLinearLayout.setBackgroundResource(createDrawable("xmy_register_underline"));
        personListLinearLayout.addView(underlineLinearLayout,params);
    }
    public RelativeLayout getPersonRelativeLayout(){
        return mpersonRelativeLayout;
    }
    public LinearLayout getLinearLayout(){
        return bindphoneLinearLayout;
    }
    public RelativeLayout getOrderRelativeLayout(){
        return orderRelativeLayout;
    }
    public ImageView getImgBcak(){
        return baseTitleView.backIV;
    }
    public RelativeLayout getMoneyoveRelativeLayout(){
        return moneyoveRelativeLayout;
    }

    public BaseTitleView getTitle(){
        return new BaseTitleView(mContext) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_persioninfornation";
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
            public String getSetName() {
                return null;
            }

            @Override
            public int[] getSetSize() {
                height = (int) ( marginSize);
                width = height;
                return new int[] { width, height };
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
