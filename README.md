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

# 注意
如果发现 isModule = true module仍然不能单独打包成独立的apk 请检查Android Studio左侧导航栏中的Build Variants中的构建渠道 将所有module的Active Build Varint改为Debug
