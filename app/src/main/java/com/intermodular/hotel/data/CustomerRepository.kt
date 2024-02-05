package com.intermodular.hotel.data

import com.intermodular.hotel.data.database.dao.CustomerDao
import com.intermodular.hotel.data.database.entities.CustomerEntity
import com.intermodular.hotel.data.model.CustomerModel
import com.intermodular.hotel.data.network.CustomerService
import com.intermodular.hotel.domain.model.Customer
import com.intermodular.hotel.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CustomerRepository @Inject constructor(
    private val api: CustomerService,
    private val customerDao: CustomerDao
) {
    suspend fun getAuthenticatedCustomerFromApi(): Customer? {
        val response: CustomerModel? = api.getAuthenticatedCustomerFromApi()
        return response?.toDomain()
    }

    suspend fun getAuthenticatedCustomerFromDataBase(): Customer? {
        return withContext(Dispatchers.IO) {
            customerDao.getAuthenticatedCustomer()?.toDomain()
        }
    }

    suspend fun insertCustomer(customer: CustomerEntity) {
        customerDao.insertOne(customer)
    }

    suspend fun clearCustomer() {
        customerDao.clearAll()
    }
}