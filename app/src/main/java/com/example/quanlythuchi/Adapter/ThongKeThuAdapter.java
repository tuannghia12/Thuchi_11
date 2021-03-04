package com.example.quanlythuchi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlythuchi.R;

import java.util.List;

import com.example.quanlythuchi.model.thongKeThu;

public class ThongKeThuAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<thongKeThu> list;

    public ThongKeThuAdapter(Context context, int layout, List<thongKeThu> list) {
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
        TextView txt_ngaythang,txt_khoanthu,txt_loaithu;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txt_ngaythang = (TextView)convertView.findViewById(R.id.txt_ngaythang);
            holder.txt_khoanthu = (TextView)convertView.findViewById(R.id.txt_khoanthu);
            holder.txt_loaithu = (TextView)convertView.findViewById(R.id.txt_loaithu);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        thongKeThu tkt = list.get(position);
        holder.txt_ngaythang.setText(tkt.getNgaythang());
        holder.txt_khoanthu.setText(tkt.getKhoanthu());
        holder.txt_loaithu.setText(tkt.getLoaithu());
        return convertView;
    }
}
