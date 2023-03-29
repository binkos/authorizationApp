package com.uladzislau_pravalenak.authorizationapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.uladzislau_pravalenak.authorizationapp.navhost.AppNavHost
import com.uladzislau_pravalenak.authorizationapp.presentation.SplashScreenViewModel
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes
import com.uldazislau_pravalenak.authorizationapp.ui.theme.AuthorizationAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setOnExitAnimationListener { splashScreenView ->
            // Create your custom animation.
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView.view,
                View.TRANSLATION_Y,
                0f,
                -splashScreenView.view.height.toFloat()
            )

            slideUp.interpolator = AnticipateInterpolator()
            slideUp.duration = 200L

            // Call SplashScreenView.remove at the end of your custom animation.
            slideUp.doOnEnd { splashScreenView.remove() }

            // Run your animation.
            slideUp.start()
        }
        splashScreen.setKeepOnScreenCondition { viewModel.state.value.isEmpty() }
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val destination by viewModel.state.collectAsState()
            val startDestination = destination.ifEmpty { AppFlowRoutes.ONBOARDING.name }

            AuthorizationAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavHost(startDestination)
                }
            }
        }
    }
}