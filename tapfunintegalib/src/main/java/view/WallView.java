package view;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WallView extends BaseLinearLayout{
	private RelativeLayout titleRelativeLayout;
	private LayoutParams params;
	private TextView te_back,te_appoffer,te_inregra;
	private RelativeLayout.LayoutParams layoutParams;
	private LinearLayout linearLayout;
	private ViewPager viewPager;
	private ListView listView;
	public static boolean isPortrait;
	public WallView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public void init(Context context) {
		this.setOrientation(LinearLayout.VERTICAL);
		this.isPortrait=_isPortrait;
		// 积分墙标题
		titleRelativeLayout = new RelativeLayout(context);
		if(isPortrait){
			params = new LayoutParams(LayoutParams.FILL_PARENT, mHeight / 19);
		}else{
			params = new LayoutParams(LayoutParams.FILL_PARENT, mHeight / 12);
		}
		titleRelativeLayout.setBackgroundColor(Color.BLACK);
		this.addView(titleRelativeLayout, params);

		// 返回键
		te_back = new TextView(context);
		te_back.setTextColor(Color.WHITE);
		te_back.setGravity(Gravity.CENTER);
		te_back.setTextSize(18);
		te_back.setText(createString("textview_back"));
		layoutParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		titleRelativeLayout.addView(te_back, layoutParams);

		// 应用墙
		te_appoffer = new TextView(context);
		te_appoffer.setTextColor(Color.WHITE);
		te_appoffer.setGravity(Gravity.CENTER);
		te_appoffer.setTextSize(18);
		te_appoffer.setText(createString("textview_appoffer"));
		layoutParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		titleRelativeLayout.addView(te_appoffer, layoutParams);
		
		// 积分墙
		te_inregra = new TextView(context);
		te_inregra.setTextColor(Color.WHITE);
		te_inregra.setGravity(Gravity.CENTER);
		te_inregra.setTextSize(18);
		te_inregra.setText(createString("textview_intergal"));
		layoutParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		titleRelativeLayout.addView(te_inregra, layoutParams);
		
		
		//内容布局
		linearLayout=new LinearLayout(context);
		linearLayout.setBackgroundColor(Color.WHITE);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//		if(isPortrait){
//			
//		}else{
//			params=new LayoutParams(LayoutParams.MATCH_PARENT,mHeight/10);
//		}
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		this.addView(linearLayout, params);
		
		//定时展示图
		viewPager=new ViewPager(context);
	if(isPortrait){
			
		params=new LayoutParams(LayoutParams.MATCH_PARENT,mHeight/5);
		}else{
			params=new LayoutParams(LayoutParams.MATCH_PARENT,mHeight/4);
		}
		linearLayout.addView(viewPager,params);
		
		//下载列表
		listView=new ListView(context);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		linearLayout.addView(listView,params);
	}

	public TextView getTe_back() {
		return te_back;
	}


	public TextView getTe_inregra() {
		return te_inregra;
	}


	public ViewPager getViewPager() {
		return viewPager;
	}
	public ListView getListView() {
		return listView;
	}

   
}
