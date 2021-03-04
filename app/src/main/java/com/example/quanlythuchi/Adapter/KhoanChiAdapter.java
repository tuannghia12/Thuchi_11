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

import com.example.quanlythuchi.model.khoanChi;
import com.example.quanlythuchi.sqlite.database;

public class KhoanChiAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<khoanChi> khoanChiList;

    public KhoanChiAdapter(Context context, int layout, ArrayList<khoanChi> khoanChiList) {
        this.context = context;
        this.layout = layout;
        this.khoanChiList = khoanChiList;
    }

    @Override
    public int getCount() {
        return khoanChiList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txtKhoanchi = (TextView)convertView.findViewById(R.id.txtkhoanchi);
            holder.khoanchisua = (ImageView)convertView.findViewById(R.id.khoanchisua);
            holder.khoanchixoa = (ImageView)convertView.findViewById(R.id.khoanchixoa);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        final khoanChi kc = khoanChiList.get(position);
        holder.txtKhoanchi.setText(kc.getKhoanChi());
        holder.khoanchisua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = (EditText) dialog.findViewById(R.id.edt_sua);
                Button btnsua = (Button) dialog.findViewById(R.id.btn_sua);
                edtsua.setText(kc.getKhoanChi());
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = edtsua.getText().toString();
                        int b= kc.getIdChi();
                        if(a.isEmpty()){
                            Toast.makeText(context,"Vui lòng không để trống khoản chi",Toast.LENGTH_SHORT).show();
                        }else{
                            database db = new database(context);
                            db.SendData("UPDATE CHI SET KHOANCHI = '"+a+"' WHERE IDCHI = "+b+" ");
                            Toast.makeText(context,"Cập nhập khoản chi thành công",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }
                });
                dialog.show();
            }
        });
        holder.khoanchixoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_xoa);
                Button btnhuy = (Button)dialog.findViewById(R.id.btn_huyboxoa);
                Button btnchapnhan = (Button)dialog.findViewById(R.id.btn_chapnhanxoa);
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnchapnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int a = kc.getIdChi();
                        database db = new database(context);
                        db.SendData("DELETE FROM CHI WHERE IDCHI = "+a+" ");
                        Toast.makeText(context,"Xóa thông tin thành công",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        ((MainActivity)context).recreate();
                    }
                });
                dialog.show();
            }
        });
        return convertView;
    }

    private class ViewHolder{
        TextView txtKhoanchi;
        ImageView khoanchisua,khoanchixoa;
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

