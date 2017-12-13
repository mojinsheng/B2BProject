package mojin.from.com.luckypan;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2017/11/27.
 */
public class SurFaceViewTempalte extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private Thread thread;
    private boolean idRuning;
    public SurFaceViewTempalte(Context context) {
        this(context,null);
    }
    public SurFaceViewTempalte(Context context, AttributeSet attributeSet) {
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
        idRuning=true;
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (idRuning){
                    draw();
                }
            }
        });
        thread.start();
    }
    public void draw(){
        mCanvas=mHolder.lockCanvas();
       try {

           if(mCanvas!=null){

           }
       }catch (Exception e){

       }finally {
           if(mCanvas!=null){
               mHolder.unlockCanvasAndPost(mCanvas);
           }

       }

    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        idRuning=false;

    }
}
