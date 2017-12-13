package mojin.from.com.tapfunsintegraldemo;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.dsg.deepseagameAdSDK.R;

import constant.Constant;
import entrance.TapfunsAdsEfunPlatform;
import utils.AppofferUtil;
import view.widow.TapfunsWindow;

public class Advertisementactivity extends Activity {
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advertisementactivity);
		/**
		 * 积分墙
		 */
		AppofferUtil.getIntsance().getList().clear();
		findViewById(R.id.btn_wall).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	         TapfunsAdsEfunPlatform.getInstance().tapfunsWallAd(Advertisementactivity.this);
			}
		});
		findViewById(R.id.btn_image).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Advertisementactivity.this,
//						TapfunsAdsInergral.class);
//				Bundle bundle=new Bundle();
//				bundle.putString("flags", Constant.IMAGEVIEW_WITH_INTEGRAL);
//				intent.putExtras(bundle);
//				startActivity(intent);
				 TapfunsAdsEfunPlatform.getInstance().tapfunsAlertAD(Advertisementactivity.this, Constant.IMAGEVIEW_WITH_INTEGRAL);
			}
		});
		findViewById(R.id.btn_image1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Advertisementactivity.this,
//						TapfunsAdsInergral.class);
//				Bundle bundle=new Bundle();
//				bundle.putString("flags", Constant.IMAGEVIEW_WITHOUT_INTEGRAL);
//				intent.putExtras(bundle);
//				startActivity(intent);
				 TapfunsAdsEfunPlatform.getInstance().tapfunsAlertAD(Advertisementactivity.this, Constant.IMAGEVIEW_WITHOUT_INTEGRAL);
			}
		});
		
		findViewById(R.id.btn_simple).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Advertisementactivity.this,
//						TapfunsAdsInergral.class);
//				Bundle bundle=new Bundle();
//				bundle.putString("flags", Constant.IMAGEVIEW_SIMPLEININSERT);
//				intent.putExtras(bundle);
//				startActivity(intent);
				 TapfunsAdsEfunPlatform.getInstance().tapfunsAlertAD(Advertisementactivity.this, Constant.IMAGEVIEW_SIMPLEININSERT);

			}
		});
		findViewById(R.id.btn_baner).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TapfunsWindow.getInstances().createView(Advertisementactivity.this);
//				Intent intent=new Intent(Advertisementactivity.this,TapfunsWindow.class);
//				startService(intent);
			}
		});
		findViewById(R.id.btn_video).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Advertisementactivity.this,
//						TapfunsVideoActivity.class);
//				startActivity(intent);
				 TapfunsAdsEfunPlatform.getInstance().tapfunsFullVideoAd(Advertisementactivity.this);
			}
		});
		findViewById(R.id.btn_smallvideo).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Advertisementactivity.this,
//						AlertVideoActivity.class);
//				startActivity(intent);
				 TapfunsAdsEfunPlatform.getInstance().tapfunsAlertVideoAd(Advertisementactivity.this);
			}
		});
		findViewById(R.id.btn_insert).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Advertisementactivity.this,
//						AdsInformationActivity.class);
//				startActivity(intent);
				 TapfunsAdsEfunPlatform.getInstance().tapfunsADInformation(Advertisementactivity.this);
			}
		});
		findViewById(R.id.addpoint).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Advertisementactivity.this,
//						AdsInformationActivity.class);
//				startActivity(intent);
				 TapfunsAdsEfunPlatform.getInstance().tapfunsAddPoint(Advertisementactivity.this, "12", "增加積分","1");
			}
		});
		findViewById(R.id.reducepoint).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = new Intent(Advertisementactivity.this,
//						AdsInformationActivity.class);
//				startActivity(intent);
				 TapfunsAdsEfunPlatform.getInstance().tapfunsReducePoint(Advertisementactivity.this, "20", "减少积分", "1");
			}
		});
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("tapfuns", "TapfunsWindow.getInstances().onDestroy();");
		TapfunsWindow.getInstances().onDestroy();
	}
  @Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	Log.i("tapfuns", "TapfunsWindow.getInstances().onResume(this);");
	TapfunsWindow.getInstances().onResume(this);
}
}
