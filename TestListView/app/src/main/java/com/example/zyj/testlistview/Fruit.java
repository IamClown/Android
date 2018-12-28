package com.example.zyj.testlistview;

/**
 * Created by zyj on 2018/4/18.
 */
//创建实体类
public class Fruit {
    //定义属性
    private String name;
    private int imageId;
    //写一个有参的构造函数
    public Fruit(String name,int imageId){
    this.name=name;
    this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }

}
