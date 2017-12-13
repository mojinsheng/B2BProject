package view;

import com.tapfuns.utils.res.TapfunsResourceUtil;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import android.widget.LinearLayout.LayoutParams;

public class AdsVideoView extends BaseLinearLayout{
	private LayoutParams params;
	private RelativeLayout.LayoutParams layoutParams;
	private RelativeLayout layout,layoutTitle,layoutTitlerilght;
	private LinearLayout linearLayout,linearLayout2;
	private VideoView videoView;
	private ProgressBar pb; 
	public ProgressBar getPb() {
		return pb;
	}

	public void setPb(ProgressBar pb) {
		this.pb = pb;
	}

	public VideoView getVideoView() {
		return videoView;
	}

	public void setVideoView(VideoView videoView) {
		this.videoView = videoView;
	}

	public ImageView getIma_close() {
		return ima_close;
	}

	public void setIma_close(ImageView ima_close) {
		this.ima_close = ima_close;
	}

	public ImageView getImg_download() {
		return img_download;
	}

	public void setImg_download(ImageView img_download) {
		this.img_download = img_download;
	}

	public ImageView getImg_voice() {
		return img_voice;
	}

	public void setImg_voice(ImageView img_voice) {
		this.img_voice = img_voice;
	}

	public ImageView getImg_enlarge() {
		return img_enlarge;
	}

	public void setImg_enlarge(ImageView img_enlarge) {
		this.img_enlarge = img_enlarge;
	}

	private ImageView ima_close,img_download,img_voice,img_enlarge;
	
	public AdsVideoView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	
	public void init(Context context){
		
		layout=new RelativeLayout(context);
		layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		this.addView(layout, layoutParams);
		
		videoView=new VideoView(context);
		//videoView.setBackgroundColor(Color.RED);
		layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		layout.addView(videoView,layoutParams);
		
		
		 pb = new ProgressBar(context, null, android.R.attr.progressBarStyleLarge);
		//pb.setBackgroundResource(TapfunsResourceUtil.findDrawableIdByName(context, "progressbg"));
		Drawable drawable=context.getResources().getDrawable(TapfunsResourceUtil.findDrawableIdByName(context, "progressbg"));
		pb.setIndeterminateDrawable(drawable);;//relativeLayout=new RelativeLayout(context);
		//indeterminateDrawable
		//relativeLayout.setBackgroundResource(TapfunsResourceUtil.findDrawableIdByName(context, "movie_loading"));
		layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		layout.addView(pb, layoutParams);
		
		
		
		
		
		
		
		layoutTitle=new RelativeLayout(context);
		layoutTitle.setBackgroundColor(Color.TRANSPARENT);
		//layoutParams.setOrientation(LinearLayout.HORIZONTAL);
		layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, marginSize*2);
		
		layout.addView(layoutTitle,layoutParams);
		
		ima_close=new ImageView(context);
		layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*1.5), LayoutParams.MATCH_PARENT);
		ima_close.setBackgroundResource(createDrawable("deletevideobtn"));
		layoutParams.topMargin=marginSize/2;
		layoutParams.leftMargin=marginSize/2;
		layoutTitle.addView(ima_close, layoutParams);
		
		
		layoutTitlerilght=new RelativeLayout(context);
		layoutParams=new RelativeLayout.LayoutParams((int)(mWidth*0.4), LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		layoutParams.topMargin=marginSize/3;
		layoutParams.rightMargin=marginSize/2;
		layoutTitle.addView(layoutTitlerilght, layoutParams);
		
		
		img_download=new ImageView(context);
		img_download.setBackgroundResource(createDrawable("cachevide"));
		layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*1.5), LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		layoutTitlerilght.addView(img_download, layoutParams);
		
		
		img_voice=new ImageView(context);
		img_voice.setBackgroundResource(createDrawable("volumclosevideo"));
		layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*1.5), LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		layoutTitlerilght.addView(img_voice, layoutParams);
		
		img_enlarge=new ImageView(context);
		img_enlarge.setBackgroundResource(createDrawable("fullscreenvideo"));
		layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*1.5), LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		layoutTitlerilght.addView(img_enlarge, layoutParams);
	}
}
