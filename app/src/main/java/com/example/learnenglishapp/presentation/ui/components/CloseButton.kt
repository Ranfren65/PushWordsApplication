package com.example.learnenglishapp.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun CloseButton(
    onCloseButtonClick:()->Unit,
    modifier: Modifier,
) {
    IconButton(
        modifier=
        modifier
            .size(72.dp)
            .padding(20.dp)
            .alpha(0.7f),
        onClick = { onCloseButtonClick },
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            imageVector = Icons.Filled.Close,
            contentDescription = "close",
        )
    }
}