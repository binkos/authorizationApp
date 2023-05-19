package com.uladzislau_pravalenak.authorizationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme
import com.uladzislau_pravalenak.authorizationapp.navhost.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        //TODO default implementation brakes logic of transparent system bars
//        splashScreen.setOnExitAnimationListener { splashScreenView ->
//            // Create your custom animation.
//            val slideUp = ObjectAnimator.ofFloat(
//                splashScreenView.view,
//                View.TRANSLATION_Y,
//                0f,
//                -splashScreenView.view.height.toFloat()
//            )
//
//            slideUp.interpolator = AnticipateInterpolator()
//            slideUp.duration = 200L
//
//            // Call SplashScreenView.remove at the end of your custom animation.
//            slideUp.doOnEnd { splashScreenView.remove() }
//
//            // Run your animation.
//            slideUp.start()
//        }
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AuthorizationAppTheme {
                Surface {
                    AppNavHost(modifier = Modifier.statusBarsPadding())
                }
            }
        }
    }
}