package com.ahmad.aghazadeh.readerapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahmad.aghazadeh.readerapp.R
import com.ahmad.aghazadeh.readerapp.navigation.ReaderScreens
import com.ahmad.aghazadeh.readerapp.ui.AppColors
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = {
                 ReaderAppBar(navController=navController,showProfile = true, title ="Reader App"
                     )
        },
        floatingActionButton = {
            FABContent(onTap = {

            })
        },
        content = { innerPadding ->
            LazyColumn(
                // consume insets as scaffold doesn't do it by default
                modifier = Modifier.consumeWindowInsets(innerPadding),
                contentPadding = innerPadding
            ) {
                items(count = 100) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(AppColors.red200)
                    )
                }
            }
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderAppBar(title: String,showProfile:Boolean=true,
                 navController: NavController) {
    TopAppBar(title = {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (showProfile){
            Icon(imageVector =Icons.Default.Favorite,
                tint = AppColors.red900.copy(alpha=0.5f),
                contentDescription = "Application Icon",
                modifier= Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .scale(0.6f))
        }
        Text(text = title, color = AppColors.red200, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.width(150.dp))
    }
    }, actions = {
        IconButton(onClick={
            FirebaseAuth.getInstance().signOut().run {
                navController.navigate(ReaderScreens.LoginScreen.name)
            }
        }){
            Icon(imageVector = Icons.Default.Logout,
                tint = AppColors.green900.copy(alpha = 0.5f),
            contentDescription = "logout Icon")
        }

    })
}

@Composable
fun FABContent(onTap:(String)-> Unit) {
    FloatingActionButton(onClick ={},
        shape =RoundedCornerShape(50.dp)){
        Icon(imageVector = Icons.Default.Add,
            contentDescription ="Add a book",
            tint = AppColors.white )
    }
}

