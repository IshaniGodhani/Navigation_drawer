package com.example.crickbuzz;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Pager_Adapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList=new ArrayList<>();
    List<String> titlelist=new ArrayList<>();

    public Pager_Adapter(MainActivity mainActivity, @NonNull FragmentManager fm) {
        super(fm);
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
}