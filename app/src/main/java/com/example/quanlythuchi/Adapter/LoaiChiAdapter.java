package com.example.quanlythuchi.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlythuchi.MainActivity;
import com.example.quanlythuchi.R;

import java.util.ArrayList;
import java.util.List;

import com.example.quanlythuchi.model.loaiChi;
import com.example.quanlythuchi.sqlite.database;

public class LoaiChiAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<loaiChi> loaiChiList;

    public LoaiChiAdapter(Context context, int layout, ArrayList<loaiChi> loaiChiList) {
        this.context = context;
        this.layout = layout;
        this.loaiChiList = loaiChiList;
    }

    @Override
    public int getCount() {
        return loaiChiList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txtloaichi = (TextView)convertView.findViewById(R.id.txtloaichi);
            holder.loaichisua = (ImageView)convertView.findViewById(R.id.loaichisua);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        final loaiChi lc =loaiChiList.get(position);
        holder.txtloaichi.setText(lc.getLoaiChi());
        holder.loaichisua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = (EditText)dialog.findViewById(R.id.edt_sua);
                edtsua.setText(lc.getLoaiChi());
                Button btnsua = (Button)dialog.findViewById(R.id.btn_sua);
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = edtsua.getText().toString();
                        int b = lc.getIdchi();
                        if(a.isEmpty()){
                            Toast.makeText(context,"vui lòng không để trống loại chi",Toast.LENGTH_SHORT).show();
                        }else {
                            database db = new database(context);
                            db.SendData("UPDATE CHI SET LOAICHI = '"+a+"' WHERE IDCHI = "+b+" ");
                            Toast.makeText(context,"Cập nhập loại chi thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }
                });
                dialog.show();
            }
        });
        return convertView;
    }

    private class ViewHolder{
        TextView txtloaichi;
        ImageView loaichisua;
    }



    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
