package com.omyrobin.component

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //获取meta-data中channel的值
        val appInfo = this.packageManager
            .getApplicationInfo(
                packageName,
                PackageManager.GET_META_DATA
            )

        val msg = appInfo.metaData.getString("channel")

        tv_app.text = "App壳工程_${msg}"
    }

}