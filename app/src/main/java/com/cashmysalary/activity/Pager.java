package com.cashmysalary.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.cashmysalary.fragment.FinishedFragment;
import com.cashmysalary.fragment.ProcessingFragment;

public class Pager extends FragmentStatePagerAdapter {
    //integer to count number of tabs
    private static int TAB_COUNT = 2;

    public Pager(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProcessingFragment.newInstance();
            case 1:
                return FinishedFragment.newInstance();
        }
        return null;
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ProcessingFragment.TITLE;
            case 1:
                return FinishedFragment.TITLE;
        }
        return super.getPageTitle(position);
    }
}
