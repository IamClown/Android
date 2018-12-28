package com.example.zyj.testactivitytime;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyj on 2018/4/17.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();
    //用于存放我们所有activity的数组
    public static void addActivity(Activity activity) {
        if (activities == null) {
            //如果当前的数组为空，则初始化
            activities = new ArrayList<>();
        } else {
            activities.add(activity);
        }
    }
    //移除已经销毁的活动
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    //结束掉所有的Activity
    public static void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
