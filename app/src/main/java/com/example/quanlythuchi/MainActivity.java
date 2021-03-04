package com.example.quanlythuchi;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.viewpager.widget.ViewPager;

import com.example.quanlythuchi.Adapter.PagerAdapter;
import com.example.quanlythuchi.sqlite.database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    database db;
    ViewPager paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        paper = (ViewPager) findViewById(R.id.view_paper);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        paper.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new database(MainActivity.this);
                if(paper.getCurrentItem()==0){
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_thu);
                    final EditText edt_khoanthu = (EditText)dialog.findViewById(R.id.edtkhoanthu);
                    final EditText edt_loaithu = (EditText)dialog.findViewById(R.id.edtloaithu);
                    Button btnvaothu = (Button)dialog.findViewById(R.id.btnvaothu);
                    btnvaothu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a= edt_khoanthu.getText().toString();
                            String b = edt_loaithu.getText().toString();
                            String c= new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                            if(a.isEmpty() || b.isEmpty()){
                                Toast.makeText(MainActivity.this,"Vui lòng không để trống",Toast.LENGTH_SHORT).show();
                            }else {
                                db.SendData("INSERT INTO THU VALUES ('"+c+"','"+a+"','"+b+"',NULL)");
                                PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
                                paper.setAdapter(adapter);
                                paper.setCurrentItem(2);
                                Toast.makeText(MainActivity.this,"Thêm dữ liệu thành công",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }
                    });
                    dialog.show();
                }
                else if(paper.getCurrentItem()==1){
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_chi);

                    final EditText edt_khoanchi = (EditText)dialog.findViewById(R.id.edtkhoanchi);
                    final EditText edt_loaichi = (EditText)dialog.findViewById(R.id.edtloaichi);
                    Button btnvaochi = (Button)dialog.findViewById(R.id.btnvaochi);
                    btnvaochi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                            String b = edt_khoanchi.getText().toString();
                            String c = edt_loaichi.getText().toString();
                            if(a.isEmpty() || b.isEmpty()){
                                Toast.makeText(MainActivity.this,"Vui lòng không để trống",Toast.LENGTH_SHORT).show();
                            }else {
                                db.SendData("INSERT INTO CHI VALUES ('"+a+"','"+b+"','"+c+"',NULL)");
                                PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
                                paper.setAdapter(adapter);
                                paper.setCurrentItem(2);
                                Toast.makeText(MainActivity.this,"Thêm dữ liệu thành công",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }
                    });
                    dialog.show();
                }
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_khoanThu){
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            paper.setAdapter(adapter);
            paper.setCurrentItem(0);
        }if(id == R.id.nav_khoanChi){
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            paper.setAdapter(adapter);
            paper.setCurrentItem(1);
        }if(id == R.id.nav_thongKe){
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            paper.setAdapter(adapter);
            paper.setCurrentItem(2);
        }if(id == R.id.nav_gioiThieu){
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            paper.setAdapter(adapter);
            paper.setCurrentItem(3);
        }if(id == R.id.nav_thoat){
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}