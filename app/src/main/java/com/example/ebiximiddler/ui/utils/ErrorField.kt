package com.example.ebiximiddler.ui.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun ErrorField(error: String) {
    Text(
        text = error,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(color = Color.Red)
    )
}