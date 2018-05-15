package com.from.dididache.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.from.dididache.R;



/**
 * Created by USER on 2018/5/10.
 */

@SuppressLint("AppCompatCustomView")
public class LineEditText extends EditText{
    private Paint mPaint;
    private int mLineColor;




    public LineEditText(Context context) {
        super(context);
        initData(context);
    }

    private void initData(Context context){
        TypedArray attrArrays = context.obtainStyledAttributes(R.styleable.LineEditeText);

        mPaint = new Paint();
        int lenght = attrArrays.getIndexCount();
        for(int i = 0 ; i < lenght; i ++){
            int index = attrArrays.getIndex(i);
            switch (index){
                case R.styleable.LineEditeText_lineColorEt:
                    mLineColor =  attrArrays.getColor(index,0xFFF);
                    break;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mLineColor);
        canvas.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1, mPaint);
    }
}
