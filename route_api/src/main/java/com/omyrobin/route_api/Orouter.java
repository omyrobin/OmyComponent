package com.omyrobin.route_api;

import android.app.Application;
import android.util.Log;

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

    public RouteMeta build(String path) {
        return routerMap.get(path);
    }

}
