package com.csycc.zg.recyclerpageradapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zg on 16/6/24.
 */
public class RecyclerPagerAdapterExample extends RecyclerPagerAdapter {

    private ArrayList<String> mDataList;

    public RecyclerPagerAdapterExample(ArrayList<String> dataList) {
        this.mDataList = dataList;
    }

    @Override
    View createItemView(ViewGroup container) {
        return LayoutInflater.from(container.getContext()).inflate(R.layout.item_pager_example, container, false);
    }

    @Override
    void binderItemView(View itemView, int position) {
        ViewHolder viewHolder = (ViewHolder) itemView.getTag();
        if (null == viewHolder) {
            viewHolder = new ViewHolder(itemView);
            itemView.setTag(viewHolder);
        }
        viewHolder.titleTextView.setText(mDataList.get(position));
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private static class ViewHolder {
        private TextView titleTextView;

        public ViewHolder(View itemView) {
            titleTextView = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
