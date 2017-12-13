package adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.tapfuns.utils.log.TapfunsLogUtil;
import com.tapfuns.utils.res.TapfunsResourceUtil;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import bean.AppofferBean;
import controls.Controls;
import view.items.AdsInformationView;

public class AdsInformationAdapter extends BaseAdapter{
	private List<AppofferBean> list;
	private Context context;
	private String language;
	
	public AdsInformationAdapter(List<AppofferBean> _list, Context _context) {
		list = _list;
		context = _context;
		//mInflater = LayoutInflater.from(context);Controls
		language= Controls.getInstance().getLanguage().toLowerCase();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView =new AdsInformationView(context);
			holder.img = ((AdsInformationView) convertView).getImageView();
			holder.title = ((AdsInformationView) convertView).getTextView();
			holder.title1= ((AdsInformationView) convertView).getTextView1();
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ImageLoader.getInstance().displayImage(
				list.get(position).getLogo(), holder.img);
		holder.title.setText(list.get(position).getAd_slogan());
		holder.title1.setText(createString("textview_ad"));
		holder.img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent=new Intent(context, TapfunsWebActivity.class);
//				Bundle bundle=new Bundle();
//				bundle.putString("gameurl", AppofferUtil.getIntsance().getList().get(0).getTracking_link());
//				intent.putExtras(bundle);
//				context.startActivity(intent);
				if (TextUtils.isEmpty(list.get(position).getPackageName())) {
					return;
				}

				Uri uri = Uri.parse("market://details?id="
						+ list.get(position).getPackageName());
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
		public TextView title1;
	}
	public String createString(String filename){
		if(!TextUtils.isEmpty(language)){
			filename = language+"_"+filename;
		return TapfunsResourceUtil.findStringByName(context, filename);
	}else{
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
