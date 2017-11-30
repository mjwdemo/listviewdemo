package com.jwma.listviewdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jwma.listviewdemo.R;
import com.jwma.listviewdemo.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJW on 2017/11/28.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context c;
    private List<UserInfo> userInfos = new ArrayList<>();

    public ListViewAdapter(Context c) {
        this.c = c;
    }


    @Override
    public int getCount() {
        return userInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return userInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(c, R.layout.ba_lv_item, null);
            holder.iv = convertView.findViewById(R.id.ba_lv_item_iv);
            holder.usernameTv = convertView.findViewById(R.id.ba_lv_item_username_tv);
            holder.descTv = convertView.findViewById(R.id.ba_lv_item_desc_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        UserInfo user = userInfos.get(position);
        holder.iv.setBackgroundResource(user.getPic());
        holder.usernameTv.setText(user.getUsername());
        holder.descTv.setText(user.getDesc());
        return convertView;
    }

    public void addDatas(List<UserInfo> users) {
        if (users.size() > 0) {
            userInfos.addAll(users);
            notifyDataSetChanged();
        }
    }

    public void clearDatas(){
        userInfos.clear();
        notifyDataSetChanged();
    }

    /**
     * 1、ViewHolder只是一个静态类，可以看做一个临时存储器；
     * 2、它的作用就在于减少不必要的调用findViewById；
     */
    private static class ViewHolder {
        ImageView iv;
        TextView usernameTv;
        TextView descTv;
    }
}
