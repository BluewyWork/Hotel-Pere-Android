package com.intermodular.hotel.data.network

import com.intermodular.hotel.core.RetrofitHelper
import com.intermodular.hotel.data.model.CustomerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CustomerService @Inject constructor(private val api: CustomerApiClient) {
    suspend fun getCustomer(): CustomerModel? {
        return withContext(Dispatchers.IO) {
            val response = api.getOneCustomer()
            response.body()
        }
    }
}
