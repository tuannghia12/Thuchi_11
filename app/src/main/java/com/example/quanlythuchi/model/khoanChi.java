package com.example.quanlythuchi.model;

public class khoanChi {
    String khoanChi;
    int idchi;
    public khoanChi(String khoanChi, int idchi){
        this.khoanChi=khoanChi;
        this.idchi=idchi;
    }

    public String getKhoanChi() {
        return khoanChi;
    }

    public void setKhoanChi(String khoanChi) {
        this.khoanChi = khoanChi;
    }

    public int getIdChi() {
        return idchi;
    }

    public void setIdChi(int idchi) {
        this.idchi = idchi;
    }
}
