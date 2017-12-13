package activity;

import java.util.List;

import com.tapfuns.utils.task.RequestCallBack;
import com.tapfuns.utils.task.TapfunsCommandExecute;
import com.tapfuns.utils.tool.Utils;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import adapter.InregralAdapter;
import constant.Constant;
import utils.InregralUtil;
import view.InregralView;

public class Inregralwallactivity extends Activity {
	private TextView textView;
	private ListView listView;
	private TextView t_inregeal;
	private InregralView inregralView;
	private boolean isPortrait;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		inregralView=new InregralView(this);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(inregralView);
		textView = inregralView.getTe_back();
		listView = inregralView.getListView();
		t_inregeal = inregralView.getTe_inregra();
		listView.setDivider(new ColorDrawable(Color.GRAY));
		listView.setDividerHeight(1);
		listView.addHeaderView(new ViewStub(this));
		// http://www.qzjweb.com/api/integral/getuser?auth=987d8898d1adb1eebb6b5ce803a98c08
		// &time=2017-09-07%2012:35:24&appid=596c5ee8a3687
		String androidId = ""
				+ android.provider.Settings.Secure.getString(
						getContentResolver(),
						android.provider.Settings.Secure.ANDROID_ID);
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.inregralUrl);
		sb.append("auth="
				+ Utils.getMD5(Constant.tapfunsKeys + Constant.getCurrentTime()));
		sb.append("&time=" + Constant.getCurrentTime());
		sb.append("&appid=" + Constant.appid);

		sb.append("&clint_id=" + "123");
		TapfunsCommandExecute.getInstance().executeGet(this, sb.toString(),
				new RequestCallBack() {
					@Override
					public void getRequestResult(String command) {
						InregralUtil.getIntsance().StrToInregralParams(command);
						t_inregeal.setText("  "+InregralUtil.getIntsance().getList()
								.get(0).getTotal_integral());
						InregralAdapter adapter = new InregralAdapter(
								InregralUtil.getIntsance().getList(),
								Inregralwallactivity.this);
						listView.setAdapter(adapter);
					}

				});

		textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		InregralUtil.getIntsance().getList().clear();
	}

}
