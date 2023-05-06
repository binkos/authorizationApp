package com.pracel.authorizationapp.transactions.api.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class TransactionModel(
    val icon: ImageVector = Icons.Default.Face,
    val category: String = "",
    val source: String = "",
    val value: String = ""
)