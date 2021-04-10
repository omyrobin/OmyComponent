package com.omyrobin.component

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.omyrobin.route_annotation.Route
import com.omyrobin.route_api.Orouter

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


}