package com.example.zyj.testactivitytime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends testActivity {
    private Button btn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        ActivityCollector.addActivity(this);
        btn_button = findViewById(R.id.button);
        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(NewActivity.this,FirstActivity.class);
            startActivity(intent);
            }
        });
    }
}
