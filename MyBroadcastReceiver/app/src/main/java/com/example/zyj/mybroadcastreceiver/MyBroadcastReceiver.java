package com.example.zyj.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Log.d("MyBroadcastReceiver", "onReceive: 11111");
        //Toast.makeText(context, "接收到的intent的Action是" , Toast.LENGTH_SHORT).show();
        Toast.makeText(context,"aaa",Toast.LENGTH_SHORT).show();
        // abortBroadcast();//终止传递
    }
}
