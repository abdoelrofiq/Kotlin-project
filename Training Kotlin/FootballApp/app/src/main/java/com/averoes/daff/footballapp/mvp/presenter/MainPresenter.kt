package com.averoes.daff.footballapp.mvp.presenter

import android.provider.Contacts
import com.averoes.daff.footballapp.mvp.model.ResponseLeague
import com.averoes.daff.footballapp.mvp.view.MainView
import com.isoneday.footballappapi.network.InitRetrofit
import com.isoneday.footballappapi.network.RestApi
import retrofit2.Call
import retrofit2.Response

/**
 * Created by daff on 19/03/19 at 11:08.
 */
class MainPresenter (private  val view: MainView) {

    fun getLastMatch(IdLeague : Int){
        view.showLoading()
        val api: RestApi = InitRetrofit.getInstance()
        api.getLastMatch(IdLeague).enqueue(object : retrofit2.Callback<ResponseLeague>{
            override fun onFailure(call: Call<ResponseLeague>, t: Throwable) {

                view.hideLoading()
                view.errorMessage(t.localizedMessage.toString())
            }

            override fun onResponse(call: Call<ResponseLeague>, response: Response<ResponseLeague>) {

                view.hideLoading()
                val datalist = response.body()?.events
                view.showListItem(datalist)
                view.showMessage("Success to show data")
            }
        })
    }
    fun getNextMatch(IdLeague : Int){
        view.showLoading()
        val api: RestApi = InitRetrofit.getInstance()
        api.getNextMatch(IdLeague).enqueue(object : retrofit2.Callback<ResponseLeague>{

            override fun onFailure(call: Call<ResponseLeague>, t: Throwable) {

                view.hideLoading()
                view.errorMessage(t.localizedMessage.toString())
            }

            override fun onResponse(call: Call<ResponseLeague>, response: Response<ResponseLeague>) {

                view.hideLoading()
                val datalist = response.body()?.events
                view.showListItem(datalist)
                view.showMessage("Success to show data")
            }
        })
    }

}