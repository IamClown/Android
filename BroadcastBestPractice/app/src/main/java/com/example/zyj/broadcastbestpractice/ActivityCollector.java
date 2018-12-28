package com.example.zyj.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

//用来管理所有的活动
public class ActivityCollector {
    //管理活动的容器
    public static List<Activity> activities = new ArrayList<>();

    //向容器中添加活动
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    //移除活动
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    //销毁所有活动
    public static void finshAll() {
        //判断容器中的子项是否结束，未结束的话，直接停止
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }

        }
    }
}
