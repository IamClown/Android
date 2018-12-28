package com.example.zyj.testlitepal;

import org.litepal.crud.DataSupport;

public class Categroy extends DataSupport{
    private int id;
    private String categroyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategroyName() {
        return categroyName;
    }

    public void setCategroyName(String categroyName) {
        this.categroyName = categroyName;
    }

    public int getCategroyCode() {
        return categroyCode;
    }

    public void setCategroyCode(int categroyCode) {
        this.categroyCode = categroyCode;
    }

    private int categroyCode;
}
