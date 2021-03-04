package com.example.quanlythuchi.flagment;

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

import com.example.quanlythuchi.Adapter.ThongKeChiAdapter;
import com.example.quanlythuchi.Adapter.ThongKeThuAdapter;
import com.example.quanlythuchi.model.thongKeChi;
import com.example.quanlythuchi.model.thongKeThu;
import com.example.quanlythuchi.sqlite.database;

public class flagment1 extends Fragment {
    public flagment1(){

    }
    private View rootview;
    ArrayList<thongKeThu> list;
    ArrayList<thongKeChi> list1;
    ThongKeThuAdapter adapter;
    ThongKeChiAdapter adapter1;
    ListView lv_thongkethu;
    ListView lv_thongkechi;
    com.example.quanlythuchi.sqlite.database database;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.flagment1,container,false);
        initView();
        return rootview;
    }

    private void initView() {
        list = new ArrayList<>();
        lv_thongkethu = rootview.findViewById(R.id.lv_thongkethu);
        database = new database(getActivity());
        adapter = new ThongKeThuAdapter(getActivity(),R.layout.list_item_thong_ke_thu,list);
        Cursor datathongkethu = database.GetData("SELECT * FROM THU");
        list.clear();
        while (datathongkethu.moveToNext()){
            String a= datathongkethu.getString(0);
            String b = datathongkethu.getString(1);
            String c = datathongkethu.getString(2);
            list.add(new thongKeThu(a,b,c));
        }
        adapter.notifyDataSetChanged();
        lv_thongkethu.setAdapter(adapter);

        list1 = new ArrayList<>();
        lv_thongkechi = rootview.findViewById(R.id.lv_thongkechi);
        adapter1 = new ThongKeChiAdapter(getActivity(),R.layout.list_item_thong_ke_chi,list1);
        Cursor datathongkechi= database.GetData("SELECT * FROM CHI");
        list1.clear();
        while (datathongkechi.moveToNext()){
            String a= datathongkechi.getString(0);
            String b = datathongkechi.getString(1);
            String c = datathongkechi.getString(2);
            list1.add(new thongKeChi(a,b,c));
        }
        adapter1.notifyDataSetChanged();
        lv_thongkechi.setAdapter(adapter1);
    }
}
