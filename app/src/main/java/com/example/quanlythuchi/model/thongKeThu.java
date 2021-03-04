package com.example.quanlythuchi.model;

public class thongKeThu {
    String ngaythang,khoanthu,loaithu;

    public thongKeThu(String ngaythang, String khoanthu, String loaithu) {
        this.ngaythang = ngaythang;
        this.khoanthu = khoanthu;
        this.loaithu = loaithu;
    }

    public String getNgaythang() {
        return ngaythang;
    }

    public void setNgaythang(String ngaythang) {
        this.ngaythang = ngaythang;
    }

    public String getKhoanthu() {
        return khoanthu;
    }

    public void setKhoanthu(String khoanthu) {
        this.khoanthu = khoanthu;
    }

    public String getLoaithu() {
        return loaithu;
    }

    public void setLoaithu(String loaithu) {
        this.loaithu = loaithu;
    }
}
