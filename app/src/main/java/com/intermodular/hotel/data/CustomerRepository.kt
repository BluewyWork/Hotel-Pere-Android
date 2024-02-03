package com.intermodular.hotel.data

import com.intermodular.hotel.data.database.dao.CustomerDao
import com.intermodular.hotel.data.database.entities.CustomerEntity
import com.intermodular.hotel.data.model.CustomerModel
import com.intermodular.hotel.data.network.CustomerService
import com.intermodular.hotel.domain.model.Customer
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject

class CustomerRepository @Inject constructor(
    private val api: CustomerService,
    private val customerDao: CustomerDao
) {
    suspend fun getCustomerFromApi(): List<Customer> {
        val response: List<CustomerModel> = api.getUser()
        return response.map { it.toDomain() }
    }

    suspend fun getCustomerFromDataBase(): List<Customer> {
        val response: List<CustomerEntity> = customerDao.getUser()
        return response.map { it.toDomain() }
    }

    suspend fun insertCustomer(users: List<CustomerEntity>) {
        customerDao.insertAll(users)
    }

    suspend fun clearCustomer() {
        customerDao.clearCustomer()
    }
}