package mojin.from.com.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tapfuns.utils.tool.TapfunsScreenUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mojin.from.com.pintugame.R;
import mojin.from.com.util.ImagePiece;
import mojin.from.com.util.ImageSpitterUtil;

/**
 * Created by Administrator on 2017/12/27.
 */
public class GamepintuLayout extends RelativeLayout implements View.OnClickListener{
    //宫格的行数
    private int mColumn=3;
    //容器内的边距
    private int mPadding;
    //每张小图的距离（横、 纵）
    private int mMagin=3;
    //容器的宽度
    private int mWidth,mHeight;
    private int mItemWidth,mitemHight;
    /**
     * 记录第一次点击的 ImageView
     */
    private ImageView mFirst;
    /**
     * 记录第二次点击的 ImageView
     */
    /**
     * 动画运行的标志位
     */
    private boolean isAniming;
    /**
     * 动画层
     */
    private ImageView mSecond;
    private ImageView[] mGmaePintuItems;
    /**
     * 动画运行的标志位
     */
    /**
     * 动画层
     */
    private RelativeLayout mAnimLayout;
    /**
     * 游戏的图片
     * @param context
     */
    private Bitmap mBitmap;
    private List<ImagePiece> mItemBitmps;
    private boolean once=false;
    public GamepintuLayout(Context context) {
        //super(context);
        this(context, null);
    }

    public GamepintuLayout(Context context, AttributeSet attrs) {
        //super(context, attrs);
        this(context, attrs,0);
    }
    public GamepintuLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Log.i("tapfuns","GamepintuLayout onMeasure");
        mWidth=Math.min(getMeasuredHeight(),getMeasuredWidth());
        mHeight=Math.max(getMeasuredHeight(),getMeasuredWidth());
        if(!once){
            //进行切图，以及排序
            initBitmap();
            //设置ImageView（item)的宽高等属性
            initItem();

        }
        Log.i("tapfuns","控件的宽度是："+mWidth);
        once=true;
        setMeasuredDimension(mWidth, mHeight);
    }
    private void initBitmap(){
        if(mBitmap==null){
            mBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.meinv);
        }
        mItemBitmps= ImageSpitterUtil.splitImage(mBitmap,mColumn);
        //打乱顺序
        Collections.sort(mItemBitmps, new Comparator<ImagePiece>() {
            @Override
            public int compare(ImagePiece imagePiece, ImagePiece t1) {
                return Math.random()>0.5?1:-1;
            }
        });

    }
    //设置imageView(Item)的宽度等属性
