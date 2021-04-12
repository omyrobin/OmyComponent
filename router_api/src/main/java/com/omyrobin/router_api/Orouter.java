package com.omyrobin.router_api;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.omyrobin.router_annotation.RouteMeta;
import com.omyrobin.router_api.utils.ClassUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: omyrobin
 * @CreateDate: 2021/4/6 8:41 PM
 * @Description:
 */
public class Orouter {

    private static final String TAG = Orouter.class.getSimpleName();

    private Context mContext;

    /**
     * 路由表
     */
    private static Map<String, RouteMeta> routerMap = new HashMap<>();

    private Orouter() {
    }

    public static Orouter getInstance() {
        return SingletonHolder.INSTANCE;
    }

    static class SingletonHolder {
        private static final Orouter INSTANCE = new Orouter();
    }

    public void init(Application application) {

        mContext = application;

        try {
            Set<String> classNames = ClassUtils.getFileNameByPackageName(application, "com.omyrobin");
            for (String className : classNames) {
                Class<?> cls = Class.forName(className);
                if (IRouterRegister.class.isAssignableFrom(cls)) {
                    //排除IRouterRegister.class本身
                    if (cls.getSimpleName().equals("IRouterRegister")) {
                        continue;
                    }
                    Log.e(TAG, cls.getName());
                    IRouterRegister load = (IRouterRegister) cls.newInstance();
                    load.loadInto(routerMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 简易的Activity 跳转
     * @param path
     * @return
     */
    public void navigation(String path) {
        if(TextUtils.isEmpty(path)){
            throw new RuntimeException("path must be not null");
        }
        RouteMeta routeMeta = routerMap.get(path);

        //找不动 目前无降级策略 直接抛异常
        if(routeMeta == null){
            throw  new RuntimeException("not found route");
        }

        Intent intent = new Intent(mContext, routeMeta.getDestination());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

}
