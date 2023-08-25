package com.ahmad.aghazadeh.readerapp.screens.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ahmad.aghazadeh.readerapp.R
import com.ahmad.aghazadeh.readerapp.components.EmailInput
import com.ahmad.aghazadeh.readerapp.components.InputField
import com.ahmad.aghazadeh.readerapp.components.PasswordInput
import com.ahmad.aghazadeh.readerapp.components.ReaderLogo
import com.ahmad.aghazadeh.readerapp.navigation.ReaderScreens

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(navController: NavController,
                viewModel: LoginScreenViewModel= viewModel()
) {
    val showLoginForm= rememberSaveable {
        mutableStateOf(true)
    }
    Surface(modifier= Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ReaderLogo()
            if(showLoginForm.value){
                UserForm(loading = false, isCreateAccount = false)  {email, password ->
                    viewModel.signInWithEmailAndPassword(email=email,password=password){
                        navController.navigate(ReaderScreens.HomeScreen.name)
                    }
                }
            }else{
                UserForm(loading = false, isCreateAccount = true) {email, password ->
                    viewModel.createUserWithEmailAndPassword(email=email,password=password){
                        navController.navigate(ReaderScreens.HomeScreen.name)
                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                val text = if (showLoginForm.value) "Sign up" else "Login"
                val haveAccount = if (showLoginForm.value) "New User? " else "You have an account? "
                Text(text = haveAccount)
                Text(text = text, Modifier.clickable {
                    showLoginForm.value = !showLoginForm.value
                })
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
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
        .verticalScroll(rememberScrollState())


    Column(
        modifier,horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        if(isCreateAccount) Text(text= stringResource(id = R.string.create_account),modifier=Modifier.padding(8.dp))
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
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        enabled =!(!loading && validInputs),
        shape = CircleShape
        ) {
        Log.e("xx","${!loading && validInputs}",)
        if(loading) CircularProgressIndicator(modifier=Modifier.size(25.dp)) else Text(text = text)

    }
}

