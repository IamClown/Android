package com.example.zyj.testrecyclerview;

/**
 * Created by zyj on 2018/4/20.
 */

public class Fruit {
    private String fruitname;
    private int fruitiamge;
    public Fruit(String fruitname,int fruitiamge){
        this.fruitiamge=fruitiamge;
        this.fruitname=fruitname;
    }
    public String getFruitname(){
        return fruitname;
    }
    public int getFruitiamge(){
        return fruitiamge;
    }
}
