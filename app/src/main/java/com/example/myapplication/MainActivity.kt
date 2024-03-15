package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AndroidView(factory = { context ->
                        LayoutInflater.from(context).inflate(R.layout.activity_main, null)
                    })
                }
            }
        }
    }

    var choice: String = ""

    fun onButtonClick(view: View) {
        if (view is Button) {
            val buttonText = view.text.toString()

            if(buttonText == "Impar" || buttonText == "Par") {
                choice = buttonText
            }

            if (buttonText.toIntOrNull() != null) {
                val number = buttonText.toInt()

                val numeroAleatorio = Random.nextInt(0, 6)

                val result = number + numeroAleatorio

                val resultText = if (result % 2 == 0) {
                    if (choice == "Par") {
                        "O robô escolheu: $numeroAleatorio, você escolheu: $number, a soma é: $result, [Você ganhou]"
                    } else if(choice == "Impar") {
                        "O robô escolheu: $numeroAleatorio, você escolheu: $number, a soma é: $result, [Você perdeu]"
                    } else {
                        "Escolha par ou ímpar"
                    }
                } else {
                    if (choice == "Impar") {
                        "O robô escolheu: $numeroAleatorio, você escolheu: $number, a soma é: $result, [Você ganhou]"
                    } else if (choice == "Par"){
                        "O robô escolheu: $numeroAleatorio, você escolheu: $number, a soma é: $result, [Você perdeu]"
                    } else {
                        "Escolha par ou ímpar"
                    }
                }
                    val resultTextView = findViewById<TextView>(R.id.resultTextView)
                    resultTextView.text = resultText
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
    MyApplicationTheme {
        Greeting("Android")
    }
}