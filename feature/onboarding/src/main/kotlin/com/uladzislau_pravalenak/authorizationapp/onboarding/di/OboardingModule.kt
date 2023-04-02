package com.uladzislau_pravalenak.authorizationapp.onboarding.di

import com.uladzislau_pravalenak.authorizationapp.onboarding.data.StartDestinationRepository
import com.uladzislau_pravalenak.authorizationapp.onboarding.data.StartDestinationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
internal interface OboardingModule {

    @Binds
    @ViewModelScoped
    fun bindsStartDestinationRepository(impl: StartDestinationRepositoryImpl): StartDestinationRepository
}