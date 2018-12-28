package com.example.zyj.testfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button change = findViewById(R.id.btn_left);
        change.setOnClickListener(this);
        //动态加载右边的布局
        replaceFragment(new rightfragment());

    }

    private void replaceFragment(Fragment fragment) {
        //声明一个碎片管理器
        FragmentManager manager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        fragmentTransaction.replace(R.id.another_layout, fragment);

        //提交
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                replaceFragment(new anotherfragment());
                break;
            default:
                break;
        }
    }
}
