package com.jwma.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    ArrayAdapter<String> adapter;
    private String[] titles = {"listview+SimpleAdapter", "listview+baseadapter", "多布局listview", "RecyclerView"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.main_lv);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == lv) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, SaLvActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, BaLvActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, MultLvActivity.class));
                    break;
                default:
                    break;
            }
        }
    }
}
