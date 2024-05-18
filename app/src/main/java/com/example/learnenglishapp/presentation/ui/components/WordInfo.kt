package com.example.learnenglishapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.MyViewModel
import com.example.learnenglishapp.data.model.chipsWords


@Composable
fun WordInfo(
    vm: MyViewModel = viewModel(),
    words:String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = words,
                fontSize = 30.sp
            )
            Text(
                modifier = Modifier.padding(start = 15.dp),
                text = "[baeg] сущ",
                color = Color.Gray
            )
            IconButton(modifier = Modifier.padding(start = 15.dp),
                       onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.vocalize),
                    contentDescription = "vocalize"
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        ListChips(chip = vm.items)
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            textAlign = TextAlign.Start,
            text = stringResource(R.string.examples),
            fontStyle = FontStyle.Italic,
            color = Color.Gray,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "Apple"
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "Яблоко",
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(300.dp))
    }
}

@Composable
private fun ListChips(
    chip: List<chipsWords>,
) {
    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        rows = GridCells.Fixed(3)
    ) {
        chip.forEach {
            item {
                Chips(
                    selected = false,
                    onClick = { },
                    text = it.chip,
                    colorSelected = Color.Transparent,
                    colorDisabled = Color.Transparent,
                    containerColor = colorResource(id = R.color.background_chips)
                )

            }
        }
    }
}

