package com.uladzislau_pravalenak.authorizationapp.signUp.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uladzislau_pravalenak.authorizationapp.signUp.domain.repository.SignUpRepository
import com.uladzislau_pravalenak.authorizationapp.signUp.domain.validator.ProfileValidator
import com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model.SignUpAction
import com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model.SignUpEvent
import com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: SignUpRepository,
    private val profileValidator: ProfileValidator
) : ViewModel() {

    val state: MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState())
    val actions: MutableSharedFlow<SignUpAction> = MutableSharedFlow()

    fun sendEvents(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.EmailChanged -> {
                val isEnabled =
                    profileValidator.validateEmail(event.value) &&
                            profileValidator.validatePassword(state.value.password)

                state.value = state.value.copy(
                    email = event.value,
                    isSignInButtonEnabled = isEnabled
                )
            }
            is SignUpEvent.PasswordChanged -> {
                val isEnabled =
                    profileValidator.validateEmail(state.value.email) &&
                            profileValidator.validatePassword(event.value)

                state.value = state.value.copy(
                    password = event.value,
                    isSignInButtonEnabled = isEnabled
                )
            }
            SignUpEvent.SignUpButtonClicked -> {
                viewModelScope.launch {
                    runCatching {
                        repository.signUp(state.value.email, state.value.password)
                    }
                        .getOrNull()
                        ?.let { actions.emit(SignUpAction.NavigateToSignIn) }
                }
            }
        }
    }
}