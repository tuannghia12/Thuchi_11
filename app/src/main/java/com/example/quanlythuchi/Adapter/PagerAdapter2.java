package com.example.quanlythuchi.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.quanlythuchi.fragments.FMKC;
import com.example.quanlythuchi.fragments.FMLC;

public class PagerAdapter2 extends FragmentStatePagerAdapter {
    public PagerAdapter2(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new FMKC();
        }else if(position == 1){
            return new FMLC();
        }else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "khoản chi";
            case 1:
                return "loại chi";
        }
        return null;
    }
}
