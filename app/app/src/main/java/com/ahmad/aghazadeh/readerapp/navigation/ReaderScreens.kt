package com.ahmad.aghazadeh.readerapp.navigation

enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    SearchScreen,
    BookDetailsScreen,
    UpdateScreen,
    HomeScreen,
    StatsScreen;

    companion object{
        fun fromRoute(route: String): ReaderScreens=
            when(route?.substringBefore("/")){
                SplashScreen.name->SplashScreen
                LoginScreen.name->LoginScreen
                CreateAccountScreen.name->CreateAccountScreen
                SearchScreen.name->SearchScreen
                BookDetailsScreen.name->BookDetailsScreen
                UpdateScreen.name->UpdateScreen
                HomeScreen.name->HomeScreen
                null->HomeScreen
                else-> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}