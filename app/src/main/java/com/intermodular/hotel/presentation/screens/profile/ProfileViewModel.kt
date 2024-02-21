package com.intermodular.hotel.presentation.screens.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.intermodular.hotel.core.navigations.Destinations
import com.intermodular.hotel.domain.DeleteGuestUseCase
import com.intermodular.hotel.domain.GetAuthenticatedGuestUseCase
import com.intermodular.hotel.domain.GuestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getAuthenticatedGuestUseCase: GetAuthenticatedGuestUseCase,
    private val guestUseCase: GuestUseCase,
    private val deleteGuestUseCase: DeleteGuestUseCase
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

    fun loadData(navController: NavController) {
        viewModelScope.launch {
            val loggedIn = guestUseCase.isLoggedIn()

            if (!loggedIn) {
                navController.navigate(Destinations.Login.route)
            }

            val guest = getAuthenticatedGuestUseCase() ?: return@launch

            _name.postValue(guest.name)
            _surname.postValue(guest.surname)
            _email.postValue(guest.email)
        }
    }

    fun onUpdatePress() {
        TODO()
    }

    fun onDeleteAccountPress(navController: NavController) {
        viewModelScope.launch {
            if(deleteGuestUseCase.deleteGuest()) {
                navController.navigate(Destinations.Login.route)
            }
        }
    }
}