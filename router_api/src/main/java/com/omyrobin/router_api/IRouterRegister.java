package com.omyrobin.router_api;

import com.omyrobin.router_annotation.RouteMeta;

import java.util.Map;

/**
 * @Author: omyrobin
 * @CreateDate: 2021/4/8 7:24 PM
 * @Description:
 */
public interface IRouterRegister {

    /**
     * put路由信息
     * @param atlas
     */
    void loadInto(Map<String, RouteMeta> atlas);

}
