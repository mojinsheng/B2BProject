package view;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InregralView extends BaseLinearLayout{
	private RelativeLayout titleRelativeLayout;
	private LayoutParams params;
	private TextView te_back,te_appoffer,te_inregra;
	private TextView te_inregra_desc,te_current_inregra;
	private RelativeLayout.LayoutParams layoutParams;
	private LinearLayout linearLayout,linearLayout1,linearLayoutList;
	private ViewPager viewPager;
	private ListView listView;
	public static boolean isPortrait;
	public InregralView(Context context) {
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
			params = new LayoutParams(LayoutParams.FILL_PARENT, mHeight / 13);
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
		te_appoffer.setText(createString("textview_intergals"));
		layoutParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		titleRelativeLayout.addView(te_appoffer, layoutParams);
		
		
		
		//显示当前积分布局
		titleRelativeLayout=new RelativeLayout(context);
	
		titleRelativeLayout.setBackgroundColor(Color.WHITE);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,marginSize*4);
		//params.gravity=Gravity.CENTER;
		//linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		this.addView(titleRelativeLayout, params);
		
		linearLayout=new LinearLayout(context);
		//linearLayout.setBackgroundColor(Color.BLUE);
		if(isPortrait){
			layoutParams=new RelativeLayout.LayoutParams(((int)(mWidth*0.4)),LayoutParams.WRAP_CONTENT);
		}else{
			layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		}
		
		//params.gravity=Gravity.CENTER;
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		titleRelativeLayout.addView(linearLayout, layoutParams);
		
		
		te_inregra_desc = new TextView(context);
		te_inregra_desc.setTextColor(Color.WHITE);
		te_inregra_desc.setGravity(Gravity.CENTER);
		te_inregra_desc.setTextSize(18);
		te_inregra_desc.setTextColor(Color.BLACK);
		te_inregra_desc.setText(createString("textview_current_intergals"));
		layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		linearLayout.addView(te_inregra_desc, layoutParams);
		
		
		te_current_inregra = new TextView(context);
		te_current_inregra.setTextColor(Color.WHITE);
		te_current_inregra.setGravity(Gravity.CENTER);
		te_current_inregra.setTextSize(18);
		te_current_inregra.setTextColor(Color.rgb(65,187,237));
		layoutParams=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		linearLayout.addView(te_current_inregra, layoutParams);

		
		
		linearLayoutList=new LinearLayout(context);
		linearLayoutList.setBackgroundColor(Color.WHITE);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		//下载列表
		listView=new ListView(context);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		this.addView(listView,params);
	}

	public TextView getTe_back() {
		return te_back;
	}


	public TextView getTe_inregra() {
		return te_current_inregra;
	}


	public ListView getListView() {
		return listView;
	}

   
}
