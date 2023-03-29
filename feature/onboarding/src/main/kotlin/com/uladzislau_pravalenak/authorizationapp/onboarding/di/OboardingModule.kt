package com.uladzislau_pravalenak.authorizationapp.onboarding.di

import com.uladzislau_pravalenak.authorizationapp.onboarding.data.OnboardingRepository
import com.uladzislau_pravalenak.authorizationapp.onboarding.data.OnboardingRepositoryImpl
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
    fun bindsOnboardingRepository(impl: OnboardingRepositoryImpl): OnboardingRepository
}