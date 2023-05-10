package com.uladzislau_pravalenak.authorizationapp.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uladzislau_pravalenak.authorizationapp.shared.startDestionation.domain.StartDestinationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    repository: StartDestinationRepository
) : ViewModel() {

    val destinationSharedFlow: SharedFlow<String> =
        repository.startDestination.shareIn(viewModelScope, SharingStarted.WhileSubscribed())
}