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

import com.example.quanlythuchi.model.khoanthu;
import com.example.quanlythuchi.sqlite.database;

public class KhoanThuAdapter extends BaseAdapter {
    Context context;
    List<khoanthu> khoanThuList;

    public KhoanThuAdapter(Context context, ArrayList<khoanthu> khoanThuList) {
        this.context = context;
        this.khoanThuList = khoanThuList;
    }

    @Override
    public int getCount() {
        return khoanThuList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtkhoanthu;
        ImageView khoanthusua,khoanthuxoa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_khoan_thu,null);
            holder.txtkhoanthu = (TextView)convertView.findViewById(R.id.txtkhoanthu);
            holder.khoanthusua = (ImageView)convertView.findViewById(R.id.khoanthusua);
            holder.khoanthuxoa = (ImageView)convertView.findViewById(R.id.khoanthuxoa);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        final khoanthu kt = khoanThuList.get(position);
        holder.txtkhoanthu.setText(kt.getKhoanThu());
        holder.khoanthusua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = (EditText) dialog.findViewById(R.id.edt_sua);
                Button btnsua = (Button) dialog.findViewById(R.id.btn_sua);
                edtsua.setText(kt.getKhoanThu());
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = edtsua.getText().toString();
                        int b= kt.getIdThu();
                        if(a.isEmpty()){
                            Toast.makeText(context,"Vui lòng không để trống khoản thu",Toast.LENGTH_SHORT).show();
                        }else{
                             database db = new database(context);
                            db.SendData("UPDATE THU SET KHOANTHU = '"+a+"' WHERE IDTHU = "+b+" ");
                            Toast.makeText(context,"Cập nhập khoản thu thành công",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }
                });
                dialog.show();
            }
        });
        holder.khoanthuxoa.setOnClickListener(new View.OnClickListener() {
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
                        int a = kt.getIdThu();
                        database db = new database(context);
                        db.SendData("DELETE FROM THU WHERE IDTHU = "+a+" ");
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
}
