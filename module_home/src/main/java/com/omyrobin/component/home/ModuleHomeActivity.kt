package com.omyrobin.component.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.omyrobin.router_annotation.Route
import com.omyrobin.router_api.Orouter

/**
 * @Author: omyrobin
 * @CreateDate: 2020/12/30 7:49 PM
 * @Description:
 */
@Route(path = "module_home/ModuleHomeActivity")
class ModuleHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.let {
            title = "ModuleHomeActivity"
        }
        setContentView(R.layout.module_home_activity_main)
    }

    fun jumpDetails(view: View){
        Orouter.getInstance().navigation("module_details/ModuleDetailsMainActivity")
    }

    fun jumpLogin(view: View){
        Orouter.getInstance().navigation("module_login/ModuleLoginActivity")
    }
}