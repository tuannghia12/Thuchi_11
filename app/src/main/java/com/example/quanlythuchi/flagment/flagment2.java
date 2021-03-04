package com.example.quanlythuchi.flagment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.quanlythuchi.R;
import com.google.android.material.tabs.TabLayout;

import com.example.quanlythuchi.Adapter.PagerAdapter1;

public class flagment2 extends Fragment {
    public flagment2(){

    }
    private View rootview;
    TabLayout tl;
    PagerAdapter1 pagerAdapter;
    ViewPager pager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.flagment2,container,false);
        initView();
        return rootview;
    }

    private void initView() {
        pagerAdapter = new PagerAdapter1(getActivity().getSupportFragmentManager());
        tl = rootview.findViewById(R.id.tab_layout1);
        pager = rootview.findViewById(R.id.view_paper1);
        pager.setAdapter(pagerAdapter);
        tl.setupWithViewPager(pager);
    }
}
