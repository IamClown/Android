package com.example.zyj.mybroadcastreceiver1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"明天星期几",Toast.LENGTH_SHORT).show();
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}