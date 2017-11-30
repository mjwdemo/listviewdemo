package com.jwma.listviewdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

import com.jwma.listviewdemo.adapter.ListViewAdapter;
import com.jwma.listviewdemo.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class BaLvActivity extends BaseActivity {

    private ListView baLv;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ba_lv);
        baLv = findViewById(R.id.ba_lv);
        adapter = new ListViewAdapter(this);
        baLv.setAdapter(adapter);
        baLv.setOnScrollListener(new MyListener());
    }

    @Override
    protected void onResume() {
        super.onResume();
        initDatas();
    }

    private void initDatas() {
        List<UserInfo> userInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserInfo user = new UserInfo();
            if (i % 2 == 0) {
                user.setPic(R.drawable.ic_launcher_background);
            } else {
                user.setPic(R.drawable.ic_launcher_foreground);
            }
            user.setUsername("我是" + i + "号");
            user.setDesc("此人是第" + i + "个渣渣");
            userInfos.add(user);
        }
        adapter.addDatas(userInfos);
    }

    private class MyListener implements AbsListView.OnScrollListener {

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            Log.i("onScroll", "scrollState==" + scrollState);
            Log.i("onScroll","lase=="+view.getLastVisiblePosition());
            switch (scrollState){
                case SCROLL_STATE_IDLE:
                    if(view.getLastVisiblePosition()==view.getCount()-1){
                        addDatas();
                    }else if(view.getFirstVisiblePosition()==0){
                        refreshDatas();
                    }
                    break;
                case SCROLL_STATE_TOUCH_SCROLL:

                    break;
                case SCROLL_STATE_FLING:

                    break;


            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//            Log.i("onScroll", firstVisibleItem + ";" + visibleItemCount + ";" + totalItemCount);
        }
    }

    private void addDatas() {
        List<UserInfo> userInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserInfo user = new UserInfo();
            if (i % 2 == 0) {
                user.setPic(R.drawable.ic_launcher_background);
            } else {
                user.setPic(R.drawable.ic_launcher_foreground);
            }
            user.setUsername("add我是" + i + "号");
            user.setDesc("add此人是第" + i + "个渣渣");
            userInfos.add(user);
        }
        adapter.addDatas(userInfos);
    }

    private void refreshDatas() {
        List<UserInfo> userInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserInfo user = new UserInfo();
            if (i % 2 == 0) {
                user.setPic(R.drawable.ic_launcher_background);
            } else {
                user.setPic(R.drawable.ic_launcher_foreground);
            }
            user.setUsername("refresh我是" + i + "号");
            user.setDesc("refresh此人是第" + i + "个渣渣");
            userInfos.add(user);
        }
        adapter.clearDatas();
        adapter.addDatas(userInfos);
    }
}
