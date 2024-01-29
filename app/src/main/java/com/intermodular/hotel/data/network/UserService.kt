package com.intermodular.hotel.data.network
import com.intermodular.hotel.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

class UserService  @Inject constructor(private val api:UserApiClient) {

    suspend fun getUser(): List<UserModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getUser()
            response.body() ?: emptyList()
        }
    }

}
