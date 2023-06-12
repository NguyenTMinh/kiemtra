package com.example.myapplication.model;

public class SanPham {
    private int anh;
    private String ten;
    private long tien;

    public SanPham(int anh, String ten, long tien) {
        this.anh = anh;
        this.ten = ten;
        this.tien = tien;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public long getTien() {
        return tien;
    }

    public void setTien(long tien) {
        this.tien = tien;
    }
}
