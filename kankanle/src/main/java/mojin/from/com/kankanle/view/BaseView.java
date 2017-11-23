package mojin.from.com.kankanle.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.tapfuns.utils.tool.TapfunsScreenUtil;

import mojin.from.com.kankanle.R;

/**
 * Created by Administrator on 2017/11/17.
 */

public class BaseView extends View {
    protected TapfunsScreenUtil mScreen;
    protected int mWidth;
    protected int mHeight;
    protected Context mContext;
    protected boolean isPhone;
    private int marginSize;
    private int mLastX,mLastY;

    //画笔
    private Paint paint;
    //路径
    private Path path;
    //画布
    private Canvas canvas;
    //图片
    public Bitmap bitmap,mbitmap;
    private String mText;
    private Paint mTextPaint;
    private Rect rect;
    private volatile boolean mComplete=false;
    public BaseView(Context context) {
        super(context);
        init(context);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        paint=new Paint();
        //canvas=new Canvas();
        path=new Path();
       // mbitmap= BitmapFactory.decodeResource(getResources(), R.drawable.kankanle);
        mText="谢谢惠顾";
        rect=new Rect();
        mTextPaint=new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height=getMeasuredHeight();
        int width=getMeasuredWidth();
        bitmap=Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        canvas=new Canvas(bitmap);

        //设置画笔的属性
        setOutPaint();
        setupBackPaint();
        canvas.drawColor(Color.parseColor("#c0c0c0"));
    }

    /**
     * 设置绘制中奖信息的属性
     */
    private void setupBackPaint() {

        mTextPaint.setColor(Color.GRAY);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextSize(50);
        mTextPaint.getTextBounds(mText,0,mText.length(),rect);
    }

    public void setOutPaint(){
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawBitmap(mbitmap,0,0,null);
        canvas.drawText(mText,getWidth()/2-rect.width()/2,getHeight()/2+rect.height()/2,mTextPaint);
         if(mComplete){
             if(mLister!=null){
                 mLister.complete();
             }
         }

        if(!mComplete){

            drawPath();
            canvas.drawBitmap(bitmap,0,0,null);
        }else{

        }
    }

    private void drawPath() {
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        int X=(int)event.getX();
        int Y=(int)event.getY();
      switch (action)
      {
          case MotionEvent.ACTION_DOWN :
              mLastX=X;
              mLastY=Y;
              path.moveTo(mLastX,mLastY);
              break;
          case MotionEvent.ACTION_MOVE:
              int dx=Math.abs(X-mLastX);
              int dy=Math.abs(Y-mLastY);
              if(dx>3||dy>3){
                  path.lineTo(X,Y);
              }
              mLastX=X;
              mLastY=Y;
              break;
          case MotionEvent.ACTION_UP:
              new Thread(run).start();
          default:
              break;
      }
        invalidate();
        return true;
    }
    public Runnable run=new Runnable() {
        @Override
        public void run() {
            int width=getWidth();
            int height=getHeight();

            float chatu=0;
            float total=width*height;

            Bitmap xxbitmap=bitmap;
            int [] mPixels=new int[width*height];
            xxbitmap.getPixels(mPixels,0,width,0,0,width,height);
            for(int i=0;i<width;i++){
                    for (int k=0;k<height;k++){
                        int index=i+k*width;
                        if(mPixels[index]==0){
                            chatu++;
                        }


                    }
            }
            if(total>0&&chatu>0){
                int percet=(int)(chatu*100/total);
                if(percet>70){
                    mComplete=true;
                    postInvalidate();

                }
            }
        }
    };

    public void setmLister(OnGuaGuaKaCompleteLister mLister) {
        this.mLister = mLister;
    }

    public interface OnGuaGuaKaCompleteLister{
        public void complete();
    }
    public  OnGuaGuaKaCompleteLister mLister;
}
