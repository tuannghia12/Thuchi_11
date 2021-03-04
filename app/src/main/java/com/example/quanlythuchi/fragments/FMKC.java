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

import com.example.quanlythuchi.Adapter.KhoanChiAdapter;
import com.example.quanlythuchi.R;

import java.util.ArrayList;

import com.example.quanlythuchi.model.khoanChi;
import com.example.quanlythuchi.sqlite.database;

public class FMKC extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
    }
    public FMKC(){

    }
    private View rootview;
    KhoanChiAdapter adapter;
    ArrayList<khoanChi> list;
    ListView lv_khoanchi;
    com.example.quanlythuchi.sqlite.database database;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.flagment_khoan_chi,container,false);
        initView();
        return rootview;
    }

    private void initView() {
        database = new database(getActivity());
        lv_khoanchi = rootview.findViewById(R.id.lv_khoanchi);
        list = new ArrayList<>();
        adapter = new KhoanChiAdapter(getActivity(),R.layout.list_item_khoan_chi,list);
        Cursor datakhoanchi = database.GetData("SELECT * FROM CHI");
        list.clear();
        while (datakhoanchi.moveToNext()){
            String a =  datakhoanchi.getString(1);
            int b = datakhoanchi.getInt(3);
            list.add(new khoanChi(a,b));
        }
        adapter.notifyDataSetChanged();
        lv_khoanchi.setAdapter(adapter);
    }
}
