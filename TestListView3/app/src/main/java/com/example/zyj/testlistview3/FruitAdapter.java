package com.example.zyj.testlistview3;

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
import java.util.Map;

/**
 * Created by zyj on 2018/4/22.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);//获取当前的Fruit实例
        //提升ListView的运行效率
        View view;
        //声明一个ViewHolder类，将子布局中的属性放在里面，防止重复加载
        ViewHolder viewHolder;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.fruit_Image);
            viewHolder.textView = view.findViewById(R.id.fruit_Name);
            //调用view中的setTag()方法
            view.setTag(viewHolder);
        }
        else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
            Log.d("MainActivity", "getView: "+"zzzzzzzzz");
        }
        //View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
       /* ImageView imageView = view.findViewById(R.id.fruit_Image);
        TextView textView = view.findViewById(R.id.fruit_Name);*/
        viewHolder.imageView.setImageResource(fruit.getFruitImageId());
        viewHolder.textView.setText(fruit.getFruitName());
        return view;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
