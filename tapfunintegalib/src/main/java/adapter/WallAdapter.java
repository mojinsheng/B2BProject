package adapter;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.tapfuns.utils.log.TapfunsLogUtil;
import com.tapfuns.utils.res.TapfunsResourceUtil;
import com.tapfuns.utils.tool.TapfunsScreenUtil;

import bean.AppofferBean;
import controls.Controls;
import view.items.WallItemsView;

public class WallAdapter extends BaseAdapter {
	private List<AppofferBean> appofferBeans;
	private Context context;
	protected TapfunsScreenUtil mScreen;
	protected boolean isPortrait;
	private String language;

	public WallAdapter(List<AppofferBean> _appofferBeans, Context _context) {
		appofferBeans = _appofferBeans;
		context = _context;
		language = Controls.getInstance().getLanguage().toLowerCase();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return appofferBeans.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return appofferBeans.size();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.i("tapfuns",
				"WallAdapter appofferBeans size:" + appofferBeans.size());
		ViewHolder holder = null;
		if (convertView == null) {

			holder = new ViewHolder();

			convertView = (WallItemsView) new WallItemsView(context);
			holder.img = ((WallItemsView) convertView).getImg_pro();
			holder.title = ((WallItemsView) convertView).getTe_textView();
			holder.info = ((WallItemsView) convertView).getTe_textViewDesc();
			holder.integral = ((WallItemsView) convertView).getTe_integral();
			holder.viewBtn = ((WallItemsView) convertView).getButton();
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		LayoutParams linearParams = (LayoutParams) ((WallItemsView) convertView)
				.getLinearLayout().getLayoutParams();
		mScreen = TapfunsScreenUtil.getInStance((Activity) context);
		isPortrait = mScreen.isPortrait((Activity) context);
		if (isPortrait) {
			linearParams.height = ((WallItemsView) convertView).getHeigth() / 11;
		} else {
			linearParams.height = ((WallItemsView) convertView).getHeigth() / 7;
		}

		ImageLoader.getInstance().displayImage(
				appofferBeans.get(position).getBanner_img(), holder.img);
		holder.title.setText(appofferBeans.get(position).getAd_slogan());
		holder.info.setText(appofferBeans.get(position).getAd_desc());
		holder.integral.setText("+" + appofferBeans.get(position).getIntegral()
				+ createString("textview_point"));
		holder.viewBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Intent intent=new Intent(context, TapfunsWebActivity.class);
				// Bundle bundle=new Bundle();
				// bundle.putString("gameurl",
				// appofferBeans.get(position).getTracking_link());
				// intent.putExtras(bundle);
				// context.startActivity(intent);
				if (TextUtils.isEmpty(appofferBeans.get(position)
						.getPackageName())) {
					return;
				}

				Uri uri = Uri.parse("market://details?id="
						+ appofferBeans.get(position).getPackageName());
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				if (isPkgInstalled(context, "com.android.vending")) {
					intent.setPackage("com.android.vending");
				}else{
					return;
				}
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);

			}
		});
		return convertView;
	}

	public final class ViewHolder {
		public ImageView img;
		public TextView title;
		public TextView info;
		public TextView integral;
		public Button viewBtn;
	}

	public String createString(String filename) {
		if (!TextUtils.isEmpty(language)) {
			filename = language + "_" + filename;
			return TapfunsResourceUtil.findStringByName(context, filename);
		} else {
			TapfunsLogUtil.logE("請先設置语言");
			return "";
		}
	}
	public boolean isPkgInstalled(Context context, String packageName) {
		if ((packageName == null) || ("".equals(packageName)))
			return false;
		ApplicationInfo info = null;
		try {
			info = context.getPackageManager().getApplicationInfo(packageName,
					0);
			return (info != null);
		} catch (PackageManager.NameNotFoundException e) {
		}
		return false;
	}
}
