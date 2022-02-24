package com.omyrobin.component.home

import com.omyrobin.component.common.services.HInterface

/**
 * @Author: wubo
 * @CreateDate: 2022/2/22 5:07 下午
 * @Description: 接口的具体实现
 */
class HImpl : HInterface {

    override fun getHomeData(): String {
        return "This is home data"
    }

}