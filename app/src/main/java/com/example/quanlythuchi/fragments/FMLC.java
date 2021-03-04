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

import com.example.quanlythuchi.Adapter.LoaiChiAdapter;
import com.example.quanlythuchi.model.loaiChi;
import com.example.quanlythuchi.sqlite.database;

public class FMLC extends Fragment {
    public FMLC(){

    }
    private View rootview;
    ListView lv_loaichi;
    ArrayList<loaiChi> list;
    LoaiChiAdapter adapter;
    com.example.quanlythuchi.sqlite.database database;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.flagment_loai_chi,container,false);
        initView();
        return rootview;
    }

    private void initView() {
        lv_loaichi = rootview.findViewById(R.id.lv_loaichi);
        list = new ArrayList<>();
        database = new database(getActivity());
        adapter = new LoaiChiAdapter(getActivity(),R.layout.list_item_loai_chi,list);
        Cursor dataloaichi = database.GetData("SELECT * FROM CHI");
        list.clear();
        while (dataloaichi.moveToNext()){
            String a = dataloaichi.getString(2);
            int b = dataloaichi.getInt(3);
            list.add(new loaiChi(a,b));
        }
        adapter.notifyDataSetChanged();
        lv_loaichi.setAdapter(adapter);
    }
}
