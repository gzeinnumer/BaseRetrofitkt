package com.gzeinnumer.baseretrofitkt.base

import androidx.lifecycle.MutableLiveData
import com.gzeinnumer.baseretrofitkt.model.DataItem
import com.gzeinnumer.baseretrofitkt.network.handling.MyResource

interface BaseRepositoryApiCall{
    fun getCategoriesObject(): MutableLiveData<MyResource<BaseObjectResponse<DataItem>>>
    fun getCategoriesList(): MutableLiveData<MyResource<BaseListResponse<DataItem>>>
}