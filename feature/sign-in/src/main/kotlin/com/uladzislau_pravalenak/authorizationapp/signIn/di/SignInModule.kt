package com.uladzislau_pravalenak.authorizationapp.signIn.di

import com.uladzislau_pravalenak.authorizationapp.signIn.domain.repository.SignInRepository
import com.uladzislau_pravalenak.authorizationapp.signIn.data.repository.SignInRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal interface SignInModule {

    @Binds
    @ViewModelScoped
    fun bindsSignInRepository(impl: SignInRepositoryImpl): SignInRepository
}