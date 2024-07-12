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
fun SignUpScreen(
    onSignUpClick: (String, String, String, String, String) -> Unit, // Updated the lambda to include first and last name
    onSwitchScreen: () -> Unit,
    isSignUpScreen: Boolean
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.hello))
            Spacer(modifier = Modifier.height(18.dp))
            Text(text = stringResource(id = R.string.sign_up), style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(18.dp))

           TextFieldComponents(labelValue = stringResource(id = R.string.first_name))

            Spacer(modifier = Modifier.height(16.dp))

            TextFieldComponents(labelValue = stringResource(id = R.string.last_name))

            Spacer(modifier = Modifier.height(16.dp))

            TextFieldComponents(labelValue = stringResource(id = R.string.email))

            Spacer(modifier = Modifier.height(16.dp))

            TextFieldComponents(labelValue = stringResource(id = R.string.pass))

            Spacer(modifier = Modifier.height(16.dp))

            TextFieldComponents(labelValue = stringResource(id = R.string.confirm_pass))

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onSignUpClick(firstName, lastName, email, password, confirmPassword) },
                modifier = Modifier.width(200.dp)

            ) {
                NormalTextComponents(value = stringResource(id = R.string.sign_up))
            }

            TextButton(onClick = onSwitchScreen) {
                Text(if (isSignUpScreen) "Have an account?Login" else "Don't have an account?SignUp")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewOfSignupScreen() {
    SignUpScreen(
        onSignUpClick = { firstName, lastName, email, password, confirmPassword -> /* Handle sign up logic here */ },
        onSwitchScreen = { /* Handle switch to login logic here */ },
        isSignUpScreen = true
    )
}
