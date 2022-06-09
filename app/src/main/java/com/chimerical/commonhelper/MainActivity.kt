package com.chimerical.commonhelper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.chimerical.commonhelper.ui.theme.CommonHelperTheme
import com.chimerical.utils.PrefsHelper
import com.chimerical.utils.Shared

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PrefsHelper.init(this)

        PrefsHelper.setStringSharedPref(Shared.SP_USER_ID, "Khush")
        PrefsHelper.setBooleanSharedPref(Shared.SP_USER_LOGIN, !true)

        setContent {
            CommonHelperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Hello! ")
                }
            }
        }
    }
}

@Composable
fun Greeting(hello: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        val name = PrefsHelper.getStringSharedPref(Shared.SP_USER_ID)
        val booleanValue = PrefsHelper.getBooleanSharedPref(Shared.SP_USER_LOGIN)
        Text("$hello $name the value is coming from PrefHelper that is $booleanValue")
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_2_XL)
@Composable
fun DefaultPreview() {
    CommonHelperTheme {
        Greeting(hello = "Hello !")
    }
}