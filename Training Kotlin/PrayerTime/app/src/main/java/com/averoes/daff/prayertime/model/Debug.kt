package com.averoes.daff.prayertime.model

import com.google.gson.annotations.SerializedName

data class Debug(

	@field:SerializedName("sunrise")
	val sunrise: String? = null,

	@field:SerializedName("sunset")
	val sunset: String? = null
)