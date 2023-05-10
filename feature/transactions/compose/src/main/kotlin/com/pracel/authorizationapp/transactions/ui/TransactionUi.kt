package com.pracel.authorizationapp.transactions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pracel.authorizationapp.transactions.api.model.TransactionModel

@Composable
internal fun TransactionUi(
    modifier: Modifier = Modifier,
    transactionModel: TransactionModel
) {
    Row(
        modifier = modifier
            .height(40.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = transactionModel.icon,
                contentDescription = "transaction icon"
            )
        }
        Column(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = transactionModel.category,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
            )
            Text(
                modifier = Modifier,
                fontSize = 12.sp,
                text = transactionModel.source,
                color = Color.DarkGray,
            )
        }

        Text(text = transactionModel.value)
    }
}