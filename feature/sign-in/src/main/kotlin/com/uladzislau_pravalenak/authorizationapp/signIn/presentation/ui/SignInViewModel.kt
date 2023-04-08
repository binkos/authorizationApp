package com.uladzislau_pravalenak.authorizationapp.signIn.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uladzislau_pravalenak.authorizationapp.signIn.domain.repository.SignInRepository
import com.uladzislau_pravalenak.authorizationapp.signIn.domain.validator.ProfileValidator
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model.SignInAction
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model.SignInEvent
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: SignInRepository,
    private val profileValidator: ProfileValidator
) : ViewModel() {

    val state: MutableStateFlow<SignInState> = MutableStateFlow(SignInState())
    val actions: MutableSharedFlow<SignInAction> = MutableSharedFlow()

    fun sendEvents(event: SignInEvent) {
        when (event) {
            is SignInEvent.EmailChanged -> {
                val isEnabled =
                    profileValidator.validateEmail(event.value) &&
                            profileValidator.validatePassword(state.value.password)

                state.value = state.value.copy(
                    email = event.value,
                    isSignInButtonEnabled = isEnabled
                )
            }
            SignInEvent.ForgotPasswordClicked -> {
                viewModelScope.launch {
                    actions.emit(SignInAction.NavigateToSignUpFlow)
                }
            }
            is SignInEvent.PasswordChanged -> {
                val isEnabled =
                    profileValidator.validateEmail(state.value.email) &&
                            profileValidator.validatePassword(event.value)

                state.value = state.value.copy(
                    password = event.value,
                    isSignInButtonEnabled = isEnabled
                )
            }
            SignInEvent.SignInButtonClicked -> {
                viewModelScope.launch {
                    runCatching {
                        repository.login(state.value.email, state.value.password)
                    }
                        .getOrNull()
                        ?.let { actions.emit(SignInAction.NavigateToMainFlow) }
                        ?: actions.emit(SignInAction.ShowErrorDialog)
                }
            }
        }
    }
}