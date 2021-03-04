package com.example.quanlythuchi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlythuchi.R;

import java.util.List;

import com.example.quanlythuchi.model.thongKeChi;

public class ThongKeChiAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<thongKeChi> list;

    public ThongKeChiAdapter(Context context, int layout, List<thongKeChi> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txt_ngaythang,txt_khoanchi,txt_loaichi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txt_ngaythang = (TextView)convertView.findViewById(R.id.txt_ngaythang1);
            holder.txt_khoanchi = (TextView)convertView.findViewById(R.id.txt_khoanchi);
            holder.txt_loaichi = (TextView)convertView.findViewById(R.id.txt_loaichi);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        thongKeChi tkc = list.get(position);
        holder.txt_ngaythang.setText(tkc.getNgaythang());
        holder.txt_khoanchi.setText(tkc.getKhoanchi());
        holder.txt_loaichi.setText(tkc.getLoaichi());
        return convertView;
    }
}
