package com.example.zyj.demo002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button Return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        Log.d("SecondActivyty",intent.getStringExtra("data_pass"));
        Return=findViewById(R.id.btn_fanhui);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent();
                intent1.putExtra("data_return","是的");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }
}
