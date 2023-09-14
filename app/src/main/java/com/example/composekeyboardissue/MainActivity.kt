package com.example.composekeyboardissue

import android.os.Bundle
import android.text.InputFilter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.dnb.vipps.android.navigation.MyNavHost
import com.example.composekeyboardissue.ui.theme.ComposeKeyboardIssueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController: NavHostController = rememberNavController()
            ComposeKeyboardIssueTheme {
                MyNavHost(
                    modifier = Modifier
                        .fillMaxSize(),
                    navController = navHostController,
                    startDestination = "text",
                ) {
                    composable("text") {
                        val focusManager = LocalFocusManager.current
                        val focusRequester = remember { FocusRequester() }
                        LaunchedEffect(Unit) { focusRequester.requestFocus() }
                        Column {
                            TextField(
                                modifier = Modifier.focusRequester(focusRequester),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Phone,
                                    autoCorrect = false,
                                    imeAction = ImeAction.Done,
                                ),
                                value = "",
                                onValueChange = {})
                            Button(
                                onClick = {
                                    focusManager.clearFocus()
                                    navHostController.navigate("next")
                                }) {
                                Text(text = "Click me!")
                            }
                        }
                    }
                    composable("next") {
                        Text(text = "This should be visible!!!")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeKeyboardIssueTheme {
        Greeting("Android")
    }
}