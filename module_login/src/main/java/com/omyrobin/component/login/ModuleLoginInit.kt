package com.omyrobin.component.login

import android.content.Context
import android.content.res.Configuration
import com.omyrobin.component.common.services.IModuleInit

/**
 * @Author: wubo
 * @CreateDate: 2022/2/24 10:51 上午
 * @Description:
 */
class ModuleLoginInit: IModuleInit {

    override fun attachBaseContext(base: Context?) {
    }

    override fun onCreate() {
        println("========ModuleLogin 模块onCreate()========")
    }

    override fun onLowMemory() {
    }

    override fun onTrimMemory(level: Int) {
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
    }

    override fun getPriority(): Int {
        return 2
    }
}