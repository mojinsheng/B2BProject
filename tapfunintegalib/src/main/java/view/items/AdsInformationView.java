package view.items;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import view.BaseLinearLayout;


public class AdsInformationView extends BaseLinearLayout{
    private LinearLayout layout;
    private LayoutParams params;
    private TextView textView,textView1;
    private ImageView imageView;
	public AdsInformationView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	    init(context);
	}
	public TextView getTextView() {
		return textView;
	}
	public void setTextView(TextView textView) {
		this.textView = textView;
	}
	public ImageView getImageView() {
		return imageView;
	}
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	public void init(Context context){
		layout=new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);
        if(_isPortrait){
        	params=new LayoutParams(mWidth,(int)(mHeight*0.34));
        }else{
        	params=new LayoutParams(mWidth, (int)(mHeight*0.512));
        }
	
		params.setMargins(marginSize/2, marginSize/2, marginSize/2, marginSize/2);
		this.addView(layout, params);
		
		textView=new TextView(context);
		params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		params.topMargin=marginSize/4;
		textView.setEllipsize(TruncateAt.END);
		textView.setSingleLine(true);
		textView.setTextColor(Color.BLACK);
		layout.addView(textView, params);
		
		imageView=new ImageView(context);
		if(_isPortrait){
			params=new LayoutParams(LayoutParams.MATCH_PARENT,mHeight/4);
		}else{
			params=new LayoutParams(mWidth/2,mWidth/5);
		}
		params.topMargin=marginSize/2;
		params.rightMargin=marginSize;
		imageView.setScaleType(ScaleType.FIT_XY);
		layout.addView(imageView, params);
		
		textView1=new TextView(context);
		params=new LayoutParams(marginSize*2,LayoutParams.WRAP_CONTENT);
		params.topMargin=marginSize/2;
		textView1.setEllipsize(TruncateAt.END);
		textView1.setSingleLine(true);
		textView1.setTextColor(Color.rgb(173,173,175));
		textView1.setTextSize(12);
		textView1.setGravity(Gravity.CENTER);
		textView1.setBackgroundResource(createDrawable("setbar_bg"));
		layout.addView(textView1, params);
	}
	public TextView getTextView1() {
		return textView1;
	}
	public void setTextView1(TextView textView1) {
		this.textView1 = textView1;
	}
}
