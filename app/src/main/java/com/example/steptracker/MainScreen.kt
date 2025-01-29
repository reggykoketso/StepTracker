package com.example.steptracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.steptracker.ui.theme.StepTrackerTheme

class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "Main: Step Tracker")
            Spacer(modifier = Modifier.size(16.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Submit")

            }
            Button(onClick = {
                val nav = Intent(this@MainScreen,DetailedScreen::class.java)
                startActivity(nav)
            })

            {
                Text(text = "View Details")
                
            }
            Button(onClick = { /*TODO*/ }) {

                
            }
        }
    }
}

