package mojin.from.com.tapfunsintegraldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.dsg.deepseagameAdSDK.R;

import entrance.TapfunsAdsEfunPlatform;

public class LanguageActivtity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.languageactivtity);
		findViewById(R.id.btn_en).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TapfunsAdsEfunPlatform.getInstance().tapfunsSetLanguage("en_US");
				//Controls.getInstance().setLanguage("en_US");
				finish();
			}
		});
		findViewById(R.id.btn_ch).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TapfunsAdsEfunPlatform.getInstance().tapfunsSetLanguage("zh_CH");
				//Controls.getInstance().setLanguage("zh_CH");
				finish();
			}
		});
		findViewById(R.id.btn_chj).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TapfunsAdsEfunPlatform.getInstance().tapfunsSetLanguage("zh_HK");
				//Controls.getInstance().setLanguage("zh_HK");
				finish();
			}
		});
	}

}
