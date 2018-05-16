package com.from.dididache.Adaper;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.from.dididache.Entity.MoneyDateilsBean;
import com.from.dididache.Entity.UserIfon;
import com.from.dididache.view.MoneyDateilsListView;
import com.from.dididache.view.UserInfoView;

import java.util.List;

/**
 * Created by USER on 2018/5/16.
 */

public class MoneyDateilsAdapter extends BaseAdapter {
    private List<MoneyDateilsBean> lists;
    private Context context;
    public MoneyDateilsAdapter(List<MoneyDateilsBean> _lists, Context _context){
        lists=_lists;
        context=_context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        MoneyDateilsBean moneyDateils=lists.get(i);
        final ViewHolder holder ;
        if (convertView == null) {

            holder = new ViewHolder();

            convertView =new MoneyDateilsListView(context);
            holder.t_data = ((MoneyDateilsListView) convertView).getTetxPayDate();
            holder.t_money=((MoneyDateilsListView)convertView).getTextPayMoney();
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        if(flag){
//            holder.r_receivablesRel.setVisibility(View.VISIBLE);
//        }

        holder.t_data.setText(moneyDateils.getDate());
        holder.t_money.setText("+"+moneyDateils.getMoney());

        return convertView;
    }
    public class ViewHolder {
        public TextView t_data;
        public TextView t_money;
    }
}
