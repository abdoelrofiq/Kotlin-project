package com.averoes.daff.prayertime.model

import com.google.gson.annotations.SerializedName

data class Time(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("time")
	val time: String? = null
)