package com.ustc.quincy.scos.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Author: Created by QuincyHu on 2016/5/25 0025 19:29.
 * Email:  zhihuqunxing@163.com
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    //保存滑动的Fragment对象
    private List<Fragment> fragmentList;

    //tab名的列表
    private List<String> titleList;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        fragmentList = fragments;
        titleList = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    //获取tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position % titleList.size());
    }
}
