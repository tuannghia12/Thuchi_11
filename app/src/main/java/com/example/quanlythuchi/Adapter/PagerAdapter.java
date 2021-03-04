package com.example.quanlythuchi.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.quanlythuchi.GioiThieuActivity;
import com.example.quanlythuchi.flagment.flagment1;
import com.example.quanlythuchi.flagment.flagment2;
import com.example.quanlythuchi.flagment.flagment3;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position){
            case 0:
                frag = new flagment2();
                break;
            case 1:
                frag = new flagment3();
                break;
            case 2:
                frag = new flagment1();
                break;
            case 3:
                frag = new GioiThieuActivity();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
