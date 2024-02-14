package com.intermodular.hotel.data.network.response

data class ApiResponse<T>(val data: T, val ok: Boolean)