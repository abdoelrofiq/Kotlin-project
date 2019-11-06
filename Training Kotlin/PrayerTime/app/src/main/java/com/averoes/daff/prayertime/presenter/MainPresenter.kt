package com.averoes.daff.prayertime.presenter

import android.content.Context
import android.widget.Toast
import com.averoes.daff.prayertime.model.ResponseCity
import com.averoes.daff.prayertime.network.ConfigRetrofit
import com.averoes.daff.prayertime.network.RestApi
import com.averoes.daff.prayertime.view.MainView
import retrofit2.Call
import retrofit2.Response

/**
 * Created by daff on 20/03/19 at 6:48.
 */
class MainPresenter (val view:MainView) {
    val context :Context? =null
    fun getKota(cityName:String) {
        view.showLoading()
        val api: RestApi = ConfigRetrofit.getInstances()
        api.searchKota(cityName).enqueue(object : retrofit2.Callback<ResponseCity> {
            override fun onFailure(call: Call<ResponseCity>, t: Throwable) {
                view.hideLoading()
                view.errorMessage(t.localizedMessage.toString())
                Toast.makeText(context, "GAGAL", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseCity>, response: Response<ResponseCity>) {

                view.hideLoading()
                val timeList = response.body()?.data
                view.showListItem(timeList)
                view.showMessage("Succes to Show Time List")
                Toast.makeText(context, "Succes", Toast.LENGTH_SHORT).show()
            }
        })

    }
}