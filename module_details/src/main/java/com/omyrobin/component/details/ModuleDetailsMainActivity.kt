package com.omyrobin.component.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.omyrobin.route_annotation.Route

/**
 * @Author: omyrobin
 * @CreateDate: 2020/12/30 7:49 PM
 * @Description:
 */
@Route(path = "module_details/ModuleDetailsMainActivity")
class ModuleDetailsMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_details_activity_main)
    }
}