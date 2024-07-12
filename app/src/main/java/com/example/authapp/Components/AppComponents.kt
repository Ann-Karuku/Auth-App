package com.example.authapp.Components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authapp.R

@Composable
fun NormalTextComponents( value:String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth().heightIn(min=30.dp),
        style= TextStyle(
            fontSize=18.sp,
            fontWeight= FontWeight.Normal,
            fontStyle= FontStyle.Normal
        )
    )
}
@Composable
fun TextFieldComponents( labelValue:String){

    var textValue by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = {Text(text=labelValue)},
        modifier = Modifier.fillMaxWidth()
    )
}