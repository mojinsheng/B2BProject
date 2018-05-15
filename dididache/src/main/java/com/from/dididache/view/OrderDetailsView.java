package com.from.dididache.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by USER on 2018/5/12.
 */

public class OrderDetailsView extends BaseLinearLayout {
    private BaseTitleView baseTitleView;
    private LayoutParams params;
    private LinearLayout mContainerLayout,clientLinearLayout;
    private ListView listView;
    public OrderDetailsView(Context context) {
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

        //乘客订单信息
        clientLinearLayout=new LinearLayout(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mHeight*0.56));
        clientLinearLayout.setBackgroundColor(Color.rgb(255,255,255));
        params.setMargins(marginSize,0,marginSize,marginSize);
        mContainerLayout.addView(clientLinearLayout,params);

        listView=new ListView(mContext);
        params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        clientLinearLayout.addView(listView,params);
    }
    public ImageView getImgBcak(){
        return baseTitleView.backIV;
    }
    public ListView getListView(){
        return listView;
    }
    public BaseTitleView getTitle(){
        return new BaseTitleView(mContext) {
            int width = 0;
            int height = 0;
            @Override
            public String titleName() {
                return "xmy_order";
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
