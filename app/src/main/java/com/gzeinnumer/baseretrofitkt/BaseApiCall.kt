package com.gzeinnumer.baseretrofitkt

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gzeinnumer.baseretrofitkt.base.BaseListResponse
import com.gzeinnumer.baseretrofitkt.base.BaseObjectResponse
import com.gzeinnumer.baseretrofitkt.model.DataItem
import com.gzeinnumer.baseretrofitkt.network.RetroServer
import com.gzeinnumer.baseretrofitkt.network.handling.MyResource
import com.gzeinnumer.baseretrofitkt.network.handling.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class BaseApiCall
fun getCategoriesObject(): MutableLiveData<MyResource<BaseObjectResponse<DataItem>>> {
    Log.d("MyZeinSistem", "BaseApiCall + getCategoriesObject")

    val list = MutableLiveData<MyResource<BaseObjectResponse<DataItem>>>()

    list.value = MyResource.showLoading(null)

    RetroServer.instance.categoriesObject().enqueue(object : Callback<BaseObjectResponse<DataItem>>{
        override fun onFailure(call: Call<BaseObjectResponse<DataItem>>, t: Throwable) {
            Log.d("MyZeinSistem", "BaseApiCall + getCategoriesObject + onFailure")
            list.value = MyResource.hideLoading(null)

            t.message?.let {
                Log.d("MyZein", it)
                list.postValue(MyResource.error(it, null))
            }
        }

        override fun onResponse(
            call: Call<BaseObjectResponse<DataItem>>,
            response: Response<BaseObjectResponse<DataItem>>
        ) {
            Log.d("MyZeinSistem", "BaseApiCall + getCategoriesObject + onResponse "+response.code())

            list.value = MyResource.hideLoading(null)
            when(response.code()){
                HTTP_1_200->{
                    response.body().let {
                        list.postValue(MyResource.success(it))
                    }
                }
                HTTP_2_201->{
                    list.postValue(MyResource.info("Berhasil ditambahkan atau diupdate"))
                }
                HTTP_3_204 ->{
                    //jika kosong
                    list.postValue(MyResource.empty("data kosong", null))
                }
                HTTP_4_401->{
                    list.postValue(MyResource.error("sessiberhakir", null))
                }
                HTTP_5_404->{
                    list.postValue(MyResource.error("url not found", null))
                }
                HTTP_6_500 ->{
                    list.postValue(MyResource.error("server error", null))
                }
                else ->{
                    list.postValue(MyResource.error("respon code"+response.code(), null))
                }
            }
        }
    })
    return list
}

fun getCategoriesList(): MutableLiveData<MyResource<BaseListResponse<DataItem>>> {
    Log.d("MyZeinSistem", "BaseApiCall + getCategoriesList")

    val list = MutableLiveData<MyResource<BaseListResponse<DataItem>>>()

    list.value = MyResource.showLoading(null)

    RetroServer.instance.categoriesList().enqueue(object : Callback<BaseListResponse<DataItem>>{
        override fun onFailure(call: Call<BaseListResponse<DataItem>>, t: Throwable) {
            Log.d("MyZeinSistem", "BaseApiCall + getCategoriesList + onFailure")
            list.value = MyResource.hideLoading(null)

            t.message?.let {
                Log.d("MyZein", it)
                list.postValue(MyResource.error(it, null))
            }
        }

        override fun onResponse(
            call: Call<BaseListResponse<DataItem>>,
            response: Response<BaseListResponse<DataItem>>
        ) {
            Log.d("MyZeinSistem", "BaseApiCall + getCategoriesList + onResponse "+response.code())

            list.value = MyResource.hideLoading(null)
            when(response.code()){
                HTTP_1_200->{
                    response.body().let {
                        list.postValue(MyResource.success(it))
                    }
                }
                HTTP_2_201->{
                    list.postValue(MyResource.info("Berhasil ditambahkan atau diupdate"))
                }
                HTTP_3_204 ->{
                    //jika kosong
                    list.postValue(MyResource.empty("data kosong", null))
                }
                HTTP_4_401->{
                    list.postValue(MyResource.error("sessiberhakir", null))
                }
                HTTP_5_404->{
                    list.postValue(MyResource.error("url not found", null))
                }
                HTTP_6_500 ->{
                    list.postValue(MyResource.error("server error", null))
                }
                else ->{
                    list.postValue(MyResource.error("respon code"+response.code(), null))
                }
            }
        }
    })
    return list
}