package view;

import com.tapfuns.utils.res.TapfunsResourceUtil;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import view.video.FullScreenVideoView;

public class AlertVideoView extends BaseLinearLayout{
	private LinearLayout linearLayout,linearLayout1,linearLayoutClose,linearLayoutGameDesc,
	linearLayoutGameDesc1,linearLayoutGameDesc2;
	private RelativeLayout relativeLayout;
	private RelativeLayout.LayoutParams layoutParams;
	private ImageView img_close,img_content,img_volumvideo,img_icon;
	private LayoutParams params;
	private FullScreenVideoView videoView,videoView1;
	private TextView te_title,te_desc,te_point;
	private Button btn_desc;
	private ProgressBar pb;
	public static boolean isPortrait;
	public FullScreenVideoView getVideoView() {
		return videoView;
	}
	public Button getBtn_desc() {
		return btn_desc;
	}
	public void setBtn_desc(Button btn_desc) {
		this.btn_desc = btn_desc;
	}
	private String flags;
	public AlertVideoView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	public ImageView getImg_close() {
		return img_close;
	}
	public void setImg_close(ImageView img_close) {
		this.img_close = img_close;
	}
	public ImageView getImg_content() {
		return img_content;
	}
	public void setImg_content(ImageView img_content) {
		this.img_content = img_content;
	}
	public ImageView getImg_content_close() {
		return img_volumvideo;
	}
//	public void setImg_content_close(ImageView img_content_close) {
//		this.img_content_close = img_content_close;
//	}
	public void init(Context context){
		this.setOrientation(LinearLayout.VERTICAL);
		this.setGravity(Gravity.CENTER);
		this.isPortrait=_isPortrait;
		linearLayout=new LinearLayout(context);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		if(isPortrait){
			params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mHeight*0.6));
		}else{
			params=new LayoutParams((int)(mWidth*0.5),LayoutParams.MATCH_PARENT);
			params.topMargin=marginSize;
			params.bottomMargin=marginSize;
		}
		params.leftMargin=marginSize;
		params.rightMargin=marginSize;
		this.addView(linearLayout, params);
		//关闭按钮布局
		linearLayoutClose=new LinearLayout(context);
		linearLayoutClose.setGravity(Gravity.RIGHT);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(marginSize*1.8));
		linearLayout.addView(linearLayoutClose, params);
		
		
		img_close=new ImageView(context);
		params=new LayoutParams((int)(marginSize*1.7),LayoutParams.MATCH_PARENT);
		img_close.setBackgroundColor(createDrawable("deletebtnalert"));
		img_close.setScaleType(ScaleType.FIT_XY);
		img_close.setBackgroundResource(createDrawable("deletebtnalert"));
		linearLayoutClose.addView(img_close, params);
		
		linearLayout1=new LinearLayout(context);
		linearLayout1.setOrientation(LinearLayout.VERTICAL);
		linearLayout1.setBackgroundColor(Color.WHITE);

			params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);

		linearLayout.addView(linearLayout1, params);
				
		//展示的内容布局
		relativeLayout=new RelativeLayout(context);
		relativeLayout.setBackgroundColor(Color.rgb(44, 44, 44));
		if(isPortrait){
			params=new LayoutParams(LayoutParams.MATCH_PARENT, mHeight/4);
		}else{
			params=new LayoutParams(LayoutParams.MATCH_PARENT, mHeight/3);
		}
		params.setMargins(marginSize/3, marginSize/3, marginSize/3, marginSize/3);
	
		linearLayout1.addView(relativeLayout, params);
		
		

		
		//图片
		videoView=new FullScreenVideoView(context);
		//videoView.setZOrderOnTop(true);
		layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		//params.setMargins(marginSize, marginSize, marginSize, marginSize);
		//videoView.setBackgroundColor(Color.BLUE);
		//img_content.setScaleType(ScaleType.FIT_XY);
		relativeLayout.addView(videoView, layoutParams);
		
		 pb = new ProgressBar(context, null, android.R.attr.progressBarStyleLarge);
		//pb.setBackgroundResource(TapfunsResourceUtil.findDrawableIdByName(context, "progressbg"));
		Drawable drawable=context.getResources().getDrawable(TapfunsResourceUtil.findDrawableIdByName(context, "progressbg"));
		pb.setIndeterminateDrawable(drawable);;//relativeLayout=new RelativeLayout(context);
		//indeterminateDrawable
		//relativeLayout.setBackgroundResource(TapfunsResourceUtil.findDrawableIdByName(context, "movie_loading"));
		layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		relativeLayout.addView(pb, layoutParams);
		
		
		
