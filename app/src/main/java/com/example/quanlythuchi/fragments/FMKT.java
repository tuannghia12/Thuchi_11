package com.example.quanlythuchi.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quanlythuchi.R;

import java.util.ArrayList;

import com.example.quanlythuchi.Adapter.KhoanThuAdapter;
import com.example.quanlythuchi.model.khoanthu;
import com.example.quanlythuchi.sqlite.database;

public class FMKT extends Fragment {
    public FMKT(){

    }
    ListView lv_khoanthu;
    ArrayList<khoanthu> list;
    com.example.quanlythuchi.sqlite.database database;
    KhoanThuAdapter adapter;
    private View rootview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.flagment_khoan_thu,container,false);
        initView();
        return rootview;
    }

    private void initView() {
        lv_khoanthu = rootview.findViewById(R.id.lv_khoanthu);
        list = new ArrayList<>();
        database = new database(getActivity());
        adapter = new KhoanThuAdapter(getActivity(),list);
        getdata();
        lv_khoanthu.setAdapter(adapter);
    }

    private void getdata() {
        Cursor datakhoanthu = database.GetData("SELECT * FROM THU");
        list.clear();
        while (datakhoanthu.moveToNext()){
            String a = datakhoanthu.getString(1);
            int b = datakhoanthu.getInt(3);
            list.add(new khoanthu(a,b));
        }
        adapter.notifyDataSetChanged();
    }
}
