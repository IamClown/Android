package com.example.zyj.demolistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zyj on 2018/4/20.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResource, List<Fruit> object){
        super(context,textViewResource,object);
        resourceId  = textViewResource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //获取当前fruit的实例
        Fruit fruit = getItem(position);
        ViewHolder viewHolder;
        View view;
        if (convertView==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            //实例
            viewHolder = new ViewHolder();
            viewHolder.fruitImage=view.findViewById(R.id.fruit_Image);
            viewHolder.fruitName=view.findViewById(R.id.fruit_Name);
            view.setTag(viewHolder);
        }
        else {
            view=convertView;
             viewHolder = (ViewHolder) view.getTag();//重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getFruit_image());
        viewHolder.fruitName.setText(fruit.getFruit_name());
        return view;
    }
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
