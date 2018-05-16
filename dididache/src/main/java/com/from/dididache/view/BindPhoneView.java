package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.from.dididache.R;

/**
 * Created by USER on 2018/5/12.
 */

public class BindPhoneView extends BaseLinearLayout {
    private Context context;
    private LinearLayout mContainerLayout,mLinearLayout,oldphoneLinearLayout,lineLayout;
    private BaseTitleView baseTitleView;
    private RelativeLayout.LayoutParams layoutParams;
    private LayoutParams params;
    private TextView text_phone;
    private Button btn_ReceiveSms;
    private LineEditText e_inputCode;
    private LineEditText e_inputNewphone;
    private LinearLayout codeLinearLayout,newPhoneLinearLayout;
    private Button btn_bindPhone;
    public BindPhoneView(Context context) {
        super(context);
        init();
    }
    public void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        this.setBackgroundColor(Color.rgb(242,242,242));

        mLinearLayout=new LinearLayout(mContext);
        mLinearLayout.setBackgroundColor(Color.rgb(35,38,68));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0607)));
        this.addView(mLinearLayout,params);

        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mLinearLayout.addView(baseTitleView,params);

        //内容布局
        mContainerLayout=new LinearLayout(mContext);
        mContainerLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mHeight*0.5));
        params.setMargins(marginSize*2,marginSize*3,marginSize*2,marginSize);
        this.addView(mContainerLayout,params);

        //更换手机
        RelativeLayout texRe=new RelativeLayout(mContext);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        mContainerLayout.addView(texRe,layoutParams);
        //调整图标
        text_phone=new TextView(mContext);
        text_phone.setText("更换手机");
        text_phone.setTextSize(16);
        text_phone.setTextColor(Color.BLACK);
        text_phone.setGravity(Gravity.CENTER);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        texRe.addView(text_phone,layoutParams);


        //输入旧手机号
        oldphoneLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.topMargin=marginSize/2;
        mContainerLayout.addView(oldphoneLinearLayout,params);

        LineEditText e_inputName=new LineEditText(mContext);
        e_inputName.setBackgroundResource(0);
        e_inputName.setHint("手机号码");
        e_inputName.setSingleLine(true);
        e_inputName.setLines(R.color.start_button_color);
        params=new LayoutParams((int)(mWidth*0.6),LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        if (false) {
            e_inputName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            //params.topMargin=marginSize;
        }
        e_inputName.setTextColor(Color.BLACK);
        e_inputName.setHintTextColor(Color.GRAY);
        oldphoneLinearLayout.addView(e_inputName,params);

        //获取验证码
        btn_ReceiveSms=new Button(mContext);
        btn_ReceiveSms.setText("获取验证码");
        btn_ReceiveSms.setTextSize(14);
        btn_ReceiveSms.setTextColor(Color.BLACK);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        oldphoneLinearLayout.addView(btn_ReceiveSms,params);
        //下划线
        paintLine();

        //验证码
        codeLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.topMargin=marginSize/2;
        mContainerLayout.addView(codeLinearLayout,params);

        LineEditText e_inputCode=new LineEditText(mContext);
        e_inputCode.setBackgroundResource(0);
        e_inputCode.setHint("验证码");
        e_inputCode.setSingleLine(true);
        e_inputCode.setLines(R.color.start_button_color);
        params=new LayoutParams((int)(mWidth*0.6),LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        if (false) {
            e_inputName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            //params.topMargin=marginSize;
        }
        e_inputCode.setTextColor(Color.BLACK);
        e_inputCode.setHintTextColor(Color.GRAY);
        codeLinearLayout.addView(e_inputCode,params);
        //下划线
        paintLine();

        //新手机号码
        newPhoneLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.topMargin=marginSize/2;
        mContainerLayout.addView(newPhoneLinearLayout,params);

        e_inputNewphone=new LineEditText(mContext);
        e_inputNewphone.setBackgroundResource(0);
        e_inputNewphone.setHint("验证码");
        e_inputNewphone.setSingleLine(true);
        e_inputNewphone.setLines(R.color.start_button_color);
        params=new LayoutParams((int)(mWidth*0.6),LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        e_inputNewphone.setTextColor(Color.BLACK);
        e_inputNewphone.setHintTextColor(Color.GRAY);
        newPhoneLinearLayout.addView(e_inputNewphone,params);
        //下划线
        paintLine();
        //登录按钮
        btn_bindPhone=new Button(mContext);
        btn_bindPhone.setBackgroundColor(Color.rgb(26,180,255));
        btn_bindPhone.setText("注册");
        btn_bindPhone.setTextColor(Color.WHITE);
        btn_bindPhone.setTextSize(20);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.topMargin=marginSize;
        params.leftMargin=marginSize*2;
        params.rightMargin=marginSize*2;
        mContainerLayout.addView(btn_bindPhone,params);
    }
    public void paintLine(){
        lineLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize/8);
        params.leftMargin=marginSize/2;
        params.rightMargin=marginSize/2;
        lineLayout.setBackgroundResource(createDrawable("xmy_underline"));
        mContainerLayout.addView(lineLayout,params);
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(mContext) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_bindphone";
            }

            @Override
            public String getSetName() {
                return null;
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
