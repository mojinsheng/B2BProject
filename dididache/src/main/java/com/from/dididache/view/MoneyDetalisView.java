package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * 余额明细列表
 * Created by USER on 2018/5/16.
 */

public class MoneyDetalisView extends BaseLinearLayout {
    private LinearLayout mContainerLayout;
    private BaseTitleView baseTitleView;
    private LayoutParams params;
    private ListView listView;
    public MoneyDetalisView(Context context) {
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
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        //params.setMargins(marginSize,marginSize*3,marginSize,0);
        this.addView(mContainerLayout,params);

        listView=new ListView(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        mContainerLayout.addView(listView,params);

    }
    public ListView getListView(){
        return listView;
    }
    public ImageView getback(){
        return baseTitleView.backIV;
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(mContext) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_moneydateils";
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