//    private void initItem() {
//
//    }
    //获取多个参数的最小值
    public int min(int... params){
        int min=params[0];
        for(int param:params){
            if(param<min){
                min=param;
            }
        }
        return min;
    }
    public void initItem(){
        Log.i("tapfuns","GamepintuLayout init");
 //       this.setBackgroundResource(R.drawable.meinv);
        mMagin= (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,3,getResources().getDisplayMetrics());
        mPadding=min(getPaddingLeft(),getPaddingTop(),getPaddingRight(),getPaddingBottom());
//        mItemWidth=(mWidth-mPadding-mMagin*(mColumn-1))/mColumn;
//        mitemHight=(mHeight-mPadding*2)/mColumn;
        mItemWidth=mWidth/mColumn;
        mitemHight=mHeight/mColumn;
        Log.i("tapfuns","子控件的宽度:"+((mItemWidth*mColumn)+(mMagin*2)));
         //Log.i("tapfuns","MeasuredHeight:"+h+",MeasuredWidth:"+w+",mWidth:"+mWidth);
        mGmaePintuItems=new ImageView[mColumn*mColumn];
        for (int i = 0; i < mGmaePintuItems.length; i++) {
            ImageView item = new ImageView(getContext());
            item.setScaleType(ImageView.ScaleType.FIT_XY);
            item.setOnClickListener(this);

            item.setImageBitmap(mItemBitmps.get(i).getBitmap());
            mGmaePintuItems[i] = item;
            item.setId(i + 1);
            item.setTag(i + "_" + mItemBitmps.get(i).getIndex());

            RelativeLayout.LayoutParams lp =
                    new LayoutParams(mItemWidth,
                            mitemHight);
            // 设置横向边距,不是最后一列
            if ((i + 1) % mColumn != 0)  {
               // lp.rightMargin = mMagin/2;
            }
            if ((i + 1) % mColumn == 0)  {

                item.setBackgroundColor(Color.RED);
            }
//            // 如果不是第一列
            if (i % mColumn != 0)  {
                //item.setBackgroundColor(Color.BLACK);
                lp.addRule(RelativeLayout.RIGHT_OF,//
                        mGmaePintuItems[i - 1].getId());
            }
            // 如果不是第一行，//设置纵向边距，非最后一行
            if ((i + 1) > mColumn)  {
                //lp.topMargin = mMagin/2;
                lp.addRule(RelativeLayout.BELOW,//
                        mGmaePintuItems[i - mColumn].getId());
                item.setBackgroundColor(Color.RED);
            }
            addView(item, lp);
        }
        Log.i("tapfuns","GamepintuLayout for");
    }

    @Override
    public void onClick(View v) {
/**
 * 如果两次点击是同一个
 *
 */
        if (isAniming)
            return;
        if (mFirst == v)  {
            mFirst.setColorFilter(null);
            mFirst = null;
            return;
        }
        //点击第一个 Item
        if (mFirst == null)  {
            mFirst = (ImageView) v;
            mFirst.setColorFilter(Color.parseColor("#55FF0000"));
        } else//点击第二个 Item
        {
            mSecond = (ImageView) v;
            exchangeView();
        }
    }
    private void exchangeView()  {
        mFirst.setColorFilter(null);
        setUpAnimLayout();
        // 添加FirstView
        ImageView first = new ImageView(getContext());
        first.setImageBitmap(mItemBitmps
                .get(getImageIndexByTag((String) mFirst.getTag())).getBitmap());
        LayoutParams lp = new LayoutParams(mItemWidth, mItemWidth);
        lp.leftMargin = mFirst.getLeft() - mPadding;
        lp.topMargin = mFirst.getTop() - mPadding;
        first.setLayoutParams(lp);
        mAnimLayout.addView(first);
        // 添加SecondView
        ImageView second = new ImageView(getContext());
        second.setImageBitmap(mItemBitmps
                .get(getImageIndexByTag((String) mSecond.getTag())).getBitmap());
        LayoutParams lp2 = new LayoutParams(mItemWidth, mItemWidth);
        lp2.leftMargin = mSecond.getLeft() - mPadding;
        lp2.topMargin = mSecond.getTop() - mPadding;
        second.setLayoutParams(lp2);
        mAnimLayout.addView(second);

        // 设置动画
        TranslateAnimation anim = new TranslateAnimation(0, mSecond.getLeft()
                - mFirst.getLeft(), 0, mSecond.getTop() - mFirst.getTop());
        anim.setDuration(300);
        anim.setFillAfter(true);
        first.startAnimation(anim);

        TranslateAnimation animSecond = new TranslateAnimation(0,
                mFirst.getLeft() - mSecond.getLeft(), 0, mFirst.getTop()
                - mSecond.getTop());
        animSecond.setDuration(300);
        animSecond.setFillAfter(true);
        second.startAnimation(animSecond);
        // 添加动画监听
        anim.setAnimationListener(new Animation.AnimationListener()
        {

            @Override
            public void onAnimationStart(Animation animation)
            {
                isAniming = true;
                mFirst.setVisibility(INVISIBLE);
                mSecond.setVisibility(INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                String firstTag = (String) mFirst.getTag();
                String secondTag = (String) mSecond.getTag();

                String[] firstParams = firstTag.split("_");
                String[] secondParams = secondTag.split("_");

                mFirst.setImageBitmap(mItemBitmps.get(Integer
                        .parseInt(secondParams[0])).getBitmap());
                mSecond.setImageBitmap(mItemBitmps.get(Integer
                        .parseInt(firstParams[0])).getBitmap());

                mFirst.setTag(secondTag);
                mSecond.setTag(firstTag);
                mFirst.setVisibility(VISIBLE);
                mSecond.setVisibility(VISIBLE);
                mFirst = mSecond = null;
                mAnimLayout.removeAllViews();
               checkSuccess();
                isAniming = false;
            }
        });

    }
    private void setUpAnimLayout()
    {
        if (mAnimLayout == null)
        {
            mAnimLayout = new RelativeLayout(getContext());
            addView(mAnimLayout);
        }

    }

    private int getImageIndexByTag(String tag)
    {
        String[] split = tag.split("_");
        return Integer.parseInt(split[0]);

    }
    /**
     * 判断游戏是否成功
     */
    private void checkSuccess()
    {
        boolean isSuccess = true;
        for (int i = 0; i < mGmaePintuItems.length; i++)
        {
            ImageView first = mGmaePintuItems[i];
            Log.e("TAG", getIndexByTag((String) first.getTag()) + "");
            if (getIndexByTag((String) first.getTag()) != i)
            {
                isSuccess = false;
            }
        }

        if (isSuccess)
        {
            Toast.makeText(getContext(), "Success , Level Up !",
                    Toast.LENGTH_LONG).show();
            // nextLevel();
        }
    }

    /**
     * 获得图片的真正索引
     * @param tag
     * @return
     */
    private int getIndexByTag(String tag)
    {
        String[] split = tag.split("_");
        return Integer.parseInt(split[1]);
    }
}
