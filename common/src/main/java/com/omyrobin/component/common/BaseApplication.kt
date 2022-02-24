package com.omyrobin.component.common

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.omyrobin.component.common.services.IModuleInit
import com.omyrobin.router_api.Orouter
import java.util.*

/**
 * @Author: omyrobin
 * @CreateDate: 2021/1/4 7:40 PM
 * @Description:
 */
open class BaseApplication : Application() {

    val services = ServiceLoader.load(IModuleInit::class.java)

    init {
        services.sortedBy { it.getPriority() }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        services.forEach{ it.attachBaseContext(base) }
    }

    override fun onCreate() {
        super.onCreate()
        Orouter.getInstance().init(this)
        println("========Common Application onCreate()=========")
        services.forEach{ it.onCreate() }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        services.forEach{ it.onLowMemory() }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        services.forEach{ it.onTrimMemory(level) }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        services.forEach{ it.onConfigurationChanged(newConfig) }
    }
}