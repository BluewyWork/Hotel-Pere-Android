package com.intermodular.hotel.profile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.profile.domain.GetUserProfileUseCase
import com.intermodular.hotel.profile.domain.UpdateUserProfileUseCase
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _lastname = MutableLiveData<String>()
    val lastname: LiveData<String> = _lastname

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> = _phoneNumber

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onUsernameChange(username: String) {
        _username.postValue(username)
    }

    fun onLastNameChange(lastName: String) {
        _lastname.postValue(lastName)
    }

    fun onPhoneNumberChange(phoneNumber: String) {
        _phoneNumber.postValue(phoneNumber)
    }

    fun onEmailChange(email: String) {
        _email.postValue(email)
    }

    fun onCreate() {
        viewModelScope.launch {
            val getUserProfileUseCase = GetUserProfileUseCase()

            val username = getUserProfileUseCase.getUsername()
            val lastName = getUserProfileUseCase.getLastName()
            val phoneNumber = getUserProfileUseCase.getPhoneNumber()
            val email = getUserProfileUseCase.getEmail()

            _username.postValue(username)
            _lastname.postValue(lastName)
            _phoneNumber.postValue(phoneNumber)
            _email.postValue(email)
        }
    }

    fun onUpdatePress() {
        viewModelScope.launch {
            val updateUserProfileUseCase = UpdateUserProfileUseCase()

            val username = _username.value
            val lastName = _lastname.value
            val phoneNumber = _phoneNumber.value
            val email = _email.value


            if (username.isNullOrBlank() || lastName.isNullOrBlank() || phoneNumber.isNullOrBlank() || email.isNullOrBlank()) {
                return@launch
            }

            updateUserProfileUseCase.updateProfile(username, lastName, phoneNumber, email)
        }
    }
}