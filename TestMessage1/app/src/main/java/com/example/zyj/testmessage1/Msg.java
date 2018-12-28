package com.example.zyj.testmessage1;

/**
 * Created by zyj on 2018/4/22.
 */
/*定义消息的实体类*/
public class Msg {
    //声明属性
    //这两个属性表示消息的类型。TYPE_RECEIVED表示收到一条消息和TYPE_SENT表示发送一条消息
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    //表示消息的内容
    private String content;
    //表示消息的类型，一共有两种类型
    private int type;
    //有参构造
    public Msg(String content,int type){
        this.content=content;
        this.type =type;
    }
    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
}
