package com.example.zyj.testlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
   private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initFruit();//初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item_,fruitList);
        ListView listView = findViewById(R.id.lv_fruit);
        listView.setAdapter(adapter);
    }

    private void initFruit() {
    for (int i = 0;i<2;i++){
    Fruit banana = new Fruit("banana",R.drawable.banana_pic);
    fruitList.add(banana);
    Fruit cherry = new Fruit("cherry",R.drawable.cherry_pic);
    fruitList.add(cherry);
    Fruit grape = new Fruit("grape",R.drawable.grape_pic);
    fruitList.add(grape);
    Fruit orange = new Fruit("orange",R.drawable.orange_pic);
    fruitList.add(orange);
    Fruit peach = new Fruit("peach",R.drawable.peach_pic);
    fruitList.add(peach);
    Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple_pic);
    fruitList.add(pineapple);
    Fruit strawberry = new Fruit("strawberry",R.drawable.strawberry);
    fruitList.add(strawberry);
    Fruit tomato = new Fruit("tomato",R.drawable.tomato_pic);
    fruitList.add(tomato);
    Fruit watermelon = new Fruit("watermelon",R.drawable.watermelon_pic);
    fruitList.add(watermelon);

    }
    }

}
