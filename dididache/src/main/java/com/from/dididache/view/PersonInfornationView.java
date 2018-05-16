package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by USER on 2018/5/12.
 */

public class PersonInfornationView extends BaseLinearLayout {
    private LinearLayout mContainerLayout,underlineLinearLayout,logoPhoneLayout,logoPhoneContentLayout;
    private BaseTitleView baseTitleView;
    private LinearLayout listnameLinearLayout;
    private LayoutParams params;
    private TextView text_list,text_Name,text_Phone,text_City,text_Code,text_Driving,text_ID;
    public PersonInfornationView(Context context) {
        super(context);
        init();
    }
    public void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0607)));
        this.addView(baseTitleView, params);

        //内容布局
        mContainerLayout=new LinearLayout(mContext);
        mContainerLayout.setOrientation(LinearLayout.VERTICAL);
        mContainerLayout.setBackgroundColor(Color.WHITE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mHeight*0.6));
        params.setMargins(marginSize,marginSize*2,marginSize,0);
        this.addView(mContainerLayout,params);


        //司机姓名
        listnameLinearLayout=new LinearLayout(mContext);
        listnameLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/2;
        mContainerLayout.addView(listnameLinearLayout,params);
        text_list=new TextView(mContext);
        text_list.setText("司机姓名");
        text_list.setTextSize(16);
        text_list.setTextColor(Color.rgb(94,94,94));
        text_list.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        listnameLinearLayout.addView(text_list,params);

        text_Name=new TextView(mContext);
        text_Name.setText("莫进生");
        text_Name.setTextSize(16);
        text_Name.setTextColor(Color.BLACK);
        text_Name.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize*4;
        listnameLinearLayout.addView(text_Name,params);
        personUnderline();


        //手机号码
        listnameLinearLayout=new LinearLayout(mContext);
        listnameLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/2;
        params.topMargin=marginSize/2;
        mContainerLayout.addView(listnameLinearLayout,params);
        text_list=new TextView(mContext);
        text_list.setText("手机号码");
        text_list.setTextSize(16);
        text_list.setTextColor(Color.rgb(94,94,94));
        text_list.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        listnameLinearLayout.addView(text_list,params);

        text_Phone=new TextView(mContext);
        text_Phone.setText("18665953437");
        text_Phone.setTextSize(16);
        text_Phone.setTextColor(Color.BLACK);
        text_Phone.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize*4;
        listnameLinearLayout.addView(text_Phone,params);
        personUnderline();

        //城市服务
        listnameLinearLayout=new LinearLayout(mContext);
        listnameLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/2;
        params.topMargin=marginSize/2;
        mContainerLayout.addView(listnameLinearLayout,params);
        text_list=new TextView(mContext);
        text_list.setText("服务城市");
        text_list.setTextSize(16);
        text_list.setTextColor(Color.rgb(94,94,94));
        text_list.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        listnameLinearLayout.addView(text_list,params);

        text_City=new TextView(mContext);
        text_City.setText("广州");
        text_City.setTextSize(16);
        text_City.setTextColor(Color.BLACK);
        text_City.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize*4;
        listnameLinearLayout.addView(text_City,params);
        personUnderline();


        //证件号码
        listnameLinearLayout=new LinearLayout(mContext);
        listnameLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/2;
        params.topMargin=marginSize/2;
        mContainerLayout.addView(listnameLinearLayout,params);
        text_list=new TextView(mContext);
        text_list.setText("证件号码");
        text_list.setTextSize(16);
        text_list.setTextColor(Color.rgb(94,94,94));
        text_list.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        listnameLinearLayout.addView(text_list,params);

        text_Code=new TextView(mContext);
        text_Code.setText("490823123434212121");
        text_Code.setTextSize(16);
        text_Code.setTextColor(Color.BLACK);
        text_Code.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize*4;
        listnameLinearLayout.addView(text_Code,params);
        personUnderline();

        //证件类型
        listnameLinearLayout=new LinearLayout(mContext);
        listnameLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/2;
        params.topMargin=marginSize/2;
        mContainerLayout.addView(listnameLinearLayout,params);
        text_list=new TextView(mContext);
        text_list.setText("证件类型");
        text_list.setTextSize(16);
        text_list.setTextColor(Color.rgb(94,94,94));
        text_list.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        listnameLinearLayout.addView(text_list,params);

        text_Driving=new TextView(mContext);
        text_Driving.setText("驾照");
        text_Driving.setTextSize(16);
        text_Driving.setTextColor(Color.BLACK);
        text_Driving.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize*4;
        listnameLinearLayout.addView(text_Driving,params);
        personUnderline();

        //驾驶证号码
        listnameLinearLayout=new LinearLayout(mContext);
        listnameLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize/2;
        params.topMargin=marginSize/2;
        mContainerLayout.addView(listnameLinearLayout,params);
        text_list=new TextView(mContext);
        text_list.setText("驾驶证号码");
        text_list.setTextSize(16);
        text_list.setTextColor(Color.rgb(94,94,94));
        text_list.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        listnameLinearLayout.addView(text_list,params);

        text_ID=new TextView(mContext);
        text_ID.setText("440923187643652312");
        text_ID.setTextSize(16);
        text_ID.setTextColor(Color.BLACK);
        text_ID.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.leftMargin=marginSize*3;
        listnameLinearLayout.addView(text_ID,params);
        personUnderline();
    }
    public void personUnderline(){
        underlineLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize/8);
        params.leftMargin=marginSize/2;
        params.rightMargin=marginSize/2;
        params.topMargin=marginSize/2;
        underlineLinearLayout.setBackgroundResource(createDrawable("xmy_register_underline"));
        mContainerLayout.addView(underlineLinearLayout,params);
    }
    public ImageView getImgBcak(){
        return baseTitleView.backIV;
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
            public int[] getSetSize() {
                height = (int) ( marginSize);
                width = height;
                return new int[] { width, height };
            }

            @Override
            public String getSetName() {
                return null;
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
