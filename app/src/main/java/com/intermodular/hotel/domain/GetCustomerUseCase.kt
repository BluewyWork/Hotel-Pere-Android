package com.intermodular.hotel.domain

import com.intermodular.hotel.data.CustomerRepository
import com.intermodular.hotel.domain.model.Customer
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(private val repository: CustomerRepository) {
    suspend operator fun invoke(): Customer? {
//        val customer = repository.getCustomerFromApi()
//
//        return if (customer != null) {
//            repository.clearCustomer()
//            repository.insertCustomer(customer.toDatabase())
//            customer
//        } else {
//            repository.getCustomerFromDataBase()
//        }
        return null
    }
}