package com.averoes.daff.notedailyapp.network

import com.averoes.daff.notedailyapp.model.ResponseInsert
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by daff on 14/03/19 at 11:50.
 */
interface ApiService {

    @GET("showNote.php")
    fun getNote() : Call<ResponseInsert>

    @FormUrlEncoded
    @POST("tambahNote.php")

    fun tambahNote(

        @Field("date_note") date: String,
        @Field("title_note") title : String,
        @Field("note") note :String
    ) : Call<ResponseInsert>
}