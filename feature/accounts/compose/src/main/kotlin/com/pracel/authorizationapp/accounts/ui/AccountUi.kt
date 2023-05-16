package com.pracel.authorizationapp.accounts.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pracel.authorizationapp.accounts.api.model.AccountModel
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme

@Composable
internal fun AccountUi(modifier: Modifier = Modifier, account: AccountModel) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            Modifier
                .background(account.color)
                .padding(16.dp)
                .size(width = 140.dp, height = 100.dp)
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = account.icon,
                contentDescription = "Account Icon"
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = account.value,
                fontSize = 18.sp,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = account.type,
                fontSize = 12.sp,
                color = MaterialTheme.colors.secondaryVariant,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun AccountUiPreview() {
    AuthorizationAppTheme {
        Surface {
            AccountUi(
                account = AccountModel(Icons.Filled.CreditCard, "$35 000", "Cash($)", Color.Gray)
            )
        }
    }
}