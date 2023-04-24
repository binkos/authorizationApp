package com.uladzislau_pravalenak.authorizationapp.signIn.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.uladzislau_pravalenak.authorization.core.ui.input.EmailInputField
import com.uladzislau_pravalenak.authorization.core.ui.input.PasswordInputField
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model.SignInAction
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model.SignInEvent
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model.SignInState
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Composable
fun SignInScreen() {
    val viewModel: SignInViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val navigator = LocalNavigator.currentOrThrow

    LaunchedEffect(key1 = Unit) {
        viewModel.actions.collect { action ->
            when (action) {
                is SignInAction.NavigateToMainFlow -> {
                    navigator.navigate(AppFlowRoutes.MAIN_FLOW.name) {
                        popUpTo(AppFlowRoutes.SIGN_IN.name) { inclusive = true }
                    }
                }
                is SignInAction.NavigateToSignUpFlow -> {
                    navigator.navigate(AppFlowRoutes.SIGN_UP.name)
                }
                is SignInAction.ShowErrorDialog -> {
                }
            }
        }
    }

    SignInScreenUI(state, viewModel::sendEvents)
}


@Composable
private fun SignInScreenUI(
    state: SignInState,
    onEvent: (SignInEvent) -> Unit
) {
    val focusManager = LocalFocusManager.currentOrThrow

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(modifier = Modifier.padding(top = 8.dp), text = "Welcome")
        Text(modifier = Modifier.padding(top = 8.dp), text = "Sign in to Continue")

        Spacer(modifier = Modifier.weight(0.3f))
        EmailInputField(
            modifier = Modifier.padding(top = 8.dp),
            value = state.email,
            onValueChange = { onEvent(SignInEvent.EmailChanged(it)) },
            error = state.emailError,
            imeAction = ImeAction.Next,
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
        PasswordInputField(
            modifier = Modifier.padding(top = 8.dp),
            value = state.password,
            onValueChange = { onEvent(SignInEvent.PasswordChanged(it)) },
            error = state.passwordError,
            imeAction = ImeAction.Done,
            onDone = { onEvent(SignInEvent.SignInButtonClicked) }
        )

        Spacer(modifier = Modifier.weight(0.3f))

        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = state.isSignInButtonEnabled,
            onClick = { onEvent(SignInEvent.SignInButtonClicked) }
        ) {
            Text(text = "Sign In")
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            onClick = { onEvent(SignInEvent.SignUpButtonClicked) }
        ) {
            Text(text = "Sign Up")
        }

        Spacer(modifier = Modifier.weight(1.5f))
    }
}


@Composable
@Preview
fun SignInPreview() {
    AuthorizationAppTheme {
        Surface {
            SignInScreenUI(state = SignInState(), onEvent = {})
        }
    }
}