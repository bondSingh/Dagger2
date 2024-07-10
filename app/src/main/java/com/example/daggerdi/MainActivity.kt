package com.example.daggerdi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daggerdi.ui.theme.DaggerDITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerDITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }



        val daggerComponent = DaggerUserRegistrationComponent.factory().create(5)

        daggerComponent.inject(this)
        userRegistrationService.registerUser("saty@paper.com", "secret_password")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var counter = remember {
        mutableStateOf(0)
    }

    Column{
        Text(
            text = "Hello $name ${counter.value} times!",
            fontSize = 32.sp,
        )
        Button(
            onClick = { counter.value++ },
            modifier = Modifier
                .height(100.dp)
                .wrapContentHeight(Alignment.Bottom)) {
            Text(text = "Update Counter")

        }

        Button(
            onClick = {
                CoroutineScope(Dispatchers.Default).launch{
                    var ctr = 0L
                    for (i in 1..1000000000){
                        ctr = i.toLong()
                    }
                }

            },
            modifier = Modifier
                .height(100.dp)
                .wrapContentHeight(Alignment.Bottom))
        {
            Text(text = "Long task")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerDITheme {
        Greeting("Android")
    }
}