package com.ahmad.aghazadeh.readerapp.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahmad.aghazadeh.readerapp.ui.AppColors

@Preview
@Composable
fun SplashScreen(navController: NavController=NavController(context=LocalContext.current)) {

    val scale=remember{
         Animatable(AppColors.red500)
    }
    LaunchedEffect(key1 =true){
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis =800,
                easing={
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }))
    }
    Surface(modifier= Modifier
        .padding(16.dp)
        .size(330.dp),
        shape=CircleShape,
        color= AppColors.white,
        border = BorderStroke(width = 2.dp, color = AppColors.gray600)
    ) {
        Column(modifier= Modifier.padding(1.dp),
            horizontalAlignment =Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "Reader App",style =MaterialTheme.typography.displayMedium,
                color = AppColors.red900.copy(alpha =0.5f))
            Spacer(modifier= Modifier.height(16.dp))
            Text(text = "\"Read. Change. Yourself\"",style =MaterialTheme.typography.bodyLarge,
                color = AppColors.gray700.copy(alpha =0.5f))
        }
    }
}

