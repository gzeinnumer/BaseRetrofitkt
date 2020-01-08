package com.gzeinnumer.baseretrofitkt.network

import com.gzeinnumer.baseretrofitkt.base.BaseObjectResponse
import com.gzeinnumer.baseretrofitkt.base.BaseListResponse
import com.gzeinnumer.baseretrofitkt.model.DataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    fun categoriesObject(): Call<BaseObjectResponse<DataItem>>

    @GET("categories.php")
    fun categoriesList(): Call<BaseListResponse<DataItem>>
}