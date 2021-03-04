package com.example.quanlythuchi.model;

public class khoanthu {
    String khoanThu;
    int id;

    public khoanthu(String khoanThu, int idThu) {
        this.khoanThu = khoanThu;
        this.id = idThu;
    }

    public String getKhoanThu() {
        return khoanThu;
    }

    public void setKhoanThu(String khoanThu) {
        this.khoanThu = khoanThu;
    }

    public int getIdThu() {
        return id;
    }

    public void setIdThu(int idThu) {
        this.id = idThu;
    }
}
