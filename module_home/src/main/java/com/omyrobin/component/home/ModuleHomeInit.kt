package com.omyrobin.component.home

import android.content.Context
import android.content.res.Configuration
import com.omyrobin.component.common.services.IModuleInit

/**
 * @Author: wubo
 * @CreateDate: 2022/2/24 10:54 上午
 * @Description:
 */
class ModuleHomeInit: IModuleInit {

    override fun attachBaseContext(base: Context?) {

    }

    override fun onCreate() {
        println("========ModuleHome 模块onCreate()========")
    }

    override fun onLowMemory() {

    }

    override fun onTrimMemory(level: Int) {

    }

    override fun onConfigurationChanged(newConfig: Configuration) {

    }

    override fun getPriority(): Int {
        return 1
    }
}