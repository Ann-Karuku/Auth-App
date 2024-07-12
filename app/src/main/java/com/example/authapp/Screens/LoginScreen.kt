package com.example.authapp.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authapp.Components.NormalTextComponents
import com.example.authapp.Components.TextFieldComponents
import com.example.authapp.R

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    onSwitchRoleClick: () -> Unit,
    onSwitchScreen: () -> Unit,
    isUserLogin: Boolean,
    isLoginScreen: Boolean
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = if (isUserLogin) "User Login" else "Admin Login", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(18.dp))

            TextFieldComponents(labelValue = stringResource(id = R.string.email))

            Spacer(modifier = Modifier.height(16.dp))


            TextFieldComponents(labelValue = stringResource(id = R.string.pass))

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onLoginClick(email, password) },
                modifier = Modifier.width(150.dp)
            ) {
                Text(text = "Login")
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = onSwitchRoleClick) {
                Text(if (isUserLogin) "Switch to Admin Login" else "Switch to User Login")
            }
            TextButton(onClick = onSwitchScreen) {
                Text(if (isLoginScreen) "Don't have an account?SignUp" else "Have an account?SignUp")
            }

            TextButton(onClick = { /* Handle Forgot Password */ }) {
               Text(text = "Forgot Password?")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginClick = { email, password -> /* Handle login logic here */ },
        onSwitchRoleClick = { /* Handle switch role logic here */ },
        onSwitchScreen = { /* Handle switch screen logic here */ },
        isUserLogin = true,
        isLoginScreen = true
    )
}

