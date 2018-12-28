package com.example.zyj.testlistview002;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Fruit> fruitlist= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitlist);
        ListView listView = findViewById(R.id.lv_Fruitlist);
        listView.setAdapter(fruitAdapter);
    }

    private void initFruits() {
       for (int i=0;i<2;i++){
           Fruit banana=new Fruit("banana",R.drawable.banana_pic);
           fruitlist.add(banana);
           Fruit cherry = new Fruit("cherry",R.drawable.cherry_pic);
           fruitlist.add(cherry);
           Fruit grape = new Fruit("grape",R.drawable.grape_pic);
           fruitlist.add(grape);
           Fruit orange = new Fruit("orange",R.drawable.orange_pic);
           fruitlist.add(orange);
           Fruit peach = new Fruit("peach",R.drawable.peach_pic);
           fruitlist.add(peach);
           Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple_pic);
           fruitlist.add(pineapple);
           Fruit tomato = new Fruit("tomato",R.drawable.tomato_pic);
           fruitlist.add(tomato);
           Fruit watermelon = new Fruit("watermelon",R.drawable.watermelon_pic);
           fruitlist.add(watermelon);
           Fruit qingjiao = new Fruit("qingjiao",R.drawable.qingjiao_pic);
           fruitlist.add(qingjiao);
       }
    }
}
