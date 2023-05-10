package com.uladzislau_pravalenak.authorization.core.ui.input

import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.uladzislau_pravalenak.authorization.core.ui.input.TextInputField

@Composable
fun EmailInputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    error: String,
    imeAction: ImeAction,
    isEnabled: Boolean = true,
    onNext: KeyboardActionScope.() -> Unit = {},
    onDone: KeyboardActionScope.() -> Unit = {}
) {
    TextInputField(
        modifier = modifier,
        isEnabled = isEnabled,
        title = "E-mail",
        hint = "Enter e-mail",
        onValueChange = onValueChange,
        value = value,
        errorText = error,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone,
            onNext = onNext
        )
    )
}