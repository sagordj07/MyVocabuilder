package com.room.myvocabuilder;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAccesAdapter extends FragmentPagerAdapter {

    public TabAccesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i)
        {
            case 0:
                WordFragment wordFragment=new WordFragment();
                return wordFragment;
            case 1:
                weeklyFragment weeklyFragment=new weeklyFragment();
                return weeklyFragment;
            case 2:
                MonthlyFragment monthlyFragment =new MonthlyFragment();
                return monthlyFragment;
            default:
                return null;


        }


    }

    @Override
    public int getCount() {
        return 3;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Word";
            case 1:
                return "Weekly";
            case 2:
                return  "Monthly";
            default:
                return null;


        }

    }
}


