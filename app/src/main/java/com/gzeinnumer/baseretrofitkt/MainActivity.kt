package com.gzeinnumer.baseretrofitkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.gzeinnumer.baseretrofitkt.network.handling.MyStatus

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MyZeinSistem", "MainActivity + onCreate")

        getCategoriesObject().observe(this, Observer {
            when(it.myStatus) {
                MyStatus.SHOWLOADING -> {
                    Log.d("MyZein", "Loading Object")
                }
                MyStatus.SUCCESS -> {
                    val item = it.data
                    //silahkan masukan ke cecyclerview
                    Log.d("MyZein", "Ukuran data Object "+item?.data?.name.toString())
                }
                MyStatus.ERROR -> {
                    it.message?.let{ it1 ->
                        Log.d("MyZein", "Error Object $it1")
                    }
                }
                MyStatus.HIDELOADING -> {
                    Log.d("MyZein", "Loading Object Hide")
                }
                MyStatus.EMPTY -> {
                    it.message?.let{ it1 ->
                        Log.d("MyZein", "Object $it1")
                    }
                }
                else -> {
                    it.message?.let{ it1 ->
                        Log.d("MyZein", "else Object $it1")
                    }
                }
            }
        })

        getCategoriesList().observe(this, Observer {
            when(it.myStatus) {
                MyStatus.SHOWLOADING -> {
                    Log.d("MyZein", "Loading List")
                }
                MyStatus.SUCCESS -> {
                    val itemList = it.data
                    //silahkan masukan ke cecyclerview
                    Log.d("MyZein", "SUCCESS List "+itemList?.data?.size.toString())
                }
                MyStatus.ERROR -> {
                    it.message?.let{ it1 ->
                        Log.d("MyZein", "ERROR List $it1")
                    }
                }
                MyStatus.HIDELOADING -> {
                    Log.d("MyZein", "LOADING List "+"Hide")
                }
                MyStatus.EMPTY -> {
                    it.message?.let{ it1 ->
                        Log.d("MyZein", "Kosong List $it1")
                    }
                }
                else -> {
                    it.message?.let{ it1 ->
                        Log.d("MyZein", "ELSE List $it1")
                    }
                }
            }
        })

    }
}
