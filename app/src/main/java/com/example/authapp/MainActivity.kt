package com.example.authapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.authapp.ui.theme.AuthAppTheme
import com.example.authapp.Screens.LoginScreen
import com.example.authapp.Screens.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthAppTheme {
                var isUserLogin by remember { mutableStateOf(true) }
                var isLoginScreen by remember { mutableStateOf(true) }
                var isSignUpScreen by remember { mutableStateOf(true) }

                if (!isLoginScreen) {
                    SignUpScreen(
                        onSignUpClick = { firstName, lastName, email, password, confirmPassword ->
                            // Handle sign up logic here
                        },
                        onSwitchScreen = {
                            isSignUpScreen = !isSignUpScreen
                        },
                        isSignUpScreen = isSignUpScreen
                    )
                } else {
                    LoginScreen(
                        onLoginClick = { email, password ->
                            // Handle login logic here
                        },
                        onSwitchRoleClick = {
                            isUserLogin = !isUserLogin
                        },
                        onSwitchScreen = {
                            isLoginScreen = !isLoginScreen
                        },
                        isUserLogin = isUserLogin,
                        isLoginScreen = isLoginScreen
                    )
                }
            }
        }
    }
}
