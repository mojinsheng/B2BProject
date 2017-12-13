package mojin.from.com.tapfunsintegraldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dsg.deepseagameAdSDK.R;
import com.tapfuns.utils.log.TapfunsLogUtil;

import entrance.TapfunsAdsEfunPlatform;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TapfunsLogUtil.enableDebug(true);
        TapfunsLogUtil.enableInfo(true);
        TapfunsAdsEfunPlatform.getInstance().tapfunsSetLanguage("zh_CH");
        TapfunsAdsEfunPlatform.getInstance().tapfunsAdsInit(this,
                "5a1644a7d59f1", "5b14804d8cc14cd52b340a77575fd80a");
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this,
                        LanguageActivtity.class);

                startActivity(intent);
                //TapfunsWindow.getInstances().createView(MainActivity.this);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this,
                        Advertisementactivity.class);
                //String language=Controls.getInstance().getLanguage();
                startActivity(intent);
            }
        });


    }
}
