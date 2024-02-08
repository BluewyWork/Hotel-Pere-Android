package com.intermodular.hotel.presentation.screens.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.domain.GetAuthenticatedGuestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getAuthenticatedGuestUseCase: GetAuthenticatedGuestUseCase
) : ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _surname = MutableLiveData<String>()
    val surname: LiveData<String> = _surname

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onUsernameChange(name: String) {
        _name.postValue(name)
    }

    fun onLastNameChange(surname: String) {
        _surname.postValue(surname)
    }

    fun onEmailChange(email: String) {
        _email.postValue(email)
    }

    fun onCreate() {
        viewModelScope.launch {
            val result = getAuthenticatedGuestUseCase() ?: return@launch

            _name.postValue(result.name)
            _surname.postValue(result.surname)
            _email.postValue(result.email)
        }
    }

    fun onUpdatePress() {
        TODO()
    }
}