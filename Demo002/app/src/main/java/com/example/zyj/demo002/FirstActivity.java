package com.example.zyj.demo002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    private Button pass;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==RESULT_OK){
          String da= data.getStringExtra("data_return");
            Log.d("FirstActivity",da );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //
        pass=findViewById(R.id.btn_pass);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data="今天天气真不错";
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("data_pass",data);
                //startActivity(intent);
                startActivityForResult(intent,1);
            }
        });

    }
}
