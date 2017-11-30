package com.jwma.listviewdemo;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SaLvActivity extends BaseActivity {

    private ListView saLv;
    private List<HashMap<String, Object>> datas = new ArrayList<>();
    private String[] from = {"name", "sex", "age"};
    private int[] ids = {R.id.sa_lv_name_tv, R.id.sa_lv_sex_tv, R.id.sa_lv_age_tv};
    SimpleAdapter adapter;

    private String[] names = {"jerry", "tom", "who"};
    private String[] sexs = {"boy", "girl", "both"};
    private String[] ages = {"13", "14", "55"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_lv);
        saLv = findViewById(R.id.sa_lv);
        /**
         * 参数一多，有些人就头晕了。这里解说下，各个参数的意思。
         * 第一个参数 this 代表的是当前上下文，可以理解为你当前所处的activity
         * 第二个参数 getData() 一个包含了数据的List,注意这个List里存放的必须是map对象。simpleAdapter中的限制是这样的List<? extends Map<String, ?>> data
         * 第三个参数 R.layout.sa_lv_item 展示信息的组件
         * 第四个参数 一个string数组，数组内存放的是你存放数据的map里面的key
         * 第五个参数：一个int数组，数组内存放的是你展示信息组件中，每个数据的具体展示位置，与第四个参数一一对应
         *
         */
        adapter = new SimpleAdapter(this, datas, R.layout.sa_lv_item, from, ids);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDatas();
        saLv.setAdapter(adapter);
    }

    private void getDatas() {
        for (int i = 0; i < names.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", names[i]);
            map.put("sex", sexs[i]);
            map.put("age", ages[i]);
            datas.add(map);
        }
    }
}
