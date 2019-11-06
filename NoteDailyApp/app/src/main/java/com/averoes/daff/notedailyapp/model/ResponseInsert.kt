package com.averoes.daff.notedailyapp.model

import com.google.gson.annotations.SerializedName

data class ResponseInsert(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null
)