package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()

            }
        }
    }
}


@Composable
fun Lemonade(modifier : Modifier = Modifier) {
    var result by remember {mutableStateOf(1)}
    var randomLemon = (2..4).random()
    var clickLemon = 0

    var textoDeAbajo = when (result) {
        1 -> stringResource(R.string.tocar_limonero)
        2 -> stringResource(R.string.tocar_limon)
        3 -> stringResource(R.string.tocar_limonada)
        else -> stringResource(R.string.tocar_vaso)
    }
    var textoDescriptivo = when (result) {
        1 -> stringResource(R.string.limonero)
        2 -> stringResource(R.string.limon)
        3 -> stringResource(R.string.limonada)
        else -> stringResource(R.string.vaso)
    }
    var random = (2..4).random()

    val imageResource = when(result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    Text(
        text = stringResource(id = R.string.app_name),
        textAlign = TextAlign.Center,

        modifier = modifier
            .background(color = Color(255,255,0))
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopCenter)


    )
    Column (
        modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center



    ) {



        Button(
            onClick = {
                if (result == 2) {
                    clickLemon +=1
                    if (clickLemon == randomLemon)
                        result ++
                } else {
                    result += 1
                }
                if (result > 4) {
                    result = 1

                }

            },
            content = {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = textoDescriptivo
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(textoDeAbajo)
    }
}

@Preview
@Composable
fun LemonadeApp() {
Lemonade()
}
