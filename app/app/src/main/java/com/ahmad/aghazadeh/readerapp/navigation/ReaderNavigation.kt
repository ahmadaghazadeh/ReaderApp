package com.ahmad.aghazadeh.readerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmad.aghazadeh.readerapp.screens.SplashScreen
import com.ahmad.aghazadeh.readerapp.screens.details.BookDetailsScreen
import com.ahmad.aghazadeh.readerapp.screens.home.HomeScreen
import com.ahmad.aghazadeh.readerapp.screens.login.LoginScreen
import com.ahmad.aghazadeh.readerapp.screens.search.SearchScreen
import com.ahmad.aghazadeh.readerapp.screens.stats.StatsScreen
import com.ahmad.aghazadeh.readerapp.screens.update.UpdateScreen

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

        composable(ReaderScreens.BookDetailsScreen.name){
            BookDetailsScreen(navController=navController)
        }

        composable(ReaderScreens.LoginScreen.name){
            LoginScreen(navController=navController)
        }

        composable(ReaderScreens.SearchScreen.name){
            SearchScreen(navController=navController)
        }

        composable(ReaderScreens.StatsScreen.name){
            StatsScreen(navController=navController)
        }

        composable(ReaderScreens.UpdateScreen.name){
            UpdateScreen(navController=navController)
        }



    }

}