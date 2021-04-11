package com.omyrobin.route_annotation;

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

    public Class<?> getDestination() {
        return destination;
    }

    public String getPath() {
        return path;
    }

    public String getGroup() {
        return group;
    }
}
