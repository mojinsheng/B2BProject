package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.from.molibrary.res.EfunResourceUtil;

/**
 * 简单详情页
 * Created by USER on 2018/4/3.
 */

public class PercenterView extends BaseLinearLayout {
    private Context context;
    private RelativeLayout.LayoutParams layoutParams;
    private LinearLayout mLinearLayout,loginLinearLayout,clientLinearLayout,mContentLinearLayout;
    private RelativeLayout chucheRelativeLayout;
    private LayoutParams params;
    private BaseTitleView baseTitleView;
    private LinearLayout iconLinearLayout;
    private LinearLayout underlineLinearLayout;
    private LinearLayout unorderLinearLayout,orderLinearLayout;
    private ImageView img_icon;
    private ListView listView;
    private Button btn_chuche;
    private TextView text_Name,text_Number,text_TodayNumber;
    private View unorderView,orderView;
    public PercenterView(Context _context) {
        super(_context);
        context = _context;
        init();
    }

    public PercenterView(Context _context, AttributeSet attrs) {
        super(_context, attrs);
        context = _context;
        init();
    }
    private void init(){

        this.setOrientation(LinearLayout.VERTICAL);
        this.setBackgroundColor(Color.rgb(242,242,242));
        mLinearLayout=new LinearLayout(context);
        mLinearLayout.setBackgroundColor(Color.rgb(35,38,68));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0607)));
        this.addView(mLinearLayout,params);

        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mLinearLayout.addView(baseTitleView,params);

        //头像
        iconLinearLayout=new LinearLayout(context);
        iconLinearLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.205)));
        params.setMargins(marginSize,marginSize,marginSize,marginSize);
        //iconRelativeLayout.setBackgroundColor(Color.CYAN);
        this.addView(iconLinearLayout,params);

        //显示头像
        LinearLayout iconContentLayout=new LinearLayout(context);
        iconContentLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,1);
        iconLinearLayout.addView(iconContentLayout,params);

        LinearLayout iconContentLayouta=new LinearLayout(context);
        iconContentLayouta.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(((int)(mWidth*0.1528)),LayoutParams.MATCH_PARENT);
        params.gravity= Gravity.CENTER;
        iconContentLayout.addView(iconContentLayouta,params);

        ImageView img_icon=new ImageView(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mWidth*0.1328)));
        img_icon.setBackgroundResource(createDrawable("xmy_person_logo"));
        iconContentLayouta.addView(img_icon,params);

        text_Name=new TextView(mContext);
        //time_phone.setBackgroundColor(Color.BLUE);
        text_Name.setText("莫进生");
        text_Name.setTextSize(16);
        text_Name.setTextColor(Color.BLACK);
        text_Name.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        params.gravity=Gravity.CENTER;
        iconContentLayouta.addView(text_Name,params);


        //待接单
        RelativeLayout receivablesLayout=new RelativeLayout(context);
        //receivablesLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,2);
        params.leftMargin=marginSize;
        params.rightMargin=marginSize;
        iconLinearLayout.addView(receivablesLayout,params);

        //待接单
        unorderLinearLayout=new LinearLayout(mContext);
        unorderLinearLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        receivablesLayout.addView(unorderLinearLayout,params);

        text_Number=new TextView(mContext);
        //time_phone.setBackgroundColor(Color.BLUE);
        text_Number.setText(EfunResourceUtil.findStringByName(mContext,"xmy_text_unorder"));
        text_Number.setTextSize(16);
        text_Number.setTextColor(Color.BLACK);
        text_Number.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,1);
        params.gravity=Gravity.CENTER;
        unorderLinearLayout.addView(text_Number,params);


        unorderView=new View(mContext);
        unorderView.setBackgroundColor(Color.rgb(26,180,255));
        params=new LayoutParams(marginSize*2,marginSize/8);
        unorderLinearLayout.addView(unorderView,params);



        //竖线
        LinearLayout linearLayout=new LinearLayout(mContext);
        layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        receivablesLayout.addView(linearLayout,layoutParams);


        ImageView img_line=new ImageView(mContext);
        img_line.setBackgroundResource(createDrawable("xmy_line"));
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,marginSize*2);
        params.gravity=Gravity.RIGHT;
        linearLayout.addView(img_line,params);


        //已接单
        orderLinearLayout=new LinearLayout(mContext);
        orderLinearLayout.setOrientation(LinearLayout.VERTICAL);
        layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        receivablesLayout.addView(orderLinearLayout,layoutParams);

        text_Number=new TextView(mContext);
        //time_phone.setBackgroundColor(Color.BLUE);
        text_Number.setText(EfunResourceUtil.findStringByName(mContext,"xmy_text_onorder"));
        text_Number.setTextSize(16);
        text_Number.setTextColor(Color.BLACK);
        text_Number.setGravity(Gravity.CENTER);
        params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,1);
        params.gravity=Gravity.CENTER;
        orderLinearLayout.addView(text_Number,params);

        orderView=new View(mContext);
        orderView.setBackgroundColor(Color.rgb(26,180,255));
        params=new LayoutParams(marginSize*2,marginSize/8);
        orderView.setVisibility(View.GONE);
        orderLinearLayout.addView(orderView,params);


        //乘客信息
        clientLinearLayout=new LinearLayout(context);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mHeight*0.56));
        clientLinearLayout.setBackgroundColor(Color.rgb(255,255,255));
        params.setMargins(marginSize,0,marginSize,marginSize);
        this.addView(clientLinearLayout,params);

        listView=new ListView(context);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        clientLinearLayout.addView(listView,params);
//
//        //出车
//        chucheRelativeLayout=new RelativeLayout(context);
//        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.0915)));
//        this.addView(chucheRelativeLayout,params);
//
//
//        btn_chuche=new Button(context);
//        btn_chuche.setTextSize(25);
//        btn_chuche.setText("出车");
//        btn_chuche.getPaint().setFakeBoldText(true);
//        btn_chuche.setBackgroundColor(Color.rgb(7,155,211));
//        layoutParams=new RelativeLayout.LayoutParams(((int)(mWidth*0.4)),((int)(mHeight*0.0915)));
//        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
//        chucheRelativeLayout.addView(btn_chuche,layoutParams);
    }
    public void personUnderline(LinearLayout linearLayout){
        underlineLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(marginSize*2,marginSize/8);
        params.leftMargin=marginSize/2;
        params.rightMargin=marginSize/2;
        underlineLinearLayout.setBackgroundResource(createDrawable("xmy_underline"));
        linearLayout.addView(underlineLinearLayout,params);
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(context) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "position";
            }

            @Override
            public int[] getTitleSize() {
                height = (int) ( marginSize*1.5);
                width = (int) (marginSize*3.5);
                return new int[] { width, height };
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
                return "xmy_personcenter";
            }
            @Override
            public boolean hasSetButton() {
                return true;
            }
        };
    }

    public ListView getListView(){
        return listView;
    }
    public Button getShuttlebtn(){
            return btn_chuche;
    }
    public ImageView getPersonCenter(){
        return baseTitleView.backIV;
    }
    public View getUnorderView(){
        return unorderView;
    }
    public View getorderView(){
        return orderView;
    }
    public LinearLayout getUnorderLinearLayout(){
        return unorderLinearLayout;
    }
    public LinearLayout getOrderLinearLayout(){
        return orderLinearLayout;
    }
}
