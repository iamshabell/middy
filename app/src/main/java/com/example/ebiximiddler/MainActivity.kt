package com.example.ebiximiddler

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.navigation.compose.rememberNavController
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ebiximiddler.ui.SignInScreen
import com.example.ebiximiddler.ui.SignupScreen
import com.example.ebiximiddler.ui.theme.BTColor
import com.example.ebiximiddler.ui.theme.BTGColor
import com.example.ebiximiddler.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                MainScreen(R.drawable.logo)
            }

        }
    }
}

@Composable
fun MainScreen(logo: Int) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login.route
    ) {
        composable(
            NavRoutes.Login.route
        ) {
            SignInScreen(logo = logo, navController)
        }

        composable(
            NavRoutes.Registration.route
        ) {
            SignupScreen(logo = logo, navController)
        }
    }
}