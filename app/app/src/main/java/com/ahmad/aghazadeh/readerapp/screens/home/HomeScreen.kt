package com.ahmad.aghazadeh.readerapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import com.ahmad.aghazadeh.readerapp.ui.AppColors

@OptIn(ExperimentalMaterial3Api::class)
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
        modifier = Modifier.fillMaxSize()
    )  {

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderAppBar(title: String,showProfile:Boolean=true,
                 navController: NavController) {
    TopAppBar(title = {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (showProfile){
            Icon(imageVector =Icons.Default.Favorite,
                contentDescription = "Application Icon",
                modifier= Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .scale(0.6f))
        }
        Text(text = title, color = AppColors.red200, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.width(150.dp))
    }
    }, actions = {

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

