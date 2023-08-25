package com.ahmad.aghazadeh.readerapp.screens.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahmad.aghazadeh.readerapp.components.EmailInput
import com.ahmad.aghazadeh.readerapp.components.InputField
import com.ahmad.aghazadeh.readerapp.components.PasswordInput
import com.ahmad.aghazadeh.readerapp.components.ReaderLogo


@Composable
fun LoginScreen(navController: NavController) {
    Surface(modifier= Modifier.fillMaxSize()) {
        Column(horizontalAlignment= Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){
            ReaderLogo()
            UserForm() {email, password ->
                Log.e("dd","xx")
            }
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    loading: Boolean=false,
    isCreateAccount:Boolean=false,
    onDone: (String,String) -> Unit
){
    val email = rememberSaveable {
        mutableStateOf("")
    }
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisibility = rememberSaveable{
        mutableStateOf(false)
    }
    val passwordFocusRequest= FocusRequester.Default

    val keyboardController= LocalSoftwareKeyboardController.current

    val valid= remember(email.value, password.value){
        email.value.trim().isEmpty() || password.value.trim().isEmpty()
    }


    val modifier = Modifier
        .height(250.dp)
        .background(MaterialTheme.colorScheme.background)
        .verticalScroll(rememberScrollState())


    Column(modifier,horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        EmailInput(emailState = email
            , enabled = true
            , imeAction = ImeAction.Next
            , onAction = KeyboardActions{
                passwordFocusRequest.requestFocus()
            }
        )

        PasswordInput(modifier=Modifier.focusRequester(passwordFocusRequest)
            ,passwordState = password
            , enabled = !loading
            , imeAction = ImeAction.Next
            , passwordVisibility = passwordVisibility
            , onAction = KeyboardActions{
               if (!valid)return@KeyboardActions

                onDone(email.value.trim(),password.value.trim())
            })

        SubmitButton(text=if(isCreateAccount)"Create Account" else "Login",
            loading=false,
            validInputs = valid){
            onDone(email.value.trim(),password.value.trim())
            keyboardController?.hide()
        }
    }
}

@Composable
fun SubmitButton(text: String, loading: Boolean, validInputs: Boolean, onClick:()-> Unit) {
    Button(onClick = onClick,
        modifier = Modifier.padding(3.dp)
            .fillMaxWidth(),
        enabled =!loading && validInputs,
        shape = CircleShape
        ) {
        if(loading) CircularProgressIndicator(modifier=Modifier.size(25.dp)) else Text(text = text)

    }

}

