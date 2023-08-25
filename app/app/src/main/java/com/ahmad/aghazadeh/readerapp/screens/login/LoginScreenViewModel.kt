package com.ahmad.aghazadeh.readerapp.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    //val loadingState= MutableStateFlow(LoadingState.IDLE)
    private val auth:FirebaseAuth=Firebase.auth

    private  val _loading= MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun signInWithEmailAndPassword(email:String, password:String,onDone:() -> Unit)
    =viewModelScope.launch{
        try {
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                         onDone()
                    }else{
                        Log.d("xxx", "failure ")
                    }
                }
        }catch (ex:Exception){
            Log.e("xxx", "${ex.message}")
        }
    }

    fun createUserWithEmailAndPassword(email:String, password:String,onDone:()->Unit)    =viewModelScope.launch{
        try {
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        val displayName= it.result.user?.email?.split("@")?.get(0)
                        createUser(displayName)
                        onDone()
                    }else{
                        Log.d("xxx", "failure ")
                    }
                }
        }catch (ex:Exception){
            Log.e("xxx", "${ex.message}")
        }
    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
        val user= mutableMapOf<String,Any>()
        user["display_name"] = displayName.toString()
        user["user_id"] = userId.toString()
    }

}