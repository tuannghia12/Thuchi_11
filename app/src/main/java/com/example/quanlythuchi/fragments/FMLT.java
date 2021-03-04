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

import com.example.quanlythuchi.Adapter.LoaiThuAdapter;
import com.example.quanlythuchi.model.loaiThu;
import com.example.quanlythuchi.sqlite.database;

public class FMLT extends Fragment {
    public FMLT(){

    }
    private View rootview;
    com.example.quanlythuchi.sqlite.database database;
    ArrayList<loaiThu> list;
    LoaiThuAdapter adapter;
    ListView lv_loaithu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.flagment_loai_thu,container,false);
        initView();
        return rootview;
    }

    private void initView() {
        lv_loaithu = rootview.findViewById(R.id.lv_loaithu);
        list = new ArrayList<>();
        database = new database(getActivity());
        adapter = new LoaiThuAdapter(getActivity(),R.layout.list_item_loai_thu,list);
        Cursor dataloaithu = database.GetData("SELECT * FROM THU");
        list.clear();
        while (dataloaithu.moveToNext()){
            String a= dataloaithu.getString(2);
            int b = dataloaithu.getInt(3);
            list.add(new loaiThu(a,b));
        }
        adapter.notifyDataSetChanged();
        lv_loaithu.setAdapter(adapter);
    }
}
