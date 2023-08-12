package com.example.jetpackcomposeui_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeui_example.ui.theme.JetpackComposeUI_ExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            messageCard(message("han","chung"))
        }
    }


}
data class message(val author : String, val name : String)

@Composable
fun messageCard(message: message){
    Row {
        Image(painter = painterResource(id = R.drawable.baseline_people_24),
                                        contentDescription = "people")
        Column {
            Text(text = message.author)
            Text(text = message.name)
        }
    }
   

}
@Preview(showBackground = true)
@Composable
fun previewMessageCard(){
    messageCard(message("han","chung"))
}