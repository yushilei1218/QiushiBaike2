package com.yushilei.qiushibaike.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.yushilei.qiushibaike.fragments.BlankFragment;

import java.util.List;

/**
 * Created by yushilei on 2015/12/28.
 */
public class MyAdapter extends FragmentPagerAdapter {
    private List<String> list;

    public MyAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (list != null) {
            ret = list.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
