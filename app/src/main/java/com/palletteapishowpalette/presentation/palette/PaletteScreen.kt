package com.palletteapishowpalette.presentation.palette

import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.palletteapishowpalette.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

/*

Light Vibrant
Vibrant
Dark Vibrant
Light Muted
Muted
Dark Muted

 */

@Composable
fun PaletteScreen(modifier: Modifier = Modifier) {

    var lightVibrant by remember { mutableStateOf(0) }
    var vibrant by remember { mutableStateOf(0) }
    var darkVibrant by remember { mutableStateOf(0) }
    var lightMuted by remember { mutableStateOf(0) }
    var muted by remember { mutableStateOf(0) }
    var darkMuted by remember { mutableStateOf(0) }

    Palette.from(
        BitmapFactory.decodeResource(
            LocalContext.current.resources,
            R.drawable. // Your image
        )
    ).generate { palette ->
        if (palette != null) {
            try {
                darkVibrant = palette.darkVibrantSwatch?.rgb!!
                lightVibrant = palette.lightVibrantSwatch?.rgb!!
                lightMuted = palette.lightMutedSwatch?.rgb!!
                muted = palette.mutedSwatch?.rgb!!
                darkMuted = palette.darkMutedSwatch?.rgb!!
                vibrant = palette.vibrantSwatch?.rgb!!
            } catch (e: Exception) {
                Log.e("create palette exception", e.toString())
            }
        } else {
            Log.e("palette", "null")
        }
    }

    PaletteScreenContent(
        modifier = modifier,
        lightVibrant = lightVibrant,
        vibrant = vibrant,
        darkVibrant = darkVibrant,
        lightMuted = lightMuted,
        muted = muted,
        darkMuted = darkMuted
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PaletteScreenContent(
    modifier: Modifier,
    lightVibrant: Int,
    vibrant: Int,
    darkVibrant: Int,
    lightMuted: Int,
    muted: Int,
    darkMuted: Int
) {
    Scaffold(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier.fillMaxSize()) {
            Palette(modifier = modifier.weight(1f), color = Color(lightVibrant), paletteName = "lightVibrant")
            Palette(modifier = modifier.weight(1f), color = Color(vibrant), paletteName = "vibrant")
            Palette(modifier = modifier.weight(1f), color = Color(darkVibrant), paletteName = "darkVibrant")
            Palette(modifier = modifier.weight(1f), color = Color(lightMuted), paletteName = "lightMuted")
            Palette(modifier = modifier.weight(1f), color = Color(muted), paletteName = "muted")
            Palette(modifier = modifier.weight(1f), color = Color(darkMuted), paletteName = "darkMuted")
        }
    }
}

@Composable
private fun Palette(modifier: Modifier, color: Color, paletteName: String) {
    val size = LocalConfiguration.current.screenHeightDp.dp / 6

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(size)
            .background(color = color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .background(color = Color.White)
                .padding(4.dp),
            text = paletteName,
            color = Color.Black
        )
    }
}