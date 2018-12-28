package com.example.zyj.testmessage1;

import android.net.nsd.NsdManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initMsgs();
        //初始化控件
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(manager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取当前你在文本框中输入的内容
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    //当有新消息时，刷新RecyclerView中的显示
                    adapter.notifyItemInserted(msgList.size()-1);
                    //将ListView定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    //清空文本框内容
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsgs() {
    Msg msg1 = new Msg("你好！张丿先灬森",Msg.TYPE_RECEIVED);
    msgList.add(msg1);
    Msg msg2 = new Msg("你好！很高兴认识你",Msg.TYPE_SENT);
    msgList.add(msg2);
    Msg msg3 = new Msg("我也是，很高兴认识你！",Msg.TYPE_RECEIVED);
    msgList.add(msg3);
    }
}
