package app

import home.MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}
