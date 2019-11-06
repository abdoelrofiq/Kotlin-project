package com.averoes.daff.prayertime.network

import com.averoes.daff.prayertime.model.ItemsItem
import com.averoes.daff.prayertime.model.ResponseCity
import com.averoes.daff.prayertime.model.ResponseKota
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by daff on 20/03/19 at 7:31.
 */
interface RestApi {

    @GET("/pray/")
    fun searchKota(@Query("address") cityName: String): Call<ResponseCity>
}
