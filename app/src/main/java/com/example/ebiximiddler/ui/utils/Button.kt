package com.example.ebiximiddler.ui.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ebiximiddler.PhoneState

@Composable
fun CustomButton(context: Context, phoneState: PhoneState, text: String) {
    Button(
        onClick = {

            Toast.makeText(
                context,
                "Logged In Succeddfully",
                Toast.LENGTH_SHORT
            ).show()

        },
        enabled = phoneState.isValid() && phoneState.text.length === 9,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.16f),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(text = text)
    }
}