package com.example.eventmanagementapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.example.eventmanagementapp.data.model.User
import com.example.eventmanagementapp.repositories.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _registrationStatus = MutableLiveData<Result<FirebaseUser>>()
    val registrationStatus: LiveData<Result<FirebaseUser>> = _registrationStatus

    private val _saveUserStatus = MutableLiveData<Result<Unit>>()
    val saveUserStatus: LiveData<Result<Unit>> = _saveUserStatus

    fun registerUser(email: String, pass: String, displayName: String?) {
        viewModelScope.launch {
            // Initial loading state if desired (e.g., _registrationStatus.value = Resource.Loading())
            val registrationResult = authRepository.registerUser(email, pass)
            _registrationStatus.value = registrationResult // Post initial registration attempt status

            registrationResult.onSuccess { firebaseUser ->
                // If registration is successful, proceed to save user details
                val newUser = User(
                    userId = firebaseUser.uid,
                    email = email, // email from parameter, firebaseUser.email might be null initially for some providers
                    displayName = displayName,
                    profileImageUrl = null // Default to null or provide a default image URL
                )
                // Post loading for save user status
                // _saveUserStatus.value = Resource.Loading() // if using a Resource wrapper
                val saveResult = authRepository.saveUserDetails(newUser)
                _saveUserStatus.value = saveResult
            }.onFailure { exception ->
                // If registration failed, no need to try saving user details.
                // The failure is already posted to _registrationStatus.
                // Post a failure to _saveUserStatus as well, as the overall operation failed.
                _saveUserStatus.value = Result.failure(exception)
            }
        }
    }

    // LiveData for Login
    private val _loginStatus = MutableLiveData<Result<FirebaseUser>>()
    val loginStatus: LiveData<Result<FirebaseUser>> = _loginStatus

    fun loginUser(email: String, pass: String) {
        viewModelScope.launch {
            // Optional: Post a loading state to _loginStatus if you have a Resource wrapper for Loading/Success/Error
            // _loginStatus.value = Resource.Loading()
            val loginResult = authRepository.loginUser(email, pass)
            _loginStatus.value = loginResult
        }
    }

    // Logout methods will be added later
}
