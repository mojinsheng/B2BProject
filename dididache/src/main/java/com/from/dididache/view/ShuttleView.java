package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by USER on 2018/4/4.
 */

public class ShuttleView extends BaseLinearLayout {
    private Context context;
    private RelativeLayout.LayoutParams layoutParams;
    private LinearLayout mLinearLayout,clientLinearLayout,currentLinearLayout,endLinearLayout,mContentLinearLayout;
    private RelativeLayout iconRelativeLayout,chucheRelativeLayout;
    private LinearLayout phoneCenterLinearLayout, supportMap;
    private BaseTitleView baseTitleView;
    private LayoutParams params;
    private ChildContent supportMapFrameLayout;
    private TextView textView3,textView4,textViewCurrent,textViewEnd;
    private ImageView img_phone;
    private Button btn_confirm;
    public ShuttleView(Context _context) {
        super(_context);
        context = _context;
        init();
    }

    public ShuttleView(Context _context, AttributeSet attrs) {
        super(_context, attrs);
        context = _context;
        init();
    }
    public void init(){

        this.setOrientation(LinearLayout.VERTICAL);
        this.setBackgroundColor(Color.rgb(242,242,242));
        mLinearLayout=new LinearLayout(context);
        mLinearLayout.setBackgroundColor(Color.rgb(35,38,68));
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.087)));
        this.addView(mLinearLayout,params);

        //标题
        baseTitleView=getTitle();
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mLinearLayout.addView(baseTitleView,params);



        mContentLinearLayout=new LinearLayout(context);
        mContentLinearLayout.setBackgroundColor(Color.WHITE);
        mContentLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,((int)(mHeight*0.151)));
        params.setMargins(marginSize/2,marginSize/2,marginSize/2,marginSize/2);
       this.addView(mContentLinearLayout,params);
        //乘客的信息
        clientLinearLayout=new LinearLayout(context);
        clientLinearLayout.setOrientation(LinearLayout.VERTICAL);

        params=new LayoutParams(((int)(mWidth*0.5)),LayoutParams.MATCH_PARENT);
       // clientLinearLayout.setBackgroundColor(Color.BLUE);
        params.setMargins(marginSize,marginSize,marginSize/2,marginSize/2);
        mContentLinearLayout.addView(clientLinearLayout,params);

        //目的地
        currentLinearLayout=new LinearLayout(context);

        currentLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize);
        params.topMargin=marginSize/2;
        clientLinearLayout.addView(currentLinearLayout,params);


        textView3=new TextView(context);
        textView3.setText("去白云机场");
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
        currentLinearLayout.addView(textViewCurrent,params);

        //路程的距离
        endLinearLayout=new LinearLayout(context);
        endLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize);
        params.topMargin=marginSize/2;
        clientLinearLayout.addView(endLinearLayout,params);


        textView4=new TextView(context);
        textView4.setText("全程3公里");
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
        endLinearLayout.addView(textViewEnd,params);


        phoneCenterLinearLayout=new LinearLayout(context);
        phoneCenterLinearLayout.setOrientation(LinearLayout.VERTICAL);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        params.setMargins(marginSize/2,((int)(marginSize*0.3)),marginSize/2,((int)(marginSize*0.6)));
        mContentLinearLayout.addView(phoneCenterLinearLayout,params);

        //电话
        img_phone=new ImageView(context);
        params=new LayoutParams(((int)(mWidth*0.125)),((int)(mWidth*0.1025)));
        params.gravity=Gravity.CENTER;
        img_phone.setBackgroundResource(createDrawable("xmy_phone"));
        phoneCenterLinearLayout.addView(img_phone,params);

        //确认上车
        btn_confirm=new Button(context);
        btn_confirm.setText("确认上车");
        btn_confirm.setTextSize(20);
        btn_confirm.getPaint().setFakeBoldText(true);
        params=new LayoutParams(((int)(mWidth*0.23)),((int)(mWidth*0.102)));
        params.topMargin=marginSize/2;
        params.gravity=Gravity.CENTER;
        phoneCenterLinearLayout.addView(btn_confirm,params);

        //显示地图
         supportMapFrameLayout=new ChildContent(mContext,12345);
        //supportMapFrameLayout.setId(1111);
        //supportMap.setBackgroundColor(Color.BLUE);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        this.addView(supportMapFrameLayout,params);


    }
    public ChildContent getSupportMapFrameLayout(){
        return supportMapFrameLayout;
    }
    public ImageView getPersonCenter(){
        return baseTitleView.backIV;
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(context) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "Shuttle";
            }

            @Override
            public int[] getTitleSize() {
                height = (int) ( marginSize*1.5);
                width = (int) (marginSize*4);
                return new int[] { width, height };
            }

            @Override
            public String getImageViewName() {
                return "xmy_personcenter";
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
            public boolean hasSetButton() {
                return true;
            }
        };
    }

}
