package com.omyrobin.router_api;

import java.util.Map;

/**
 * @Author: omyrobin
 * @CreateDate: 2021/4/11 9:27 PM
 * @Description:
 */
public interface IRouterLoadGroup {

    Map<String, Class<? extends IRouterLoadPath>> loadGroup();
}
