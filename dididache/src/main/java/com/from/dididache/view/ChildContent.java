package com.from.dididache.view;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by USER on 2018/5/11.
 */

public class ChildContent extends LinearLayout {
    private FrameLayout layout;
    public ChildContent(Context context, int id) {
        super(context);
        layout = new FrameLayout(context);
        layout.setId(id);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        this.addView(layout, params);
    }
    public int getLayoutId(){
        return layout.getId();
    }
}
