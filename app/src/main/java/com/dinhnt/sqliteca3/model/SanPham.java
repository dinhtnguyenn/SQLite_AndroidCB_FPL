package com.dinhnt.sqliteca3.model;

public class SanPham {
    private int id;
    private String tenSP;
    private int giaSP;
    private String hinHSP;

    public SanPham(int id, String tenSP, int giaSP, String hinHSP) {
        this.id = id;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.hinHSP = hinHSP;
    }

    public SanPham(String tenSP, int giaSP, String hinHSP) {
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.hinHSP = hinHSP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public String getHinHSP() {
        return hinHSP;
    }

    public void setHinHSP(String hinHSP) {
        this.hinHSP = hinHSP;
    }
}
