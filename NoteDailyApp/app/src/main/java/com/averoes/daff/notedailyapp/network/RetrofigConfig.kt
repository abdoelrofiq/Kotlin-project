package com.averoes.daff.notedailyapp.network

import com.averoes.daff.notedailyapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by daff on 14/03/19 at 11:22.
 */
class RetrofigConfig {

    fun getRetrofit(): Retrofit =

         Retrofit.Builder()
            .baseUrl(BuildConfig.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getInstance() :ApiService =
         getRetrofit().create(ApiService::class.java)

}