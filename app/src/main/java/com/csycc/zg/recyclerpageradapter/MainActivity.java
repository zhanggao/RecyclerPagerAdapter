package com.csycc.zg.recyclerpageradapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ViewPager mViewPager;
    private ArrayList<String> mDataList;
    private RecyclerPagerAdapterExample mRecyclerPagerAdapterExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mDataList = new ArrayList<>();
        refreshDataList();
        mRecyclerPagerAdapterExample = new RecyclerPagerAdapterExample(mDataList);
        mViewPager.setAdapter(mRecyclerPagerAdapterExample);
    }

    public void refreshAdapterOnClick(View view) {
        refreshDataList();
        mRecyclerPagerAdapterExample.notifyDataSetChanged();
    }

    private void refreshDataList() {
        mDataList.clear();
        for (int i = 0; i < 10000; i++) {
            mDataList.add("随机标题" + ((int) (100 * Math.random())));
        }
    }

}
