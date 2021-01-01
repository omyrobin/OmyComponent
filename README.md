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
