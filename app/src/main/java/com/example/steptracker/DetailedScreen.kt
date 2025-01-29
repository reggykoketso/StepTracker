package com.example.steptracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.steptracker.ui.theme.StepTrackerTheme
import kotlin.system.exitProcess

class DetailedScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                
            }
            Text(text = "This is the Detailed screen")

                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Highest steps")


                }
                Button(onClick = { }) {
                    exitProcess(0)

                }
                Button(onClick = {
                    val nav = Intent(this@DetailedScreen,MainScreen::class.java)
                    startActivity(nav)
                }) {
                    Text(text = "Main")
                }
                fun calculateAverage(numbers:List<Double>):Double{return numbers.sum()/ numbers.size}}
                        Button(onClick = { /*TODO*/ }) {
                    Text(text = "Average")
                }
                    
                
