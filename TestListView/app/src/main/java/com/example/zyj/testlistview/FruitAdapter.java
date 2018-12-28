package com.example.zyj.testlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/**
 * Created by zyj on 2018/4/18.
 */

public class FruitAdapter extends ArrayAdapter<Fruit>{
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
    super(context,textViewResourceId,objects);
    resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);//获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
           view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage=view.findViewById(R.id.fruit_image);
            viewHolder.fruitName=view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将ViewHolder存到view中
        }
        else {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        //View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
       /* ImageView fruitImage=view.findViewById(R.id.fruit_image);
        TextView fruitName=view.findViewById(R.id.fruit_name);*/
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

}
//提升textview的运行效率
class ViewHolder{
    ImageView fruitImage;
    TextView fruitName;
}
