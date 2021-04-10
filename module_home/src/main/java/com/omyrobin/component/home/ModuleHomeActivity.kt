package com.omyrobin.component.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.omyrobin.route_annotation.Route

/**
 * @Author: omyrobin
 * @CreateDate: 2020/12/30 7:49 PM
 * @Description:
 */
@Route(path = "module_home/ModuleHomeActivity")
class ModuleHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_home_activity_main)
    }
}