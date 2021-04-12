package com.omyrobin.component

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.omyrobin.router_annotation.Route
import com.omyrobin.router_api.Orouter

@Route(path = "app/MainActivity")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //获取meta-data中channel的值
//        val appInfo = this.packageManager
//            .getApplicationInfo(
//                packageName,
//                PackageManager.GET_META_DATA
//            )

//        val msg = appInfo.metaData.getString("channel")
//        val tv_app = findViewById<TextView>(R.id.tv_app)
//        tv_app.text = "App壳工程_${msg}"
    }

    fun jumpHome(view: View){
        Orouter.getInstance().navigation( "module_home/ModuleHomeActivity")
    }

    fun jumpDetails(view: View){
        Orouter.getInstance().navigation("module_details/ModuleDetailsMainActivity")
    }

    fun jumpLogin(view: View){
        Orouter.getInstance().navigation("module_login/ModuleLoginActivity")
    }



}