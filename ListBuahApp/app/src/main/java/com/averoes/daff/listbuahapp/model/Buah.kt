package com.averoes.daff.listbuahapp.model

/**
 * Created by daff on 06/03/19 at 14:14.
 */
class Buah{
    var id:Int? = null
    var nama_buah:String? = null
    var gambar_buah:Int = 0

    fun getNamaBuah():String{
        return nama_buah.toString()
    }

    fun setNamaBUah(name: String) {
        this.nama_buah = name
    }

    fun getGambarBua(): Int {
        return gambar_buah
    }

    fun setGambarBuah(image_drawable: Int) {
        this.gambar_buah = image_drawable
    }
}