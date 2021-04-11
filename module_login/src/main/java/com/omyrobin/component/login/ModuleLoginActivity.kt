package com.omyrobin.component.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.omyrobin.component.login.R
import com.omyrobin.route_annotation.Route
import com.omyrobin.route_api.Orouter

/**
 * @Author: omyrobin
 * @CreateDate: 2020/12/30 7:57 PM
 * @Description:
 */
@Route(path = "module_login/ModuleLoginActivity")
class ModuleLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.let {
            title = "ModuleLoginActivity"
        }
        setContentView(R.layout.module_login_activity_main)
    }

    fun jumpHome(view: View){
        Orouter.getInstance().navigation( "module_home/ModuleHomeActivity")
    }

    fun jumpDetails(view: View){
        Orouter.getInstance().navigation("module_details/ModuleDetailsMainActivity")
    }
}