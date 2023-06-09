package com.example.crickbuzz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class Pager_Adapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList=new ArrayList<>();
    List<String> titlelist=new ArrayList<>();
    ViewPager viewPager;


    public Pager_Adapter(MainActivity mainActivity, @NonNull FragmentManager fm, ViewPager viewPager) {
        super(fm);
        this.viewPager=viewPager;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titlelist.add(title);

    }
}
