package com.app.mybaseapp.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mybaseapp.models.user_details.UserDetailsResponse
import com.app.mybaseapp.repository.app_repository.AppRepository
import com.app.mybaseapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
     private val repository: AppRepository
):ViewModel(){

     private val _userDetailsFlow:MutableStateFlow<NetworkResult<UserDetailsResponse?>> = MutableStateFlow(NetworkResult.Loading)
     val userDetailsFlow:StateFlow<NetworkResult<UserDetailsResponse?>> = _userDetailsFlow

     fun fetchUserDetails(id:Int) = viewModelScope.launch(Dispatchers.IO){
          _userDetailsFlow.value = NetworkResult.Loading
          viewModelScope.launch {
               val result = repository.fetchUserDetails(id)
               _userDetailsFlow.emit(result)
          }
     }
}