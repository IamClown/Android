package com.example.zyj.demolistview;

/**
 * Created by zyj on 2018/4/20.
 */

public class Fruit {
    private String fruit_name;
    private int fruit_image;
    public Fruit(String fruit_name,int fruit_image){
        this.fruit_name=fruit_name;
        this.fruit_image=fruit_image;
    }
    public String getFruit_name(){
        return fruit_name;
    }
    public int getFruit_image(){
        return fruit_image;
    }
}
