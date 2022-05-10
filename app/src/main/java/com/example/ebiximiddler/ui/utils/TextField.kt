package com.example.ebiximiddler.ui.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.ebiximiddler.PhoneState

@Composable
fun TextField(phoneState: PhoneState) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = phoneState.text,
        onValueChange = {
            if (it.length <= 9) phoneState.text = it
            phoneState.validate()
        },
        isError = phoneState.error != null,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        label = { Text(text = "Phone") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = ""
            )
        }
    )
}