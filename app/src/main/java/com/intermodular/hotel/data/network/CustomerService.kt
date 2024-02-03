package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.CustomerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CustomerService @Inject constructor(private val api: UserApiClient) {
    suspend fun getUser(): List<CustomerModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getUser()
            response.body() ?: emptyList()
        }
    }
}
