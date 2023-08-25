package com.ahmad.aghazadeh.readerapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ahmad.aghazadeh.readerapp.ui.AppColors

@Composable
public fun ReaderLogo(modifier: Modifier = Modifier) {
    Text(
        modifier=modifier.padding(8.dp),
        text = "Reader App", style = MaterialTheme.typography.displayMedium,
        color = AppColors.red900.copy(alpha = 0.5f)
    )
}


@Composable
fun EmailInput(
    modifier: Modifier= Modifier,
    emailState: MutableState<String>,
    enabled: Boolean =true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default){
    InputField(modifier=modifier
        , valueState=emailState
        , enabled = enabled
        , keyboardType = KeyboardType.Email
        , imeAction = imeAction
        , label = "Email Address"
        , onAction=onAction)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    modifier: Modifier,
    passwordState: MutableState<String>,
    enabled: Boolean,
    passwordVisibility: MutableState<Boolean>,
    imeAction: ImeAction,
    onAction: KeyboardActions=KeyboardActions.Default
) {
    val passwordVisibilityState = if(passwordVisibility.value) VisualTransformation.None
    else PasswordVisualTransformation()
    OutlinedTextField(value = passwordState.value, onValueChange = {
        passwordState.value = it
    }, label = { Text(text = "Password")},
        modifier = modifier.padding(8.dp),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium,
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        visualTransformation = passwordVisibilityState ,
        keyboardActions = onAction,
        trailingIcon ={
            if(passwordVisibilityState == VisualTransformation.None){
                IconButton( onClick ={
                    passwordVisibility.value = !passwordVisibility.value
                }){
                    if(passwordVisibility.value) Icons.Default.Visibility
                    else Icons.Default.VisibilityOff
                }
            }

        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    modifier: Modifier= Modifier,
    valueState: MutableState<String>,
    label:String,
    enabled: Boolean =true,
    isSingleLine:Boolean= true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(value = valueState.value, onValueChange = {
        valueState.value = it
    }, label = { Text(text = label)},
        modifier = modifier.padding(8.dp),
        singleLine = isSingleLine,
        textStyle = MaterialTheme.typography.bodyMedium,
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = onAction
    )
}


