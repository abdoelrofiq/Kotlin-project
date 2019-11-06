package com.averoes.daff.prayertime.model

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("Sunset")
	val sunset: String? = null,

	@field:SerializedName("Asr")
	val asr: String? = null,

	@field:SerializedName("Isha")
	val isha: String? = null,

	@field:SerializedName("Fajr")
	val fajr: String? = null,

	@field:SerializedName("Dhuhr")
	val dhuhr: String? = null,

	@field:SerializedName("Maghrib")
	val maghrib: String? = null,

	@field:SerializedName("method")
	val method: List<String?>? = null,

	@field:SerializedName("TengahMalam")
	val tengahMalam: String? = null,

	@field:SerializedName("Sunrise")
	val sunrise: String? = null,

	@field:SerializedName("DuapertigaMalam")
	val duapertigaMalam: String? = null,

	@field:SerializedName("SepertigaMalam")
	val sepertigaMalam: String? = null
)