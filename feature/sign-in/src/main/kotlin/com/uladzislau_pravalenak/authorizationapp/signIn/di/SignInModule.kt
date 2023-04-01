package com.uladzislau_pravalenak.authorizationapp.signIn.di

import com.uladzislau_pravalenak.authorizationapp.signIn.domain.repository.SignInRepository
import com.uladzislau_pravalenak.authorizationapp.signIn.data.repository.SignInRepositoryImpl
import com.uladzislau_pravalenak.authorizationapp.signIn.domain.validator.DefaultProfileValidator
import com.uladzislau_pravalenak.authorizationapp.signIn.domain.validator.ProfileValidator
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

    @Binds
    @ViewModelScoped
    fun bindsProfileValidator(impl: DefaultProfileValidator): ProfileValidator
}