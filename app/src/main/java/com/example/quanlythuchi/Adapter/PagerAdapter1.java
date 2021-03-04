package com.example.quanlythuchi.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.quanlythuchi.fragments.FMKT;
import com.example.quanlythuchi.fragments.FMLT;

public class PagerAdapter1 extends FragmentStatePagerAdapter {
    public PagerAdapter1(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new FMKT();
        }else if(position==1){
            return new FMLT();
        }else {
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "khoản thu";
            case 1:
                return "loai thu";
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
