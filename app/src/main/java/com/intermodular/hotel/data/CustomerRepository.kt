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
    suspend fun getCustomerFromApi(): Customer? {
        val response: CustomerModel? = api.getCustomer()
        return response?.toDomain()
    }

    suspend fun getCustomerFromDataBase(): Customer? {
        val response: CustomerEntity? = customerDao.getCustomer()
        return response?.toDomain()
    }

    suspend fun insertCustomer(customer: CustomerEntity) {
        customerDao.insertAll(customer)
    }

    suspend fun clearCustomer() {
        customerDao.clearCustomer()
    }
}