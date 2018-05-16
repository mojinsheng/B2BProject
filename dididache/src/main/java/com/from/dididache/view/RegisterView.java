package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.from.dididache.R;

/**
 * Created by USER on 2018/5/10.
 */

public class RegisterView extends BaseLinearLayout {
    private Context context;
    private LinearLayout mContainerLayout,mListLayout;
    private LinearLayout citySelectLayout,underlineLinearLayout;
    private LayoutParams params;
    private RelativeLayout mListRelativeLayout;
    private RelativeLayout.LayoutParams layoutParams;
    private BaseTitleView baseTitleView;
    private TextView text_infornation,text_download;
    private ImageView img_city,img_download,img_downloaddriver;
    private Button btn_register;
    public RegisterView(Context _context) {
        super(_context);
        context=_context;
        init(mContext);
    }


    public void init(Context mContext){
        mContainerLayout = new LinearLayout(context);
        mContainerLayout.setOrientation(LinearLayout.VERTICAL);
        mContainerLayout.setBackgroundColor(Color.rgb(242,242,242));
        //mContainerLayout.setBackgroundColor(Color.WHITE);
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        this.addView(mContainerLayout, params);

        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0607)));
        mContainerLayout.addView(baseTitleView, params);


        //信息用于审核，绝不外泄
        mListLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);

        mContainerLayout.addView(mListLayout,params);

        text_infornation=new TextView(mContext);
        text_infornation.setText("信息仅用于审核,绝不外泄");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.rgb(205,202,196));
        text_infornation.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.topMargin=marginSize/2;
        params.leftMargin=marginSize;
        mListLayout.addView(text_infornation,params);

        //选择城市布局
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("城市");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        mListRelativeLayout.addView(text_infornation,layoutParams);

        //选择城市
        citySelectLayout=new LinearLayout(mContext);
        citySelectLayout.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mListRelativeLayout.addView(citySelectLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("请选择");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
       // params.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        citySelectLayout.addView(text_infornation,layoutParams);

        //链接图标
        img_city=new ImageView(mContext);
        img_city.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_city,params);


        //驾驶证信息
        mListLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);

        mContainerLayout.addView(mListLayout,params);

        text_infornation=new TextView(mContext);
        text_infornation.setText("驾驶证信息");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.rgb(205,202,196));
        text_infornation.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.topMargin=marginSize/2;
        params.leftMargin=marginSize;
        mListLayout.addView(text_infornation,params);


        //驾驶照片
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("驾驶照片");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
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

        text_download=new TextView(mContext);
        text_download.setText("请上传");
        text_download.setTextSize(16);
        text_download.setTextColor(Color.BLACK);
        text_download.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        // params.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        citySelectLayout.addView(text_download,layoutParams);

        //上传图标
        img_download=new ImageView(mContext);
        img_download.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_download,params);

        //下划线
        registerUnderline();

        //司机姓名
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("司机姓名");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        mListRelativeLayout.addView(text_infornation,layoutParams);

        //司机姓名
        citySelectLayout=new LinearLayout(mContext);

        citySelectLayout.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mListRelativeLayout.addView(citySelectLayout,layoutParams);


        EditText e_inputcat=new EditText(mContext);
        e_inputcat.setBackgroundResource(0);
        e_inputcat.setHint("请输入");
        e_inputcat.setTextSize(16);
        e_inputcat.setSingleLine(true);
        e_inputcat.setLines(R.color.start_button_color);
        //e_inputcat.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //params.topMargin=marginSize;
        e_inputcat.setTextColor(Color.BLACK);
        e_inputcat.setHintTextColor(Color.GRAY);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,((int)(marginSize*1.3)));
        citySelectLayout.addView(e_inputcat,layoutParams);



        //下划线
        registerUnderline();


        //身份证布局
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("身份证号");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        mListRelativeLayout.addView(text_infornation,layoutParams);

        //身份证右边布局
        citySelectLayout=new LinearLayout(mContext);

        citySelectLayout.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mListRelativeLayout.addView(citySelectLayout,layoutParams);


        LineEditText e_IDcard=new LineEditText(mContext);
        e_IDcard.setBackgroundResource(0);
        e_IDcard.setHint("请输入");
        e_IDcard.setTextSize(16);
        e_IDcard.setSingleLine(true);
        e_IDcard.setLines(R.color.start_button_color);
        //e_inputcat.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //params.topMargin=marginSize;
        e_IDcard.setTextColor(Color.BLACK);
        e_IDcard.setHintTextColor(Color.GRAY);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,((int)(marginSize*1.3)));
        citySelectLayout.addView(e_IDcard,layoutParams);



        //下划线
        registerUnderline();


        //驾照日期
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("初次领取驾驶证驾照日期");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
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

        //上传图标
        img_downloaddriver=new ImageView(mContext);
        img_downloaddriver.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_downloaddriver,params);

        //下划线
        registerUnderline();
        LinearLayout linearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(marginSize*1.5)));
        mContainerLayout.addView(linearLayout,params);

        //行驶证图片布局
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin=((int)(marginSize*2));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("行驶证照片");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
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

        text_download=new TextView(mContext);
        text_download.setText("请上传");
        text_download.setTextSize(16);
        text_download.setTextColor(Color.BLACK);
        text_download.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        // params.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        citySelectLayout.addView(text_download,layoutParams);

        //上传图标
        img_download=new ImageView(mContext);
        img_download.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_download,params);

        //下划线
        registerUnderline();

        //车辆类型布局
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin=((int)(marginSize*2));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("车型");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
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

        text_download=new TextView(mContext);
        text_download.setText("请选择");
        text_download.setTextSize(16);
        text_download.setTextColor(Color.BLACK);
        text_download.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        // params.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        citySelectLayout.addView(text_download,layoutParams);

        //上传图标
        img_download=new ImageView(mContext);
        img_download.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_download,params);

        //下划线
        registerUnderline();

        //车牌号码布局
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("车牌号码");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
        text_infornation.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize,marginSize/2,marginSize/2,marginSize/2);
        mListRelativeLayout.addView(text_infornation,layoutParams);

        //司机姓名
        citySelectLayout=new LinearLayout(mContext);

        citySelectLayout.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mListRelativeLayout.addView(citySelectLayout,layoutParams);


        EditText e_catnumber=new EditText(mContext);
        e_catnumber.setBackgroundResource(0);
        e_catnumber.setHint("请输入");
        e_catnumber.setTextSize(16);
        e_catnumber.setSingleLine(true);
        e_catnumber.setLines(R.color.start_button_color);
        //e_inputcat.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //params.topMargin=marginSize;
        e_catnumber.setTextColor(Color.BLACK);
        e_catnumber.setHintTextColor(Color.GRAY);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,((int)(marginSize*1.3)));
        citySelectLayout.addView(e_catnumber,layoutParams);



        //下划线
        registerUnderline();
        //驾照日期
        mListRelativeLayout=new RelativeLayout(mContext);
        mListRelativeLayout.setBackgroundColor(Color.WHITE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //layoutParams.leftMargin=((int)(marginSize*1.5));
        mContainerLayout.addView(mListRelativeLayout,layoutParams);

        text_infornation=new TextView(mContext);
        text_infornation.setText("行驶证注册日期");
        text_infornation.setTextSize(16);
        text_infornation.setTextColor(Color.BLACK);
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

        //上传图标
        img_downloaddriver=new ImageView(mContext);
        img_downloaddriver.setBackgroundResource(createDrawable("xmy_cityurl"));
        params=new LayoutParams(marginSize,marginSize);
        citySelectLayout.addView(img_downloaddriver,params);

        //注册按钮
        btn_register=new Button(mContext);
        btn_register.setBackgroundColor(Color.rgb(26,180,255));
        btn_register.setText("注册");
        btn_register.setTextColor(Color.WHITE);
        btn_register.setTextSize(20);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.topMargin=marginSize;
        params.leftMargin=marginSize*2;
        params.rightMargin=marginSize*2;
        mContainerLayout.addView(btn_register,params);

    }
    public ImageView getImgBcak(){
        return baseTitleView.backIV;
    }

    public BaseTitleView getTitle(){
        return new BaseTitleView(context) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_register";
            }

            @Override
            public int[] getTitleSize() {
                height = (int) ( marginSize*1.5);
                width = (int) (marginSize*3.5);
                return new int[] { LayoutParams.WRAP_CONTENT, height };
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
            public String getImageViewName() {
                return "xmy_back";
            }
            @Override
            public boolean hasSetButton() {
                return true;
            }
        };
    }
    public void registerUnderline(){
        underlineLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize/8);
        params.leftMargin=marginSize/2;
        params.rightMargin=marginSize/2;
        underlineLinearLayout.setBackgroundResource(createDrawable("xmy_register_underline"));
        mContainerLayout.addView(underlineLinearLayout,params);
    }

}
