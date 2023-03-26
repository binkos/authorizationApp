package com.uladzislau_pravalenak.authorizationapp.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Stable

@Stable
data class PageInfo(
    @DrawableRes
    val iconDrawableRes: Int,
    @StringRes
    val textStringRes: Int
)
