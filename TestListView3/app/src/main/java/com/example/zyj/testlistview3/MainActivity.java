package com.example.zyj.testlistview3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //声明变量来存储数据，我们后面的操作都是对这个fruitlist的。
    private List<Fruit> fruitlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //声明一个方法，用来加载数据
        initfruit();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitlist);
        ListView listView = findViewById(R.id.fruitList);
        listView.setAdapter(adapter);
    }

    private void initfruit() {
        //声明Fruit实体类，并赋值
        //为了我们更好的测试ListView我们这里用了循环
        for (int i = 0; i<2;i++){
            Fruit peach = new Fruit("peach",R.drawable.peach_pic);
            fruitlist.add(peach);
            Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple_pic);
            fruitlist.add(pineapple);
            Fruit qingjiao =new Fruit("qingjiao",R.drawable.qingjiao_pic);
            fruitlist.add(qingjiao);
            Fruit strawberry = new Fruit("starwberry",R.drawable.strawberry);
            fruitlist.add(strawberry);
            Fruit tomato = new Fruit("tomato",R.drawable.tomato_pic);
            fruitlist.add(tomato);
            Fruit watermelon = new Fruit("watermlon",R.drawable.watermelon_pic);
            fruitlist.add(watermelon);

            Fruit zz = new Fruit("zz",R.drawable.ic_launcher_background);
            fruitlist.add(zz);
        }
    }
}

