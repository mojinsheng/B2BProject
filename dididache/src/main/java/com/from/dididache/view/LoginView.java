package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.from.dididache.R;
import com.from.molibrary.res.EfunResourceUtil;

/**
 * 登录页面
 * Created by USER on 2018/4/3.
 */

public class LoginView extends BaseLinearLayout {
    private LinearLayout mContainerLayout;
    private RelativeLayout.LayoutParams layoutParams;
    private LinearLayout mLinearLayout,loginLinearLayout,LoginMapLinearLayout;
    private LinearLayout logoLinearLayout;
    private RelativeLayout mContainerRelativeLayout,mRelativeLayout;
    private Button btn_login;
    private LayoutParams params;
    private TextView text_forget,text_register;
    private Context context;
    private int width, height;
    private ImageView img_logo;
    private EditText e_useName;
    private EditText e_passWord;
    private BaseTitleView baseTitleView;

    public LoginView(Context _context) {
        super(_context);
        context = _context;
        init();
    }

    public LoginView(Context _context, AttributeSet attrs) {
        super(_context, attrs);
        context = _context;
        init();
    }

    public void init() {
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

        //登录页面的内容布局1,171,230
        mContainerRelativeLayout = new RelativeLayout(context);
        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        mContainerLayout.addView(mContainerRelativeLayout, layoutParams);


        mRelativeLayout = new RelativeLayout(context);
       // mRelativeLayout.setBackgroundColor(Color.rgb(1,171,230));
        width = (int) (mWidth * 0.75);
        height = (int) (mHeight * 0.8);
        layoutParams = new RelativeLayout.LayoutParams(width, height);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mContainerRelativeLayout.addView(mRelativeLayout, layoutParams);
        loginLinearLayout=new LinearLayout(mContext);
        loginLinearLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mRelativeLayout.addView(loginLinearLayout,params);

        //显示logo
        mRelativeLayout = new RelativeLayout(context);
        //mRelativeLayout.setBackgroundColor(Color.GRAY);
        height = (int) (mHeight * 0.1809);
        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                height);

        loginLinearLayout.addView(mRelativeLayout,layoutParams);
        img_logo=new ImageView(mContext);
        img_logo.setBackgroundResource(createDrawable("xmy_logo"));
        height = (int) (mHeight * 0.109);
        layoutParams=new RelativeLayout.LayoutParams(((int)(height*1.3)),height);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mRelativeLayout.addView(img_logo,layoutParams);

        //输入手机号
        LoginMapLinearLayout=new LinearLayout(mContext);
        //LoginMapLinearLayout.setBackgroundColor(Color.BLUE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.topMargin=marginSize/2;
        loginLinearLayout.addView(LoginMapLinearLayout,params);
        LineEditText e_inputName=new LineEditText(mContext);
        e_inputName.setBackgroundResource(0);
        e_inputName.setHint("手机号码");
        e_inputName.setSingleLine(true);
        e_inputName.setLines(R.color.start_button_color);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
//        if (false) {
//            e_inputName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//            //params.topMargin=marginSize;
//        }
        e_inputName.setTextColor(Color.BLACK);
        e_inputName.setHintTextColor(Color.GRAY);
        LoginMapLinearLayout.addView(e_inputName,params);

