package com.ahmad.aghazadeh.readerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmad.aghazadeh.readerapp.navigation.ReaderNavigation
import com.ahmad.aghazadeh.readerapp.ui.theme.ReaderAppTheme
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReaderAppTheme {
                ReaderApp()
            }
        }
    }
}


@Composable
fun ReaderApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(46.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            ReaderNavigation()
        }

    }
}

