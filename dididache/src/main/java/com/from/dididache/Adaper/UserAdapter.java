package com.from.dididache.Adaper;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.from.dididache.Entity.UserIfon;
import com.from.dididache.view.UserInfoView;

import java.util.List;

/**
 * Created by USER on 2018/4/3.
 */

public class UserAdapter extends BaseAdapter {
    private List<UserIfon> userIfons;
    private Context context;
    private boolean flag;
   public  int selectIndex;
    @Override
    public int getCount() {
        return userIfons.size();
    }
    public UserAdapter(List<UserIfon> _userIfons, Context _context,boolean _flag){
        userIfons=_userIfons;
        context=_context;
        flag=_flag;
    }

    @Override
    public Object getItem(int i) {
        return userIfons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        UserIfon userIfon=userIfons.get(i);
       final ViewHolder holder ;
        if (convertView == null) {

            holder = new ViewHolder();

            convertView =new UserInfoView(context);
            holder.t_userName = ((UserInfoView) convertView).gettextViewUserDesc();
            holder.t_time=((UserInfoView)convertView).gettextViewTime();
            holder.t_start=((UserInfoView)convertView).gettextViewCurrent();
            holder.t_end=((UserInfoView)convertView).gettextViewEnd();
            holder.r_receivablesRel=((UserInfoView)convertView).getReceivablesRela();
            holder.t_money=((UserInfoView)convertView).gettextViewMoney();
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if(flag){
            holder.r_receivablesRel.setVisibility(View.VISIBLE);
        }

        holder.t_userName.setText(userIfon.getUername());
        holder.t_time.setText(userIfon.getToDayDate());
        holder.t_start.setText(userIfon.getStartPosition());
        holder.t_end.setText(userIfon.getEndPostition());
        holder.t_money.setText(userIfon.getMoney());
//        holder.mContainerLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                holder.mContainerLayout.setBackgroundColor(Color.GRAY);
//            }
//        });
        if( selectIndex == (i+1) ){
            convertView.setBackgroundColor(Color.parseColor("#82eae8"));
        }else{
            convertView.setBackgroundColor(Color.alpha(0));
        }
        return convertView;
    }
    public class ViewHolder {
        public TextView t_userName;
        public TextView t_time;
        public TextView t_start;
        public TextView t_end;
        public TextView t_money;
        public RelativeLayout  r_receivablesRel;
                ;
    }
}
