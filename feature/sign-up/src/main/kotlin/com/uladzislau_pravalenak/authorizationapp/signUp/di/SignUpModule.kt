package com.uladzislau_pravalenak.authorizationapp.signUp.di

import com.uladzislau_pravalenak.authorizationapp.signUp.domain.repository.SignUpRepository
import com.uladzislau_pravalenak.authorizationapp.signUp.data.repository.SignUpRepositoryImpl
import com.uladzislau_pravalenak.authorizationapp.signUp.domain.validator.DefaultProfileValidator
import com.uladzislau_pravalenak.authorizationapp.signUp.domain.validator.ProfileValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal interface SignUpModule {

    @Binds
    @ViewModelScoped
    fun bindsSignUpRepository(impl: SignUpRepositoryImpl): SignUpRepository

    @Binds
    @ViewModelScoped
    fun bindsProfileValidator(impl: DefaultProfileValidator): ProfileValidator
}