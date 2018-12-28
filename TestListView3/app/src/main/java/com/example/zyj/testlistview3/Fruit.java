package com.example.zyj.testlistview3;

/**
 * Created by zyj on 2018/4/22.
 */

public class Fruit {
    private String fruitName;
    private int    fruitImageId;

    public Fruit(String fruitName, int fruitImageId) {
        this.fruitImageId = fruitImageId;
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitImageId() {
        return fruitImageId;
    }
}
