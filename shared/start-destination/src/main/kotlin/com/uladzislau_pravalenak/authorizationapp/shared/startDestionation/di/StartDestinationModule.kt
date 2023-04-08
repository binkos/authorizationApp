package com.uladzislau_pravalenak.authorizationapp.shared.startDestionation.di

import com.uladzislau_pravalenak.authorizationapp.shared.startDestionation.data.StartDestinationRepositoryImpl
import com.uladzislau_pravalenak.authorizationapp.shared.startDestionation.domain.StartDestinationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal interface StartDestinationModule {

    @Binds
    @ViewModelScoped
    fun bindsStartDestinationRepository(impl: StartDestinationRepositoryImpl): StartDestinationRepository
}