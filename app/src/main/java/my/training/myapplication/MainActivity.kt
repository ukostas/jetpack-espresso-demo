package my.training.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import my.training.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Form()
                }
            }
        }
    }
}

@Composable
fun Form() {
    var firstName by remember { mutableStateOf("") }
    var middleName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("Type first name") },
            maxLines = 1,
            modifier = Modifier.testTag("first_name")
        )
        OutlinedTextField(
            value = middleName,
            onValueChange = { middleName = it },
            label = { Text("Type middle name") },
            maxLines = 1,
            modifier = Modifier.testTag("middle_name")
        )
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Type last name") },
            maxLines = 1,
            modifier = Modifier.testTag("last_name")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Form()
    }
}