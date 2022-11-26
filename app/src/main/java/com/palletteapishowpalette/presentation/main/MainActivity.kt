package com.palletteapishowpalette.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.palletteapishowpalette.presentation.palette.PaletteScreen
import com.palletteapishowpalette.ui.theme.PalletteApiShowPaletteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PalletteApiShowPaletteTheme {
                WindowCompat.setDecorFitsSystemWindows(window, false)

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PaletteScreen()
                }
            }
        }
    }
}
