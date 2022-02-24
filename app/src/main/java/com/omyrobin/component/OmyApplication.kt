package com.omyrobin.component

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.omyrobin.component.common.BaseApplication
import com.omyrobin.router_api.Orouter


/**
 * @Author: omyrobin
 * @CreateDate: 2021/1/4 5:25 PM
 * @Description:
 */
class OmyApplication : BaseApplication(), Application.ActivityLifecycleCallbacks {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }


    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }


}