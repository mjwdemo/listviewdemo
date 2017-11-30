package com.jwma.listviewdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jwma.listviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJW on 2017/11/30.
 */
public class MultLvAdapter extends BaseAdapter {

    private Context c;
    private List<String> list = new ArrayList<>();

    public MultLvAdapter(Context c) {
        this.c = c;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if (convertView == null) {
            switch (type) {
                case 0:
                    holder1 = new ViewHolder1();
                    convertView = View.inflate(c, R.layout.mult_lv_item_left, null);
                    holder1.iv = convertView.findViewById(R.id.mult_lv_item_iv);
                    holder1.but = convertView.findViewById(R.id.mult_lv_item_but);
                    holder1.tv = convertView.findViewById(R.id.mult_lv_item_tv);
                    convertView.setTag(R.layout.mult_lv_item_left, holder1);
                    break;
                case 1:
                    holder2 = new ViewHolder2();
                    convertView = View.inflate(c, R.layout.mult_lv_item_right, null);
                    holder2.iv = convertView.findViewById(R.id.mult_lv_item_iv);
                    holder2.tv = convertView.findViewById(R.id.mult_lv_item_tv);
                    convertView.setTag(R.layout.mult_lv_item_right, holder2);
                    break;
                default:
                    holder1 = new ViewHolder1();
                    convertView = View.inflate(c, R.layout.mult_lv_item_left, null);
                    holder1.iv = convertView.findViewById(R.id.mult_lv_item_iv);
                    holder1.but = convertView.findViewById(R.id.mult_lv_item_but);
                    holder1.tv = convertView.findViewById(R.id.mult_lv_item_tv);
                    convertView.setTag(R.layout.mult_lv_item_left, holder1);
                    break;
            }
        }

        switch (type) {
            case 0:
                holder1 = (ViewHolder1) convertView.getTag(R.layout.mult_lv_item_left);
                holder1.tv.setText(list.get(position));
                holder1.but.setText(list.get(position));
                break;

            case 1:
                holder2 = (ViewHolder2) convertView.getTag(R.layout.mult_lv_item_right);
                holder2.tv.setText(list.get(position));
                break;
            default:
                holder1 = (ViewHolder1) convertView.getTag(R.layout.mult_lv_item_left);
                holder1.tv.setText(list.get(position));
                holder1.but.setText(list.get(position));
                break;
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public void addDatas(List<String> list) {
        if (list.size() > 0) {
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    private static class ViewHolder1 {
        ImageView iv;
        Button but;
        TextView tv;
    }

    private static class ViewHolder2 {
        ImageView iv;
        TextView tv;
    }
}
