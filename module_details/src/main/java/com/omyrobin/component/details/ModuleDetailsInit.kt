package com.omyrobin.component.details

import android.content.Context
import android.content.res.Configuration
import com.omyrobin.component.common.services.IModuleInit

/**
 * @Author: wubo
 * @CreateDate: 2022/2/24 10:55 上午
 * @Description:
 */
class ModuleDetailsInit: IModuleInit {

    override fun attachBaseContext(base: Context?) {

    }

    override fun onCreate() {
        println("========ModuleDetails 模块onCreate()========")
    }

    override fun onLowMemory() {
    }

    override fun onTrimMemory(level: Int) {
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
    }

    override fun getPriority(): Int {
        return 3
    }
}