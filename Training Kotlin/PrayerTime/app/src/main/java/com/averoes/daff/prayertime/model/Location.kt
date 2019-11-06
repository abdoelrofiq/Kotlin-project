package com.averoes.daff.prayertime.model

import com.google.gson.annotations.SerializedName

data class Location(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)