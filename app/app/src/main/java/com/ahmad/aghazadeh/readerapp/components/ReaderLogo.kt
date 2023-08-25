package com.ahmad.aghazadeh.readerapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ahmad.aghazadeh.readerapp.ui.AppColors

@Composable
public fun ReaderLogo(modifier: Modifier = Modifier) {
    Text(
        modifier=modifier.padding(16.dp),
        text = "Reader App", style = MaterialTheme.typography.displayMedium,
        color = AppColors.red900.copy(alpha = 0.5f)
    )
}

