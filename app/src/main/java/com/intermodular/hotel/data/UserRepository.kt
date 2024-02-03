package com.intermodular.hotel.data

import com.intermodular.hotel.data.database.dao.CustomerDao
import com.intermodular.hotel.data.database.entities.CustomerEntity
import com.intermodular.hotel.data.model.CustomerModel
import com.intermodular.hotel.data.network.UserService
import com.intermodular.hotel.domain.model.Customer
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val api: UserService,
    private val customerDao: CustomerDao
) {
    suspend fun getUserFromApi(): List<Customer> {
        val response: List<CustomerModel> = api.getUser()
        return response.map { it.toDomain() }
    }

    suspend fun getUserFromDataBase(): List<Customer> {
        val response: List<CustomerEntity> = customerDao.getUser()
        return response.map { it.toDomain() }

    }

    suspend fun insertUsers(users: List<CustomerEntity>) {
        customerDao.insertAll(users)
    }

    suspend fun clearUser() {
        customerDao.clearUser()
    }
}