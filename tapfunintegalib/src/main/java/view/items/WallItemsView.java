package view.items;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import view.BaseLinearLayout;

public class WallItemsView extends BaseLinearLayout{
	
	private LinearLayout linearLayout,linearLayoutDesc,linearLayoutIntegral;
	private LayoutParams params;
	private Button button;
	private ImageView img_pro;
	private TextView te_textView,te_textViewDesc,te_integral;
	private int heigth;

	public int getHeigth() {
		return mHeight;
	}
	public WallItemsView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	@SuppressLint("NewApi")
	public void init(Context context){	
		linearLayout=new LinearLayout(context);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,mHeight/10);
		params.setMargins(marginSize/2, marginSize/4, marginSize/2, marginSize/4);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		this.addView(linearLayout, params);
	
		//图片
		img_pro=new ImageView(context);
		if(_isPortrait){
			params=new LayoutParams((int)(mHeight*0.0850764708),LayoutParams.MATCH_PARENT);
		}else{
			params=new LayoutParams((int)(mHeight*0.120850764708),LayoutParams.MATCH_PARENT);
		}
		params.topMargin=marginSize/5;
		img_pro.setScaleType(ScaleType.FIT_XY);
		linearLayout.addView(img_pro, params);
		//文字说明布局
	
		linearLayoutDesc=new LinearLayout(context);
		if(_isPortrait){
			params=new LayoutParams((int)(mWidth*0.58),LayoutParams.WRAP_CONTENT);
			params.topMargin=marginSize/3;
			params.leftMargin=marginSize/4;
		}else{
			params=new LayoutParams((int)(mWidth*0.58),LayoutParams.WRAP_CONTENT);
			params.topMargin=marginSize/3;
			params.leftMargin=marginSize*2;
		}
//		params=new LayoutParams((int)(mWidth*0.58),LayoutParams.WRAP_CONTENT);
//		params.topMargin=marginSize/3;
//		params.leftMargin=marginSize/4;
		linearLayoutDesc.setOrientation(LinearLayout.VERTICAL);
		linearLayout.addView(linearLayoutDesc, params);
		
		//标题说明
		te_textView=new TextView(context);
		params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		params.topMargin=marginSize/4;
		te_textView.setEllipsize(TruncateAt.END);
		te_textView.setGravity(Gravity.CENTER);
		te_textView.setSingleLine(true);
		te_textView.setTextColor(Color.rgb(115,164,196));
		te_textView.getPaint().setFakeBoldText(true);
		linearLayoutDesc.addView(te_textView, params);
		

		//说明
		te_textViewDesc=new TextView(context);
		params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		params.topMargin=marginSize/4;
		te_textViewDesc.setEllipsize(TruncateAt.END);
		te_textViewDesc.setGravity(Gravity.CENTER);
		te_textViewDesc.setSingleLine(true);
		te_textViewDesc.setTextColor(Color.rgb(213,214,216));
		linearLayoutDesc.addView(te_textViewDesc, params);
		//te_textView.getPaint().setFakeBoldText(true);
		
		linearLayoutIntegral=new LinearLayout(context);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.FILL_PARENT);
		params.topMargin=marginSize/2;
		linearLayoutIntegral.setOrientation(LinearLayout.VERTICAL);
		linearLayout.addView(linearLayoutIntegral, params);
		
		//下载按钮
		button=new Button(context);
		if(_isPortrait){
			params=new LayoutParams(LayoutParams.WRAP_CONTENT,(int)(marginSize*1.5));
		}else{
			params=new LayoutParams(LayoutParams.WRAP_CONTENT,(int)(marginSize*2));
		}
		params.gravity=Gravity.CENTER;
		params.topMargin=marginSize/3;
		button.setTextSize(12);
		button.setPadding(0, 0, 0, 0);
		button.setAllCaps(false);
		button.setGravity(Gravity.CENTER);
		button.setBackgroundResource(createDrawable("btn_shape"));
		button.setText(createString("button_download"));
		linearLayoutIntegral.addView(button, params);
		
		
		//积分
		te_integral=new TextView(context);
		params=new LayoutParams(LayoutParams.FILL_PARENT,marginSize);
		te_integral.setTextColor(Color.rgb(165,166,168));
		params.gravity=Gravity.BOTTOM;
		te_integral.setTextSize(10);
		te_integral.setGravity(Gravity.CENTER);
		linearLayoutIntegral.addView(te_integral, params);
	}
	public LinearLayout getLinearLayout() {
		return linearLayout;
	}
	public void setLinearLayout(LinearLayout linearLayout) {
		this.linearLayout = linearLayout;
	}
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
	public ImageView getImg_pro() {
		return img_pro;
	}
	public void setImg_pro(ImageView img_pro) {
		this.img_pro = img_pro;
	}
	public TextView getTe_textView() {
		return te_textView;
	}
	public void setTe_textView(TextView te_textView) {
		this.te_textView = te_textView;
	}
	public TextView getTe_textViewDesc() {
		return te_textViewDesc;
	}
	public void setTe_textViewDesc(TextView te_textViewDesc) {
		this.te_textViewDesc = te_textViewDesc;
	}
	public TextView getTe_integral() {
		return te_integral;
	}
	public void setTe_integral(TextView te_integral) {
		this.te_integral = te_integral;
	}
}
