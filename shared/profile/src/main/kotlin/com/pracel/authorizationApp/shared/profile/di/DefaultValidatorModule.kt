package com.pracel.authorizationApp.shared.profile.di

import com.pracel.authorizationApp.shared.profile.validator.api.ProfileValidator
import com.pracel.authorizationApp.shared.profile.validator.impl.DefaultProfileValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface DefaultValidatorModule {

    @Binds
    fun DefaultProfileValidator.binds(): ProfileValidator
}