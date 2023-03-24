package com.uladzislau_pravalenak.authorizationapp.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Composable
fun OnboardingScreen() {
    val navigator = LocalNavigator.currentOrThrow
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Click Button to navigate to Sign Up flow"
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = {
                navigator.navigate(AppFlowRoutes.SIGN_UP_FLOW.name) {
                    popUpTo(AppFlowRoutes.ONBOARDING.name) {
                        inclusive = true
                    }
                }
            }
        ) {
            Text(text = "Navigate to signup flow")
        }
    }
}