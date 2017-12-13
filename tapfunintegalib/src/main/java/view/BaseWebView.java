package view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BaseWebView extends BaseLinearLayout{
	
	private TextView te_back;
	private LayoutParams params; 
	private WebView webView;

	public BaseWebView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	
	public TextView getTe_back() {
		return te_back;
	}

	public void setTe_back(TextView te_back) {
		this.te_back = te_back;
	}

	public WebView getWebView() {
		return webView;
	}

	public void setWebView(WebView webView) {
		this.webView = webView;
	}

	public void init(Context context){
		this.setOrientation(LinearLayout.VERTICAL);
		this.setBackgroundColor(Color.BLACK);
		te_back=new TextView(context);
		te_back.setText(createString("textview_back"));
		te_back.getPaint().setFakeBoldText(true);
		te_back.setGravity(Gravity.CENTER);
		te_back.setTextSize(18);
		te_back.setTextColor(Color.WHITE);
		if(_isPortrait){
			params=new LayoutParams(LayoutParams.WRAP_CONTENT,marginSize*2);
		}else{
			params=new LayoutParams(LayoutParams.WRAP_CONTENT,marginSize*3);
		}
		this.addView(te_back, params);
		
		
		webView=new WebView(context);
		params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		this.addView(webView, params);
	}

}
