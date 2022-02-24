package com.omyrobin.component.details

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omyrobin.component.common.services.HInterface
import com.omyrobin.router_annotation.Route
import com.omyrobin.router_api.Orouter
import java.util.*

/**
 * @Author: omyrobin
 * @CreateDate: 2020/12/30 7:49 PM
 * @Description:
 */
@Route(path = "module_details/ModuleDetailsMainActivity")
class ModuleDetailsMainActivity : AppCompatActivity() {

    var btn: Button? = null

    var tv: TextView? = null

    val model: ModuleDetailsViewModel by lazy {
        //这是老版本的获取方式
        ViewModelProvider.NewInstanceFactory().create(ModuleDetailsViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.let {
            title = "ModuleDetailsMainActivity"
        }
        setContentView(R.layout.module_details_activity_main)

        tv = findViewById(R.id.tv_home_data)
        btn = findViewById(R.id.btn_get_home)
        btn?.setOnClickListener {
            //返回迭代器，因为有可能这个接口有多个实现
            val loader = ServiceLoader.load(HInterface::class.java)
            val iterator = loader.iterator()
            if(iterator.hasNext()) {
                val impl = iterator.next()
                val data = impl.getHomeData()
                println(data)
                tv?.text = data
            }else {
                println("未找到服务提供者")
            }

            val clz = Class.forName("androidx.activity.ComponentActivity")

            val objects = clz.declaredClasses

            for (obj in objects) {
                println("当前Activity的内部类${obj}")
                val fields = obj.declaredFields
                for (field in fields) {
                    println("当前Activity的内部类的字段${field.name}")
                }
            }



        }
    }

    fun jumpLogin(view: View) {
        Orouter.getInstance().navigation("module_login/ModuleLoginActivity")
    }

    fun jumpHome(view: View) {
        Orouter.getInstance().navigation("module_home/ModuleHomeActivity")
    }

}