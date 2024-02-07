package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.CustomerModel
import com.intermodular.hotel.data.model.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CustomerService @Inject constructor(private val customerApi: CustomerApiClient) {
    suspend fun getAuthenticatedCustomerFromApi(): CustomerModel? {
        return withContext(Dispatchers.IO) {
            try {
                val response = customerApi.getOneCustomer()
                response.body()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
            null
        }
    }

    suspend fun loginCustomerFromApi(loginModel: LoginModel): String {
        return try {
            withContext(Dispatchers.IO) {
                val response = customerApi.loginCustomer(loginModel)

                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null && loginResponse.ok) {
                        loginResponse.data
                    } else {
                        ""
                    }
                } else {
                    ""
                }
            }
        } catch (e: Exception) {
            Log.e("LOOK AT ME", "${e.message}")
            ""
        }
    }
}
