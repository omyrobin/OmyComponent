package com.omyrobin.component.common.services

import android.content.Context
import android.content.res.Configuration

/**
 * @Author: wubo
 * @CreateDate: 2022/2/24 10:42 上午
 * @Description: module生命周期同步接口，用于Application启动时将生命周期状态分发到各个module中
 */
interface IModuleInit {

    fun attachBaseContext(base: Context?)

    fun onCreate()

    fun onLowMemory()

    fun onTrimMemory(level: Int)

    fun onConfigurationChanged(newConfig: Configuration)
    // 优先级 module 按照优先级在数组中排序，并按排序后的顺序进行分发上面的函数回调 数字越大优先级越高
    fun getPriority() : Int


}