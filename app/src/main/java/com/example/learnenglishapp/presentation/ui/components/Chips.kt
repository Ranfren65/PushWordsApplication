package com.example.learnenglishapp.presentation.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chips(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    colorSelected: Color,
    colorDisabled: Color,
    containerColor: Color
) {

    InputChip(modifier = Modifier
        .padding(
            start = 20.dp, end = 20.dp,
            top = 5.dp, bottom = 5.dp
        )
        .width(70.dp)
        .height(5.dp),
              shape = RoundedCornerShape(10.dp),
              selected = selected,
              onClick = onClick,
              colors = FilterChipDefaults.filterChipColors(
                  containerColor = containerColor,
                  selectedContainerColor = colorSelected,
                  disabledContainerColor = colorDisabled
              ),
              label = {
                  Text(
                      text = text,
                      textAlign = TextAlign.Center
                  )
              })
}

