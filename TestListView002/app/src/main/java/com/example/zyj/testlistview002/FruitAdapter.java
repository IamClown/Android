package com.example.zyj.testlistview002;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zyj on 2018/4/20.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResource, List<Fruit> object){
        super(context,textViewResource,object);
        resourceId=textViewResource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit=getItem(position);//获取当前fruit的实例
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            //加载布局
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            //实例ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.imageView= view.findViewById(R.id.fruitImage);
            viewHolder.textView=view.findViewById(R.id.fruitName);
            view.setTag(viewHolder);//将ViewHolder存储在View中
            Log.d("MainActivity","张英剑");
        }
        else {
            view = convertView;
            viewHolder=(ViewHolder) view.getTag();
            Log.d("MainActivity","张明浩");
        }
        //View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        //ImageView imageView=view.findViewById(R.id.fruitImage);
        //TextView textView=view.findViewById(R.id.fruitName);
        viewHolder.imageView.setImageResource(fruit.getImagrId());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
