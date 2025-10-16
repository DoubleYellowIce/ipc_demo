package com.ben.ipcdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ben.ipcdemo.ui.theme.IpcdemoTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    private lateinit var apiClientImpl: ApiClientImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        apiClientImpl = ApiClientImpl(this)
        setContent {
            IpcdemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    // Example of calling the API
                    val methodName = "methodName"
                    //demo params in json format
                    val params = "{\"key\":\"value\"}"
                    val res = apiClientImpl.call(methodName, params)
                    Log.d(TAG, "API call result: $res")
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
    IpcdemoTheme {
        Greeting("Android")
    }
}