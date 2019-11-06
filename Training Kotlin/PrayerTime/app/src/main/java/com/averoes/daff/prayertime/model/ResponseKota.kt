package com.averoes.daff.prayertime.model

data class ResponseKota(
	val country: String? = null,
	val statusDescription: String? = null,
	val address: String? = null,
	val statusCode: Int? = null,
	val method: Int? = null,
	val prayerMethodName: String? = null,
	val city: String? = null,
	val timezone: String? = null,
	val query: String? = null,
	val latitude: String? = null,
	val jsonMemberFor: String? = null,
	val link: String? = null,
	val qiblaDirection: String? = null,
	val title: String? = null,
	val statusValid: Int? = null,
	val sealevel: String? = null,
	val countryCode: String? = null,
	val daylight: String? = null,
	val state: String? = null,
	val postalCode: String? = null,
	val items: List<ItemsItem?>? = null,
	val mapImage: String? = null,
	val longitude: String? = null
)
