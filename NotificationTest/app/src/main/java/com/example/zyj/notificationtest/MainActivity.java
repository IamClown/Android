package com.example.zyj.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                //获取NotificationManager实例（通知管理）
                NotificationManager manager = (NotificationManager) getSystemService
                        (NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        //设置通知的标题
                        .setContentTitle("This is Content Title")
                        //设置通知的内容
                        .setContentText("This is Content Text")
                        //指定通知被创建的时间（毫秒）
                        .setWhen(System.currentTimeMillis())
                        //设置通知的小图标
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        //设置通知的大图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable
                                .ic_launcher_background)).build();
                //让通知显示出来id唯一就行
                manager.notify(1, notification);
                break;
            default:
                break;

        }
    }
}
