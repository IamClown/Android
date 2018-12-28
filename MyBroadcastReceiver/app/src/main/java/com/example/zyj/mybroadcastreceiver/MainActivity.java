package com.example.zyj.mybroadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(this);
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent("com.example.broadcast.MyBroadcastReceiver_MY");
                intent.putExtra("Msg","明天不用上课");
                sendBroadcast(intent);
                Log.d("MainActivity", "onClick: ok");
//                    sendOrderedBroadcast(intent,null);
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent("com.example.MyBroadcastReceiver_MY");
        //intent.putExtra("Msg","明天不用上课");
        sendBroadcast(intent);
    }
}
