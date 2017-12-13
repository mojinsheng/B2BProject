package view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VideoDownGameView extends BaseLinearLayout{
	private LinearLayout linearLayoutIcon,linearLayoutDesc,linearLayoutDesc1,linearLayoutDesc2;
	private RelativeLayout layout,layoutTitle,layoutBottom,layoutBottom1;
	private RelativeLayout.LayoutParams layoutParams;
	private LayoutParams params;
	private ImageView img_layout,img_close,img_reboot,img_icon;
	public static boolean isPortrait;
	public ImageView getImg_layout() {
		return img_layout;
	}
	private TextView te_titile,te_title1;
	private Button btn_down;

	public VideoDownGameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	@SuppressLint("NewApi") 
	public void init(Context context){
		this.isPortrait=_isPortrait;
		if(isPortrait){
			this.setOrientation(LinearLayout.VERTICAL);
			layout=new RelativeLayout(context);
			params=new LayoutParams(LayoutParams.MATCH_PARENT,(int)(mWidth*0.65));
			//layout.setBackgroundColor(Color.BLUE);
			this.addView(layout, params);
			img_layout=new ImageView(context);
			img_layout.setScaleType(ScaleType.FIT_XY);
			params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			layout.addView(img_layout, params);
			
			layoutTitle=new RelativeLayout(context);
			layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(marginSize*1.5));
			layoutTitle.setBackgroundColor(Color.TRANSPARENT);
			layoutParams.setMargins(marginSize, marginSize/2, marginSize, marginSize/2);
			layout.addView(layoutTitle, layoutParams);
			
			img_close=new ImageView(context);
			img_close.setBackgroundResource(createDrawable("deleteendingvideo"));
			
			layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*1.5),LayoutParams.MATCH_PARENT);
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			layoutTitle.addView(img_close,layoutParams);
			
			
			img_reboot=new ImageView(context);
			img_reboot.setBackgroundResource(createDrawable("replayvideo"));
			
			layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*1.5),LayoutParams.MATCH_PARENT);
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			layoutTitle.addView(img_reboot,layoutParams);
			
			
			linearLayoutIcon=new LinearLayout(context);
			params=new LayoutParams(LayoutParams.MATCH_PARENT, mHeight/6);
			linearLayoutIcon.setGravity(Gravity.CENTER);
			this.addView(linearLayoutIcon, params);
			
			
			img_icon=new ImageView(context);
			img_icon.setScaleType(ScaleType.FIT_XY);
			params=new LayoutParams(mHeight/7,LayoutParams.MATCH_PARENT);
			params.topMargin=marginSize/2;
			linearLayoutIcon.addView(img_icon, params);
			
			linearLayoutDesc=new LinearLayout(context);
			linearLayoutDesc.setOrientation(LinearLayout.VERTICAL);
			params=new LayoutParams((int)(mWidth*0.7), LayoutParams.MATCH_PARENT);
			params.topMargin=marginSize;
			params.gravity=Gravity.CENTER;
			this.addView(linearLayoutDesc, params);
			
			te_titile=new TextView(context);
			params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			te_titile.setEllipsize(TruncateAt.END);
			te_titile.setGravity(Gravity.CENTER);
			te_titile.setSingleLine(true);
			te_titile.setTextColor(Color.WHITE);
			te_titile.setText("wodsadsadsadsadsadsadsadsadsds");
			te_titile.setTextSize(30);
			linearLayoutDesc.addView(te_titile,params);
			
			te_title1=new TextView(context);
			params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			params.topMargin=marginSize/2;
			te_title1.setEllipsize(TruncateAt.END);
			te_title1.setGravity(Gravity.CENTER);
			te_title1.setSingleLine(true);
			te_title1.setTextColor(Color.rgb(162,161,166));
			te_title1.setText("wodsadsa");
			te_title1.setTextSize(20);
			linearLayoutDesc.addView(te_title1,params);
			
			btn_down=new Button(context);
			
			params=new LayoutParams((int)(mWidth*0.35), LayoutParams.WRAP_CONTENT);
			params.topMargin=marginSize;
			params.gravity=Gravity.CENTER;
			btn_down.setAllCaps(false);
			btn_down.setBackgroundColor(Color.rgb(255,69,70));
			btn_down.setText(createString("button_download"));
			btn_down.setTextSize(20);
			linearLayoutDesc.addView(btn_down,params);
		}else{
			layout=new RelativeLayout(context);
			params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			//layout.setBackgroundColor(Color.BLUE);
			this.addView(layout, params);
			img_layout=new ImageView(context);
			img_layout.setScaleType(ScaleType.FIT_XY);
			params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			layout.addView(img_layout, params);
			
			layoutTitle=new RelativeLayout(context);
			layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(marginSize*2));
			layoutTitle.setBackgroundColor(Color.TRANSPARENT);
			layoutParams.setMargins(marginSize, marginSize/2, marginSize, marginSize/2);
			layout.addView(layoutTitle, layoutParams);
			
			img_close=new ImageView(context);
			img_close.setBackgroundResource(createDrawable("deleteendingvideo"));
			
			layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*2),LayoutParams.MATCH_PARENT);
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			layoutTitle.addView(img_close,layoutParams);
			
			
			img_reboot=new ImageView(context);
			img_reboot.setBackgroundResource(createDrawable("replayvideo"));
			
			layoutParams=new RelativeLayout.LayoutParams((int)(marginSize*2),LayoutParams.MATCH_PARENT);
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			layoutTitle.addView(img_reboot,layoutParams);
			
			//显示的内容
			layoutBottom=new RelativeLayout(context);
			layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,mHeight/4);
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			layout.addView(layoutBottom, layoutParams);
			
			
	
			
			layoutBottom1=new RelativeLayout(context);
			layoutBottom1.setBackgroundColor(Color.rgb(188,186,188));
			layoutBottom1.getBackground().setAlpha(100);
			//linearLayoutDesc.setOrientation(LinearLayout.HORIZONTAL);
			layoutParams=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			layoutParams.topMargin=marginSize;
			layoutBottom.addView(layoutBottom1, layoutParams);
			
			linearLayoutDesc1=new LinearLayout(context);
			linearLayoutDesc1.setOrientation(LinearLayout.HORIZONTAL);
			layoutParams=new RelativeLayout.LayoutParams((int)(mWidth*0.85),LayoutParams.MATCH_PARENT);
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			layoutBottom1.addView(linearLayoutDesc1, layoutParams);
			
			
			linearLayoutDesc2=new LinearLayout(context);
			linearLayoutDesc2.setOrientation(LinearLayout.VERTICAL);
			layoutParams=new RelativeLayout.LayoutParams((int)(mWidth*0.5),LayoutParams.MATCH_PARENT);
		
			linearLayoutDesc1.addView(linearLayoutDesc2, layoutParams);
			
			
			te_titile=new TextView(context);
			params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			te_titile.setEllipsize(TruncateAt.END);
			te_titile.setGravity(Gravity.CENTER);
			te_titile.setSingleLine(true);
			te_titile.setTextColor(Color.WHITE);
			te_titile.setText("wodsadsadsadsadsadsadsadsadsds");
			te_titile.setTextSize(20);
			linearLayoutDesc2.addView(te_titile,params);
			
			te_title1=new TextView(context);
			params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			params.topMargin=marginSize/2;
			te_title1.setEllipsize(TruncateAt.END);
			te_title1.setGravity(Gravity.CENTER);
			te_title1.setSingleLine(true);
			te_title1.setTextColor(Color.rgb(162,161,166));
			te_title1.setText("wodsadsa");
			te_title1.setTextSize(15);
			linearLayoutDesc2.addView(te_title1,params);
			
			btn_down=new Button(context);
			
			params=new LayoutParams((int)(mWidth*0.28), LayoutParams.WRAP_CONTENT);
			//params.topMargin=marginSize/2;
			params.gravity=Gravity.CENTER;
			params.leftMargin=marginSize;
			btn_down.setAllCaps(false);
			btn_down.setBackgroundColor(Color.rgb(255,69,70));
			btn_down.setText(createString("button_download"));
			btn_down.setTextSize(20);
			linearLayoutDesc1.addView(btn_down,params);
			
			img_icon=new ImageView(context);
			img_icon.setAdjustViewBounds(true);
			img_icon.setScaleType(ScaleType.FIT_XY);
			layoutParams=new RelativeLayout.LayoutParams(mHeight/5,LayoutParams.MATCH_PARENT);
			layoutParams.setMargins((int)(marginSize*1.5), 0, 0, (int)(marginSize*1.5));
			layoutBottom.addView(img_icon, layoutParams);
		}

	}
	public RelativeLayout getLayout() {
		return layout;
	}
	public TextView getTe_titile() {
		return te_titile;
	}
	public void setTe_titile(TextView te_titile) {
		this.te_titile = te_titile;
	}
	public TextView getTe_title1() {
		return te_title1;
	}
	public void setTe_title1(TextView te_title1) {
		this.te_title1 = te_title1;
	}
	public ImageView getImg_close() {
		return img_close;
	}
	public void setImg_close(ImageView img_close) {
		this.img_close = img_close;
	}
	public ImageView getImg_reboot() {
		return img_reboot;
	}
	public void setImg_reboot(ImageView img_reboot) {
		this.img_reboot = img_reboot;
	}
	public ImageView getImg_icon() {
		return img_icon;
	}
	public void setImg_icon(ImageView img_icon) {
		this.img_icon = img_icon;
	}
	public Button getBtn_down() {
		return btn_down;
	}
	public void setBtn_down(Button btn_down) {
		this.btn_down = btn_down;
	}
}
