package com.example.ebiximiddler.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ebiximiddler.NavRoutes
import com.example.ebiximiddler.PhoneState
import com.example.ebiximiddler.ui.utils.*

@Composable
fun SignupScreen(logo: Int, NavController: NavHostController) {
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
                    Title(text = "Registration")
                    Spacer(modifier = Modifier.height(15.dp))
                    RegistrationScreen(
                        onClickLogIn = { NavController.navigate(NavRoutes.Login.route) })
                }
            }

        }
    }
}

@Composable
fun RegistrationScreen(onClickLogIn: () -> Unit) {
    val context = LocalContext.current
    val phoneState = remember { PhoneState() }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        RegisterTextField(phoneState = phoneState)
        phoneState.error?.let { ErrorField(it) }

        Spacer(modifier = Modifier.height(35.dp))

        RegisterButton(context, phoneState)

        Spacer(modifier = Modifier.height(55.dp))

        LogIn(LogInClick = onClickLogIn)
    }
}

@Composable
fun RegisterTextField(phoneState: PhoneState) {
    val name = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = name.value,
        onValueChange = {
            name.value = it
        },
        singleLine = true,
        label = { Text(text = "Name") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = ""
            )
        }
    )
    Spacer(modifier = Modifier.height(15.dp))
    TextField(phoneState)

}

@Composable
fun RegisterButton(context: Context, phoneState: PhoneState, ) {
    CustomButton(context = context, phoneState = phoneState, text = "Register")
}

@Composable
fun LogIn(LogInClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        TextButton(onClick = LogInClick) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}