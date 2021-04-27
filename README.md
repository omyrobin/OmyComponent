# OmyComponent

组件化gradle配置1.0.0版

1.组件独立调试开关, 每次更改值后要同步工程 位于gradle.properties文件夹下

isModule = false

2.module中引用


```
if (isModule.toBoolean()) {
    rootProject.ext.setAppDefaultConfig project
} else {
    rootProject.ext.setLibDefaultConfig project
}
```
如有特殊需求可以参考项目

# OmyComponent/feature/2.0.0_route

+ 新增router_annotation   java-library 注解库
+ 新增router_compiler     java-library 注解处理库
+ 新增router_api          android-library 注解核心库


```
 Orouter.getInstance().navigation("module_home/ModuleHomeActivity")
```
