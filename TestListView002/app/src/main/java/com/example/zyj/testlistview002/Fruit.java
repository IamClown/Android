package com.example.zyj.testlistview002;

/**
 * Created by zyj on 2018/4/20.
 */

public class Fruit {
    private String name;
    private int imagrId;
    public Fruit(String name,int imagrId){
    this.imagrId=imagrId;
    this.name=name;
    }
    public String getName(){
        return name;
    }
    public int getImagrId(){
        return imagrId;
    }
}
