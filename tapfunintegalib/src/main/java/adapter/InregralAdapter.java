package adapter;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.tapfuns.utils.tool.TapfunsScreenUtil;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

import bean.InregralBean;
import constant.Constant;
import mojin.from.com.tapfunintegalib.R;
import view.items.InregralItemsView;

public class InregralAdapter extends BaseAdapter {

	private List<InregralBean> list = new ArrayList<InregralBean>();
	private Context context;
	private LayoutInflater mInflater;
	protected TapfunsScreenUtil mScreen;
	protected boolean isPortrait;
	public InregralAdapter(List<InregralBean> _list, Context _context) {
		list = _list;
		context = _context;
		mInflater = LayoutInflater.from(context);
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.i("tapfuns", "WallAdapter appofferBeans size:" + list.size());
		ViewHolder holder = null;
		if (convertView == null) {

			holder = new ViewHolder();

			convertView =new InregralItemsView(context);
			holder.img = ((InregralItemsView) convertView).getImg_pro();
			holder.title = ((InregralItemsView) convertView).getTe_textView();
			holder.info = ((InregralItemsView) convertView).getTe_textViewDesc();
			holder.integral = ((InregralItemsView) convertView).getButton();
			holder.date = ((InregralItemsView) convertView).getTe_integral();
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		 LayoutParams linearParams = (LayoutParams)((InregralItemsView) convertView).getLinearLayout().getLayoutParams();
			mScreen = TapfunsScreenUtil.getInStance((Activity)context);
			isPortrait = mScreen.isPortrait((Activity)context);      
		 if(!isPortrait){
			 linearParams.height=((InregralItemsView)convertView).getHeigth()/7;
				//linearParams.height=((WallItemsView)convertView).getHeigth()/11;
		 }else{
				//linearParams.height=((WallItemsView)convertView).getHeigth()/7;
		 }
		// Uri url =Uri.parse(appofferBeans.get(position).getBanner_img());
		// holder.img.setImageURI(url);
		String name = list.get(position).getLogo();
		if (list.get(position).getLogo().equals("null")
				|| list.get(position).getLogo().equals("")
				|| list.get(position) == null) {
			if (list.get(position).getIntegral() > 0) {
				holder.img.setImageResource(R.drawable.integral);
			} else {
				holder.img.setImageResource(R.drawable.integraldecrease);
			}
		} else {
			ImageLoader.getInstance().displayImage(
					list.get(position).getLogo(), holder.img);
		}

		// holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
		holder.title.setText(list.get(position).getOffer_name());
		holder.info.setText(list.get(position).getDesc());
		if(list.get(position).getIntegral()<0){
			holder.integral.setText("-"+list.get(position).getIntegral() + "");
		}else{
			holder.integral.setText("+"+list.get(position).getIntegral() + "");
		}
		if(list.get(position).getConversion_time()!=0){
			
			holder.date.setText(Constant.getCurrentTime(list.get(position).getConversion_time()));
		}
		return convertView;
	}

	public final class ViewHolder {
		public ImageView img;
		public TextView title;
		public TextView info;
		public TextView date;
		public Button integral;
	}
}
