package com.csycc.zg.recyclerpageradapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 * itemView 能重复使用的PagerAdapter
 * Created by zg on 16/6/24.
 */
public abstract class RecyclerPagerAdapter extends PagerAdapter {

    /**
     * 用来缓存从ViewPager中移除掉的itemView。instantiateItem时先尝试从缓存池取，缓存池没有就去创建
     */
    private LinkedList<View> recycleItemViewsList = new LinkedList<>();

    /**
     * 已经添加到ViewPager上的itemView。notifyDataSetChanged时用来刷新数据
     */
    private HashMap<Integer, View> addItemViewsMap = new HashMap<>();

    public Object instantiateItem(ViewGroup container, int position) {
        View itemView;
        if (recycleItemViewsList.isEmpty()) {
            itemView = createItemView(container);
        } else {
            itemView = recycleItemViewsList.removeLast();
        }
        addItemViewsMap.put(position, itemView);
        binderItemView(itemView, position);
        container.addView(itemView, 0);
        return itemView;
    }

    abstract View createItemView(ViewGroup container);

    abstract void binderItemView(View itemView, int position);

    public void destroyItem(ViewGroup container, int position, Object object) {
        View itemView = (View) object;
        container.removeView(itemView);
        recycleItemViewsList.add(itemView);
        addItemViewsMap.remove(position);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        refreshItemViews();
    }

    private void refreshItemViews() {
        Set<Integer> positionSet = addItemViewsMap.keySet();
        for (int position : positionSet) {
            binderItemView(addItemViewsMap.get(position), position);
        }
    }
}
