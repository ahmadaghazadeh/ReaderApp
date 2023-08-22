package com.ahmad.aghazadeh.readerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmad.aghazadeh.readerapp.screens.SplashScreen
import com.ahmad.aghazadeh.readerapp.screens.home.HomeScreen

@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()
    NavHost(navController=navController,startDestination=ReaderScreens.SplashScreen.name){
        composable(ReaderScreens.SplashScreen.name){
            SplashScreen(navController=navController)
        }

        composable(ReaderScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        
    }

}