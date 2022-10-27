package com.example.ibraheemsprofilr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibraheemsprofilr.ui.theme.IbraheemsProfilrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IbraheemsProfilrTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    IbraheemsProfile()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun IbraheemsProfile() {
    ProfileWithImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ProfileWithImage(modifier: Modifier = Modifier) {
    var profile by remember { mutableStateOf( 1) }
    val profileImage = when(profile) {
        1 -> R.drawable.pp1
        2 -> R.drawable.pp2
        else -> R.drawable.pp3
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(profileImage), contentDescription = profile.toString(),  modifier = Modifier.size(150.dp))
        Text(
            text = stringResource(R.string.name),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.uni),
            fontSize = 20.sp
        )
        Text(
                text = stringResource(R.string.dept),
                fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { profile = (1..3).random() }) {
            Text(text = stringResource(R.string.cdp), fontSize = 24.sp)
        }
    }
}
