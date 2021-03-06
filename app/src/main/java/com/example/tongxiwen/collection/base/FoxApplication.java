package com.example.tongxiwen.collection.base;

import android.app.Activity;
import android.app.Application;

import com.example.tongxiwen.collection.utils.ActivityCollector;

/**
 * 自定义Application
 *
 * 集成自定义的Activity管理器，内涵模拟返回栈
 * 可以批量销毁activity
 */
public class FoxApplication extends Application {

    // 自定义Activity管理器
    private final static ActivityCollector mCollector = ActivityCollector.get();

    /**
     * 模拟返回栈注册
     */
    public void registerActivity(Activity activity){
        mCollector.list(activity);
    }

    /**
     * 模拟返回栈注销
     */
    public void unRegisterActivity(Activity activity){
        mCollector.delist(activity);
    }

    /**
     * 获取Activity管理器
     */
    public ActivityCollector getActivityCollector() {
        return mCollector;
    }

    /**
     * 存入全局缓存数据
     * @param key   键
     * @param value 值
     */
    public static void putGlobalData(String key, Object value){
        mCollector.putGlobalData(key, value);
    }

    /**
     * 获取全局缓存数据
     * @param key   键
     * @param <T>   数据类型
     * @return  数据
     */
    public static <T> T getGlobalData(String key){
        return mCollector.getGlobalData(key);
    }
}
