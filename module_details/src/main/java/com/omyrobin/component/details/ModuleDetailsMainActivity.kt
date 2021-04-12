package com.omyrobin.component.details

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
@Route(path = "module_details/ModuleDetailsMainActivity")
class ModuleDetailsMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.let {
            title = "ModuleDetailsMainActivity"
        }
        setContentView(R.layout.module_details_activity_main)
    }

    fun jumpLogin(view: View){
        Orouter.getInstance().navigation("module_login/ModuleLoginActivity")
    }

    fun jumpHome(view: View){
        Orouter.getInstance().navigation( "module_home/ModuleHomeActivity")
    }

}