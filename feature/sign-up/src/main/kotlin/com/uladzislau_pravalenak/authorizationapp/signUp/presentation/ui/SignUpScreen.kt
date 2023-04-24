package com.uladzislau_pravalenak.authorizationapp.signUp.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model.SignUpAction
import com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model.SignUpEvent
import com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model.SignUpState
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Composable
fun SignUpScreen(
    onSignedUp: () -> Unit,
) {
    val viewModel: SignUpViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.actions.collect { action ->
            when (action) {
                is SignUpAction.NavigateToSignIn -> onSignedUp()
                is SignUpAction.ShowErrorDialog -> {}
            }
        }
    }

    SignUpScreenUI(state, viewModel::sendEvents)
}


@Composable
private fun SignUpScreenUI(
    state: SignUpState,
    onEvent: (SignUpEvent) -> Unit
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
        Text(modifier = Modifier.padding(top = 8.dp), text = "Create your own account")

        Spacer(modifier = Modifier.weight(0.3f))
        EmailInputField(
            modifier = Modifier.padding(top = 8.dp),
            value = state.email,
            onValueChange = { onEvent(SignUpEvent.EmailChanged(it)) },
            error = state.emailError,
            imeAction = ImeAction.Next,
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
        PasswordInputField(
            modifier = Modifier.padding(top = 8.dp),
            value = state.password,
            onValueChange = { onEvent(SignUpEvent.PasswordChanged(it)) },
            error = state.passwordError,
            imeAction = ImeAction.Done,
            onDone = { onEvent(SignUpEvent.SignUpButtonClicked) }
        )

        Spacer(modifier = Modifier.weight(0.3f))

        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = state.isSignInButtonEnabled,
            onClick = { onEvent(SignUpEvent.SignUpButtonClicked) }
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
            SignUpScreenUI(state = SignUpState(), onEvent = {})
        }
    }
}