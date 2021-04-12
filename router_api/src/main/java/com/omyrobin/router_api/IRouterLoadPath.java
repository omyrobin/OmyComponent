package com.omyrobin.router_api;

import com.omyrobin.router_annotation.RouteMeta;

import java.util.Map;

/**
 * @Author: omyrobin
 * @CreateDate: 2021/4/11 9:28 PM
 * @Description:
 */
public interface IRouterLoadPath {

    /**
     * 加载路由Group中path的详细数据
     * "app/MainActivity"
     * @return
     */
    Map<String, RouteMeta> loadPath();
}
