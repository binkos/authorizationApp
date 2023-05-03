package com.pracel.authorizationapp.home.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class Account(
    val icon: ImageVector,
    val value: String,
    val type: String,
    val color: Color
)