        //下划线
        LoginMapLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize/8);
        params.leftMargin=marginSize/2;
        params.rightMargin=marginSize/2;
        LoginMapLinearLayout.setBackgroundResource(createDrawable("xmy_underline"));
        loginLinearLayout.addView(LoginMapLinearLayout,params);


        //输入用密码
        LoginMapLinearLayout=new LinearLayout(mContext);
        //LoginMapLinearLayout.setBackgroundColor(Color.BLUE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.topMargin=marginSize/2;
        loginLinearLayout.addView(LoginMapLinearLayout,params);
        //显示用户和密码
        LineEditText e_inputPwd=new LineEditText(mContext);
        e_inputPwd.setBackgroundResource(0);
        e_inputPwd.setHint("密 码");
        e_inputPwd.setSingleLine(true);
        e_inputPwd.setLines(R.color.start_button_color);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        e_inputPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            //params.topMargin=marginSize;
        e_inputPwd.setTextColor(Color.BLACK);
        e_inputPwd.setHintTextColor(Color.GRAY);
        LoginMapLinearLayout.addView(e_inputPwd,params);

        //下划线
        LoginMapLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize/8);
        params.leftMargin=marginSize/2;
        params.rightMargin=marginSize/2;
        LoginMapLinearLayout.setBackgroundResource(createDrawable("xmy_underline"));
        loginLinearLayout.addView(LoginMapLinearLayout,params);


        //忘记密码
        RelativeLayout forgetPwdRe=new RelativeLayout(mContext);

        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                ((int)(marginSize*1.5)));
        loginLinearLayout.addView(forgetPwdRe,layoutParams);

        text_forget=new TextView(mContext);
        text_forget.setText(EfunResourceUtil.findStringByName(mContext,"xmy_text_frogetpassword"));
        text_forget.setTextSize(16);
        text_forget.setTextColor(Color.BLACK);
        text_forget.setGravity(Gravity.CENTER);

        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        forgetPwdRe.addView(text_forget,layoutParams);

        //登录按钮
        LoginMapLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*2);
        params.leftMargin=marginSize/2;
        params.rightMargin=marginSize/2;
        params.topMargin=marginSize;
        LoginMapLinearLayout.setBackgroundResource(createDrawable("xmy_underline"));
        loginLinearLayout.addView(LoginMapLinearLayout,params);

        btn_login=new Button(mContext);
        btn_login.setBackgroundColor(Color.rgb(26,180,255));
        btn_login.setText(EfunResourceUtil.findStringByName(mContext,"xmy_btn_login"));
        btn_login.setTextColor(Color.WHITE);
        btn_login.setTextSize(20);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        LoginMapLinearLayout.addView(btn_login,params);

        //立即注册
        RelativeLayout registerRe=new RelativeLayout(mContext);
        registerRe.setVisibility(View.GONE);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                ((int)(marginSize*2)));
        layoutParams.topMargin=marginSize;
        loginLinearLayout.addView(registerRe,layoutParams);

        text_register=new TextView(mContext);
        text_register.setText("立即注册");
        text_register.setTextSize(17);
        text_register.setTextColor(Color.rgb(26,180,255));
        text_register.setGravity(Gravity.CENTER);

        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        registerRe.addView(text_register,layoutParams);

        //小码蚁提供技术支持技术团队
        LinearLayout teamRelativeLayout=new LinearLayout(mContext);
        teamRelativeLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        loginLinearLayout.addView(teamRelativeLayout,params);

        LinearLayout invalidLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,1);
        teamRelativeLayout.addView(invalidLinearLayout,params);

        LinearLayout teamTextlinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,5);
        teamRelativeLayout.addView(teamTextlinearLayout,params);

        RelativeLayout teamTextlinearRelativeLayout=new RelativeLayout(mContext);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        teamTextlinearLayout.addView(teamTextlinearRelativeLayout,layoutParams);
        TextView text_team=new TextView(mContext);
        text_team.setText(EfunResourceUtil.findStringByName(mContext,"xmy_text_company"));
        text_team.setTextSize(16);
        text_team.setTextColor(Color.BLACK);
        text_team.setGravity(Gravity.CENTER);

        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        teamTextlinearRelativeLayout.addView(text_team,layoutParams);
    }


    public Button getBtnLogin(){
       return btn_login;
    }
    public TextView getTextForget() {
        return text_forget;
    }
    public TextView getTextRegister() {
        return text_register;
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(context) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_login";
            }

            @Override
            public int[] getTitleSize() {
                height = (int) ( marginSize*1.5);
                width = (int) (marginSize*3.5);
                return new int[] { LayoutParams.WRAP_CONTENT, height };
            }

            @Override
            public int[] getBackSize() {
                height = (int) ( marginSize);
                width = height;
                return new int[] { width, height };
            }
            @Override
            public String getImageViewName() {
                return "";
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
            public boolean hasSetButton() {
                return false;
            }
        };
    }

}