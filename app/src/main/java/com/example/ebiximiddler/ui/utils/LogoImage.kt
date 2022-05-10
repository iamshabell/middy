package com.example.ebiximiddler.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun LogoImage(image: Int, modifier: Modifier){
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = modifier
    )
}

