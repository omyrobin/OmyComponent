package com.omyrobin.component.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.omyrobin.component.login.R
import com.omyrobin.route_annotation.Route

/**
 * @Author: omyrobin
 * @CreateDate: 2020/12/30 7:57 PM
 * @Description:
 */
@Route(path = "module_login/ModuleLoginActivity")
class ModuleLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_login_activity_main)
    }
}