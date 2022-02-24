# OmyComponent

组件化gradle配置1.0.0版

1.组件独立调试开关, 每次更改值后要同步工程 位于gradle.properties文件夹下

isModule = false

2.module中引用


```
//由于每个.gralde文件都表示一个Project对象, 相当于我将我当前的Project对象传入ext中声明的函数中，对Project对象进行配置
if (isModule.toBoolean()) {
    rootProject.ext.setAppDefaultConfig project
} else {
    rootProject.ext.setLibDefaultConfig project
}
```
如有特殊需求可以参考项目
