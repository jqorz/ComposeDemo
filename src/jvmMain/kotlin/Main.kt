import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun app() {
    val result = remember { mutableStateOf("") }

    MaterialTheme {
        Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
            Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    result.value =  ShellUtils.execCmd("adb devices","").output?:""
                }) {
                Text(result.value)
            }
            Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    result .value= ""
                }) {
                Text("Reset")
            }
        }



    }
}



fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "test app") {
        app()
    }
}
