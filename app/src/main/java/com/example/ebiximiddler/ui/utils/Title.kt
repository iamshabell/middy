package com.example.ebiximiddler.ui.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Title(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}