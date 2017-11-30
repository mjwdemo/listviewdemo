package com.jwma.listviewdemo;

import android.os.Bundle;
import android.widget.ListView;

import com.jwma.listviewdemo.adapter.MultLvAdapter;

import java.util.ArrayList;
import java.util.List;

public class MultLvActivity extends BaseActivity {

    private ListView multLv;
    private MultLvAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult_lv);
        multLv = findViewById(R.id.mult_lv);
        adapter = new MultLvAdapter(this);
        multLv.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        initDatas();
    }

    private void initDatas() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                list.add("男" + i + "号");
            } else {
                list.add("女" + i + "号");
            }
        }
        adapter.addDatas(list);
    }
}
