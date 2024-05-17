package com.example.learnenglishapp.presentation.ui.screen.main.settingsmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnenglishapp.R
import com.example.learnenglishapp.data.model.SettingsTile
import com.example.learnenglishapp.extension.test
import com.example.learnenglishapp.presentation.ui.components.AppBottomBar
import com.example.learnenglishapp.presentation.ui.components.CloseButton

@Composable
fun SettingsMenuScreen(
    modifier: Modifier = Modifier,
) {

}

@Composable
private fun SettingsMenuScreenContent(
    modifier: Modifier = Modifier,
    onCloseButtonClick: () -> Unit,
    onSubscribeButtonClick: () -> Unit,
    onTextButtonClick: () -> Unit,
) {
    Scaffold(
        bottomBar = { AppBottomBar() },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SettingsGroup(
                    group = SettingsTile.test,
                    labelText = stringResource(id = R.string.settings),
                )

                Spacer(modifier = Modifier.height(90.dp))

                WideButton(
                    labelText = "Купить подписку",
                    iconId = R.drawable.thunder,
                    colorId = R.color.blue_250,
                    onClick = onSubscribeButtonClick
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {

                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.question),
                        contentDescription = "",
                    )

                    Text(
                        modifier = Modifier
                            .clickable { onTextButtonClick }
                            .padding(horizontal = 15.dp),
                        fontSize = 18.sp,
                        text = stringResource(R.string.payment_under_restrictions),
                    )
                }
            }
            Box(modifier = Modifier.align(Alignment.TopEnd)) {
                CloseButton(
                    onCloseButtonClick = { onCloseButtonClick },
                    Modifier.align(Alignment.TopEnd),
                )
            }
        }
    }
}

@Composable
private fun SettingsGroup(
    modifier: Modifier = Modifier,
    group: List<SettingsTile>,
    labelText: String?,
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            if (labelText != null) {
                SettingsGroupTitle(labelText)
            }
            group.forEach { tile ->
                SettingsTile(tile = tile)

                Divider()
            }
        }
    }
}

@Composable
private fun WideButton(
    modifier: Modifier = Modifier,
    iconId: Int? = null,
    labelText: String,
    colorId: Int,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth(0.87f),
        colors = ButtonDefaults.buttonColors(colorResource(id = colorId)),
        shape = RoundedCornerShape(6.dp),
        onClick = { onClick }) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.thunder),
                contentDescription = " "
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = labelText,
                fontSize = 18.sp,
            )
        }
    }
}

@Composable
private fun SettingsTile(
    modifier: Modifier = Modifier,
    tile: SettingsTile,
) {
    Row(
        modifier = Modifier
            .clickable {
                TODO()
            }
            .height(57.dp)
            .padding(horizontal = 25.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = tile.title,
            fontSize = 19.sp,
        )

        if (tile.parameter != null) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.padding(start = 17.dp),
                text = tile.parameter,
                fontSize = 16.sp,
                fontWeight = FontWeight.W800,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun SettingsGroupTitle(labelText: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Text(
            text = labelText,
            fontSize = 22.sp,
            fontWeight = FontWeight.W800,
            modifier = Modifier
                .padding(vertical = 35.dp)
                .align(Alignment.Center),
        )
    }
}

@Composable
@Preview
private fun WideButtonPreview() {
    WideButton(
        labelText = "Купить подписку",
        iconId = R.drawable.thunder,
        colorId = R.color.blue_250,
        onClick = {}
    )
}

@Preview
@Composable
private fun SettingsTilePreview() {
    val testTile = SettingsTile(
        title = "Ваш часовой пояс",
        parameter = "+3 GMC Новосибирск",
    )
    SettingsTile(tile = testTile)
}

@Preview
@Composable
private fun SettingsGroupPreview() {
    SettingsMenuScreenContent(
        onCloseButtonClick = {},
        onSubscribeButtonClick = {},
        onTextButtonClick = {},
    )
}
