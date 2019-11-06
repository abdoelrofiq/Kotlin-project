package com.averoes.daff.prayertime.model

import com.google.gson.annotations.SerializedName

data class ResponseCity(

	@field:SerializedName("debug")
	val debug: Debug? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("time")
	val time: Time? = null,

	@field:SerializedName("status")
	val status: String? = null
)