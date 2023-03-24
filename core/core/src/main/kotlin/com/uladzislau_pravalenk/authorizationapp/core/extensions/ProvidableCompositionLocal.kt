package com.uladzislau_pravalenk.authorizationapp.core.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal

val <T>ProvidableCompositionLocal<T>.currentOrThrow
    @Composable
    get() = requireNotNull(current) { "CompositionLocal is null" }