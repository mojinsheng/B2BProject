package view.widow;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;


import view.BaseRelativeLayout;

public class TapfunsWindowView extends BaseRelativeLayout {
	private ImageView imageView;
	private LinearLayout linearLayout, linearLayout2, linearLayout3,
			linearLayout4;
	private TextView te_title, te_title1;
	private LayoutParams params;
	private LinearLayout.LayoutParams layoutParams2;
	private RelativeLayout.LayoutParams layoutParams;
	private RelativeLayout layout;
	private ImageView img_close;
	private Button btn_down;

	public TapfunsWindowView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public void init(Context context) {
		this.setBackgroundColor(Color.TRANSPARENT);
		layout = new RelativeLayout(context);
		// layout.setBackgroundColor(Color.RED);

		if (isPortrait) {
			layoutParams = new RelativeLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, mHeight / 8);
		} else {
			layoutParams = new RelativeLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, mHeight / 5);
		}
	

		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		this.addView(layout, layoutParams);

		linearLayout = new LinearLayout(context);
		linearLayout.setBackgroundColor(Color.rgb(40, 40, 40));
		if (isPortrait) {
			params = new LayoutParams(LayoutParams.MATCH_PARENT, mHeight / 8);
		} else {
			params = new LayoutParams(
					LayoutParams.MATCH_PARENT, mHeight /5);
		}
		if(isPortrait){
			params.topMargin = marginSize / 2;
		}else{
			params.topMargin = (int)(marginSize*0.8);
		}
		layout.addView(linearLayout, params);

		linearLayout2 = new LinearLayout(context);
		linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
		;
		layoutParams = new RelativeLayout.LayoutParams((int) (mWidth * 0.75),
				LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		if(isPortrait){
			layoutParams.topMargin = marginSize / 2;
		}else{
			layoutParams.topMargin = (int)(marginSize*0.8);
		}
		//layoutParams.topMargin = marginSize / 2;
		layout.addView(linearLayout2, layoutParams);

		// 标题
		linearLayout3 = new LinearLayout(context);
		linearLayout3.setOrientation(LinearLayout.VERTICAL);
		;
		params = new LayoutParams((int) (mWidth * 0.55),
				LayoutParams.MATCH_PARENT);
		// linearLayout3.setBackgroundColor(Color.RED);
		linearLayout2.addView(linearLayout3, params);

		te_title = new TextView(context);
		// te_title.setGravity(Gravity.CENTER);
		te_title.getPaint().setFakeBoldText(true);
		te_title.setEllipsize(TruncateAt.END);
		// te_textViewDesc.setGravity(Gravity.CENTER);
		te_title.setSingleLine(true);
		te_title.setTextSize(18);
		te_title.setText("woshifsfdsfds");
		layoutParams2 = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
		linearLayout3.addView(te_title, layoutParams2);

		te_title1 = new TextView(context);
		te_title1.setEllipsize(TruncateAt.END);
		// te_textViewDesc.setGravity(Gravity.CENTER);
		te_title1.setSingleLine(true);
		// te_title1.setGravity(Gravity.CENTER);
		// te_title1.getPaint().setFakeBoldText(true);
		te_title1.setTextSize(15);
		te_title1.setText("woshifsfdsfds");
		layoutParams2 = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
		linearLayout3.addView(te_title1, layoutParams2);

		linearLayout4 = new LinearLayout(context);
		linearLayout4.setOrientation(LinearLayout.VERTICAL);
		;
		layoutParams2 = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		// linearLayout3.setBackgroundColor(Color.RED);
		linearLayout2.addView(linearLayout4, layoutParams2);

		// 关闭按钮
		img_close = new ImageView(context);
		img_close.setBackgroundResource(createDrawable("deletebtnalert"));
		if(isPortrait){
			layoutParams2 = new LinearLayout.LayoutParams((int) (marginSize * 0.8),
					marginSize * 2, 1);
			layoutParams2.topMargin = marginSize / 2;
		}else{
			layoutParams2 = new LinearLayout.LayoutParams((int) (marginSize*1.8),
					marginSize * 3, 1);
		}
		layoutParams2.gravity = Gravity.RIGHT;
		layoutParams2.rightMargin = marginSize / 2;
		
		linearLayout4.addView(img_close, layoutParams2);

		btn_down = new Button(context);
		layoutParams2 = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
		layoutParams2.setMargins(marginSize / 3, marginSize / 3,
				marginSize / 3, marginSize / 3);
		btn_down.setBackgroundResource(createDrawable("btn_shape"));
		if(isPortrait){
			btn_down.setTextSize(10);
		}else{
			btn_down.setTextSize(12);
		}
		btn_down.setTextColor(Color.WHITE);
		btn_down.setPadding(0, 0, 0, 0);
		btn_down.setGravity(Gravity.CENTER);
		btn_down.setText(createString("button_download"));
		linearLayout4.addView(btn_down, layoutParams2);

		imageView = new ImageView(context);
	//imageView.setBackgroundColor(Color.BLUE);
		imageView.setScaleType(ScaleType.FIT_XY);
		imageView.setPadding(0, 0, 0, 0);
		if(isPortrait){
			params = new LayoutParams(mHeight /10, LayoutParams.MATCH_PARENT);
		}else{
			params = new LayoutParams(mHeight / 6, LayoutParams.MATCH_PARENT);
		}
		params.setMargins(marginSize , 0, 0, marginSize );
		layout.addView(imageView, params);
	}

	public LinearLayout getLinearLayout3() {
		return linearLayout3;
	}

	public void setLinearLayout3(LinearLayout linearLayout3) {
		this.linearLayout3 = linearLayout3;
	}

	public ImageView getImg_close() {
		return img_close;
	}

	public void setImg_close(ImageView img_close) {
		this.img_close = img_close;
	}

	public Button getBtn_down() {
		return btn_down;
	}

	public void setBtn_down(Button btn_down) {
		this.btn_down = btn_down;
	}

	public TextView getTe_title() {
		return te_title;
	}

	public void setTe_title(TextView te_title) {
		this.te_title = te_title;
	}

	public TextView getTe_title1() {
		return te_title1;
	}

	public void setTe_title1(TextView te_title1) {
		this.te_title1 = te_title1;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

}
