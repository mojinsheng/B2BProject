package mojin.from.com.luckypan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2017/11/27.
 */
public class LuckyPan extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private Thread thread;
    private boolean idRuning;
    private String []mStrs=new String[]{"单发相机","Ipad","恭喜发财","苹果手机","衣服一件","恭喜发财"};
    private int mImgs[]=new int[]{R.drawable.danfa,R.drawable.ipad,R.drawable.other,
            R.drawable.iphone,R.drawable.meinv,R.drawable.other,};
    private int mColors[]=new int[]{0xFFFFC300,0XFFF17E01,
            0xFFFFC300,0XFFF17E01,0xFFFFC300,0XFFF17E01};
    private int mItemsCounts=6;
    private Bitmap mImgBitMap[];
    /**
     * 整个转盘的范围
     */
    private RectF mRect=new RectF();

    /**
     * 整个转盘的直径
     * @param context
     */
    private int mRadius;

    /**
     * 绘制转盘的画笔
     * @param context
     */
    private Paint mArcPaint;
    /**
     * 绘制的文字
     */
    private Paint mTextPaint;

    //转盘的速度
    private double mSpeed=0;

    private volatile float mStartAngle;
    /*
    判断是否点击停止按钮
     */
    private  boolean isShouldEnd;

    /**
     *转盘的中心位置
     * @param context
     */
    private int mCenter;
    /**
     *
     */
    private int mPadding;
    private Bitmap mbgBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.bg);
    private float mTextSize= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,20,
            getResources().getDisplayMetrics());
    public LuckyPan(Context context) {
        this(context,null);
    }
    public LuckyPan(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        mHolder=getHolder();
        mHolder.addCallback(this);
        //可获得焦点
        setFocusable(true);
        setFocusableInTouchMode(true);
        //设置常量
        setKeepScreenOn(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        /**
         * 初始化转盘的画笔
         */
        mArcPaint=new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setDither(true);
        /**
         * 初始化文本的颜色
         */
        mTextPaint=new Paint();
        mTextPaint.setColor(Color.GRAY);
        mTextPaint.setTextSize(mTextSize);

        /**
         * 初始化转盘的范围
         */
//        mRange = new RectF(getPaddingLeft(), getPaddingLeft(), mRadius
//                + getPaddingLeft(), mRadius + getPaddingLeft());
        mRect=new RectF(mPadding,mPadding,mPadding+mRadius,mPadding+mRadius);
        //初始化图片数组
        mImgBitMap=new Bitmap[mItemsCounts];

        for(int i=0;i<mItemsCounts;i++){
            mImgBitMap[i]=BitmapFactory.decodeResource(getResources(),mImgs[i]);
        }





        idRuning=true;
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (idRuning){

                    try {
                        long start=System.currentTimeMillis();
                        draw();
                        long end=System.currentTimeMillis();
                        if(end-start<50){
                            Thread.sleep(50-(end-start));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
    public void draw(){
        mCanvas=mHolder.lockCanvas();
       try {

           if(mCanvas!=null){
               //绘制转盘背景
               drawBg();
               //绘制转盘
               float temAngle=mStartAngle;
               float sweepAngle=360/mItemsCounts;
               for(int i=0;i<mItemsCounts;i++){
                   mArcPaint.setColor(mColors[i]);
                   mCanvas.drawArc(mRect,temAngle,sweepAngle,true,mArcPaint);
                   //绘制文本
                   drawText(temAngle,sweepAngle,mStrs[i]);

                   drawIcon(temAngle,mImgBitMap[i]);
                   temAngle+=sweepAngle;
               }
               mStartAngle+=mSpeed;
               if(isShouldEnd){
                    mSpeed-=1;
               }
               if(mSpeed<=0){
                   mSpeed=0;
                   isShouldEnd=false;
               }

           }
       }catch (Exception e){

       }finally {
           if(mCanvas!=null){
               mHolder.unlockCanvasAndPost(mCanvas);
           }

       }

    }

    /**
     * 点击启动旋转
     */
    public void lackyStart(int index){


        //计算每项的角度
        float angle=360/mItemsCounts;
        //计算每项的中奖概率
        //1>>150-210
        //0>>210-270
        float form=270-(index+1)*angle;
        float end=form+angle;

        //设置停下来的距离
        float targetFrom=360*4+form;
        float targetEnd=360*4+end;

        float v1= (float) ((-1+Math.sqrt(1+8*targetFrom))/2);
        float v2= (float) ((-1+Math.sqrt(1+8*targetEnd))/2);

        mSpeed=v1+Math.random()*(v2-v1);
        //mSpeed=v1;
        isShouldEnd=false;
    }
    public void luckyEnd(){
        mStartAngle=0;
        isShouldEnd=true;
    }
    public boolean isStart(){
        return mSpeed!=0;
    }
    public boolean isShouldEnd(){
        return isShouldEnd;
    }
    public void drawIcon( float temAngle,Bitmap bitmap){
        //设置转针的图片
        int imgWidth=mRadius/8;
        float angle= (float) ((temAngle+360/mItemsCounts/2)*Math.PI/180);
        int x= (int) (mCenter+mRadius/2/2*Math.cos(angle));
        int y= (int) (mCenter+mRadius/2/2*Math.sin(angle));
        Rect rect=new Rect(x-imgWidth/2,y-imgWidth/2,x+imgWidth/2,y+imgWidth/2);
        mCanvas.drawBitmap(bitmap,null,rect,null);
    }
    public void drawBg(){
            mCanvas.drawColor(Color.WHITE);
//        mCanvas.drawBitmap(mbgBitmap, null, new Rect(mPadding,
//                mPadding , getMeasuredWidth(),
//                getMeasuredWidth()), null);
        mCanvas.drawBitmap(mbgBitmap,null,new Rect(mPadding/2,mPadding/2,
                 getMeasuredWidth()-mPadding/2,getMeasuredHeight()-mPadding/2),null);
    }
    public void drawText(float temAngle,float sweepAngle,String strs){
        Path path=new Path();
        path.addArc(mRect,temAngle,sweepAngle);
        //利用水平偏移量让文字居中

        int hOffset=(int)(mRadius*Math.PI/mItemsCounts/2-((float)mTextPaint.measureText(strs)/2));


        int vOffset=mRadius/2/6;
        mCanvas.drawTextOnPath(strs,path,hOffset,0,mTextPaint);



    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        idRuning=false;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 竖屏是宽度
         * 横屏是高度
         */
        int width=Math.min(getMeasuredWidth(),getMeasuredHeight());
        mPadding=getPaddingLeft();
        //半径
        mRadius = width - getPaddingLeft() - getPaddingRight();
        //mRadius=width-mPadding;
        //中心点
        mCenter=width/2;
        setMeasuredDimension((int)(width),(int)(width));
    }
}