//		//关闭按钮
		img_volumvideo=new ImageView(context);
		if(isPortrait){
			layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*1.5),(int)(marginSize*1.5));
		}else{
			layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*2),(int)(marginSize*2));
		}
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		img_volumvideo.setBackgroundResource(createDrawable("volumclosevideo"));
		
		relativeLayout.addView(img_volumvideo, layoutParams);
		//游戏详情
		linearLayoutGameDesc=new LinearLayout(context);
		//linearLayoutGameDesc.setBackgroundColor(Color.RED);
		linearLayoutGameDesc.setOrientation(LinearLayout.HORIZONTAL);
		if(isPortrait){
			params=new LayoutParams(LayoutParams.MATCH_PARENT,mHeight/10);
		}else{
			params=new LayoutParams(LayoutParams.MATCH_PARENT,mHeight/6);
		}
		params.setMargins(marginSize, marginSize/4, marginSize, marginSize);
		linearLayout1.addView(linearLayoutGameDesc, params);
		
		//icon
		img_icon=new ImageView(context);
		if(isPortrait){
			params=new LayoutParams(mHeight/10,LayoutParams.MATCH_PARENT);
		}else{
			params=new LayoutParams(mHeight/6,LayoutParams.MATCH_PARENT);
		}
	
		img_icon.setScaleType(ScaleType.FIT_XY);
		linearLayoutGameDesc.addView(img_icon, params);
		
		//游戏说明
		linearLayoutGameDesc1=new LinearLayout(context);
		//linearLayoutGameDesc1.setBackgroundColor(Color.RED);
		linearLayoutGameDesc1.setOrientation(LinearLayout.VERTICAL);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		params.topMargin=marginSize/2;
		//params.leftMargin=marginSize;
		linearLayoutGameDesc.addView(linearLayoutGameDesc1, params);
		
		//标题说明
		te_title=new TextView(context);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,1);
		//params.topMargin=marginSize/4;
		te_title.setEllipsize(TruncateAt.END);
		te_title.setTextColor(Color.BLACK);
		te_title.setSingleLine(true);
		//te_title.setTextColor(Color.rgb(115,164,196));
		te_title.getPaint().setFakeBoldText(true);
		linearLayoutGameDesc1.addView(te_title, params);
		
		te_desc=new TextView(context);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,1);
		//params.topMargin=marginSize/4;
		te_desc.setEllipsize(TruncateAt.END);
//		te_textView.setGravity(Gravity.CENTER);
		te_desc.setSingleLine(true);
		te_desc.setTextSize(12);
		//te_desc.setTextColor(Color.rgb(115,164,196));
		//te_desc.getPaint().setFakeBoldText(true);
		linearLayoutGameDesc1.addView(te_desc, params);
		
		//查看详情
		linearLayoutGameDesc2=new LinearLayout(context);
		linearLayoutGameDesc2.setOrientation(LinearLayout.VERTICAL);
//		linearLayoutGameDesc2.setBackgroundColor(Color.RED);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		params.bottomMargin=marginSize;
		linearLayout1.addView(linearLayoutGameDesc2, params);
		
		
		//详情按钮
		btn_desc=new Button(context);
		if(isPortrait){
			params=new LayoutParams(mWidth/3,mWidth/9);
		}else{
			params=new LayoutParams(mWidth/3,mWidth/11);
		}
		params.gravity=Gravity.CENTER;
		btn_desc.setBackgroundColor(Color.rgb(255,69,70));
		btn_desc.setTextColor(Color.WHITE);
		btn_desc.setText(createString("button_desc"));
		linearLayoutGameDesc2.addView(btn_desc, params);
		
		
//		te_point=new TextView(context);
//		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
//		//params.topMargin=marginSize/4;
//		te_point.setEllipsize(TruncateAt.END);
//		te_point.setGravity(Gravity.CENTER);
//		te_point.setSingleLine(true);
//		te_point.setTextSize(12);
//		//te_desc.setTextColor(Color.rgb(115,164,196));
//		//te_desc.getPaint().setFakeBoldText(true);
//		linearLayoutGameDesc2.addView(te_point, params);
		
	}
	public ProgressBar getPb() {
		return pb;
	}
	public void setPb(ProgressBar pb) {
		this.pb = pb;
	}
	public ImageView getImg_volumvideo() {
		return img_volumvideo;
	}
	public LinearLayout getLinearLayout1() {
		return linearLayout1;
	}
	public void setLinearLayout1(LinearLayout linearLayout1) {
		this.linearLayout1 = linearLayout1;
	}
	public LinearLayout getLinearLayoutClose() {
		return linearLayoutClose;
	}
	public void setLinearLayoutClose(LinearLayout linearLayoutClose) {
		this.linearLayoutClose = linearLayoutClose;
	}
	public LinearLayout getLinearLayoutGameDesc() {
		return linearLayoutGameDesc;
	}
	
	public void setLinearLayoutGameDesc2(LinearLayout linearLayoutGameDesc2) {
		this.linearLayoutGameDesc2 = linearLayoutGameDesc2;
	}
	public LinearLayout getLinearLayoutGameDesc2() {
		return linearLayoutGameDesc2;
	}

	public void setLinearLayoutGameDesc(LinearLayout linearLayoutGameDesc) {
		this.linearLayoutGameDesc = linearLayoutGameDesc;
	}
	public TextView getTe_point() {
		return te_point;
	}
	public void setTe_point(TextView te_point) {
		this.te_point = te_point;
	}
	public TextView getTe_title() {
		return te_title;
	}
	public void setTe_title(TextView te_title) {
		this.te_title = te_title;
	}
	public TextView getTe_desc() {
		return te_desc;
	}
	public void setTe_desc(TextView te_desc) {
		this.te_desc = te_desc;
	}
	public ImageView getImg_icon() {
		return img_icon;
	}
	public void setImg_icon(ImageView img_icon) {
		this.img_icon = img_icon;
	}

}
