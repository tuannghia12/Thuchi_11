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

import com.example.quanlythuchi.model.loaiThu;
import com.example.quanlythuchi.sqlite.database;

public class LoaiThuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<loaiThu> loaiThuList;
    public LoaiThuAdapter(Context context, int layout, ArrayList<loaiThu> loaiThuList) {
        this.context = context;
        this.layout = layout;
        this.loaiThuList = loaiThuList;
    }
    @Override
    public int getCount() {
        return loaiThuList.size();
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
        TextView txtloaithu;
        ImageView loaithusua;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txtloaithu = (TextView)convertView.findViewById(R.id.txtloaithu);
            holder.loaithusua = (ImageView)convertView.findViewById(R.id.loaithusua);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        final loaiThu lt =loaiThuList.get(position);
        holder.txtloaithu.setText(lt.getLoaiThu());
        holder.loaithusua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = (EditText)dialog.findViewById(R.id.edt_sua);
                edtsua.setText(lt.getLoaiThu());
                Button btnsua = (Button)dialog.findViewById(R.id.btn_sua);
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = edtsua.getText().toString();
                        int b = lt.getIdthu();
                        if(a.isEmpty()){
                            Toast.makeText(context,"vui lòng không để trống loại thu",Toast.LENGTH_SHORT).show();
                        }else {
                            database db = new database(context);
                            db.SendData("UPDATE THU SET LOAITHU = '"+a+"' WHERE IDTHU = "+b+" ");
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
}
