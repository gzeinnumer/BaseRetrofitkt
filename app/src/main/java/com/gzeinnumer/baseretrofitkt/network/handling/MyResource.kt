package com.gzeinnumer.baseretrofitkt.network.handling

import android.util.Log

data class MyResource<out T>(val myStatus: MyStatus?, val data: T?, val message: String?) {
    companion object {
        fun <T> info(msg: String): MyResource<T> {
            Log.d("MyZeinSistem", "MyResource + info")
            return MyResource(MyStatus.SUCCESS, null, msg)
        }

        fun <T> success(data: T?): MyResource<T> {
            Log.d("MyZeinSistem", "MyResource + success")
            return MyResource(MyStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): MyResource<T> {
            Log.d("MyZeinSistem", "MyResource + error")
            return MyResource(MyStatus.ERROR, data, msg)
        }

        fun <T> showLoading(data: T?): MyResource<T> {
            Log.d("MyZeinSistem", "MyResource + showLoading")
            return MyResource(MyStatus.SHOWLOADING, data, null)
        }

        fun <T> hideLoading(data: T?): MyResource<T> {
            Log.d("MyZeinSistem", "MyResource + hideLoading")
            return MyResource(MyStatus.HIDELOADING, data, null)
        }

        fun <T> empty(msg: String, data: T?): MyResource<T> {
            Log.d("MyZeinSistem", "MyResource + empty")
            return MyResource(MyStatus.EMPTY, data, msg)
        }
    }
}
