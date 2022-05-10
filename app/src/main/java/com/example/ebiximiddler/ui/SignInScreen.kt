package com.example.ebiximiddler.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ebiximiddler.NavRoutes
import com.example.ebiximiddler.PhoneState
import com.example.ebiximiddler.ui.utils.*
import androidx.compose.ui.tooling.preview.Preview as Preview1


@Composable
fun SignInScreen(logo: Int, NavController: NavHostController) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            LogoImage(
                image = logo,
                modifier = Modifier
                    .weight(0.9f)
                    .size(158.dp),)

            Card(
                Modifier
                    .weight(2f),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Title(text = "Login")
                    Spacer(modifier = Modifier.height(15.dp))
                    LogInScreen(
                        onClickRegistration = { NavController.navigate(NavRoutes.Registration.route) })
                }
            }

        }
    }

}



@Composable
fun LogInScreen(onClickRegistration: () -> Unit) {
    val context = LocalContext.current
    val phoneState = remember { PhoneState() }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        LoginTextField(phoneState = phoneState)
        phoneState.error?.let { ErrorField(it) }

        Spacer(modifier = Modifier.height(35.dp))

        LoginButton(context, phoneState)

        Spacer(modifier = Modifier.height(55.dp))

        RegistrationAndForgot(RegisterClick = onClickRegistration)
    }
}

@Composable
fun LoginTextField(phoneState: PhoneState) {
    TextField(phoneState)
}

@Composable
fun LoginButton(context: Context, phoneState: PhoneState, ) {
    CustomButton(context = context, phoneState = phoneState, text = "Log In")
}

@Composable
fun RegistrationAndForgot(RegisterClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextButton(onClick = RegisterClick) {
            Text(
                text = "Register",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        }
        TextButton(onClick = {}) {
            Text(
                text = "Forgot Password?",
                color = Color.Gray,
            )
        }
    }
}

