package com.omyrobin.route_api;

/**
 * @Author: omyrobin
 * @CreateDate: 2021/4/10 11:12 AM
 * @Description:
 */
public class RouteMeta {

    private Class<?> destination;
    private String path;
    private String group;

    public RouteMeta(Class<?> destination, String path, String group) {
        this.destination = destination;
        this.path = path;
        this.group = group;
    }

    public static RouteMeta build(Class<?> destination, String path, String group) {
        return new RouteMeta(destination, path, group);
    }

    public static RouteMeta build(Class<?> destination, String path) {
        return new RouteMeta(destination, path, null);
    }
}
