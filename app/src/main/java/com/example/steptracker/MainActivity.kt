package com.example.steptracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.steptracker.ui.theme.StepTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

          Column {
              Text(text = "Step Tracker")
              Text(text = "Regina Mothiba")
              Text(text = "ST10439241")

              Image(painter = painterResource(id = R.drawable.subway_9151034_1280),
                  contentDescription = "Logo" )
              
              Button(onClick = {
                  val nav = Intent(this@MainActivity,MainScreen::class.java)
                  startActivity(nav)
              }) {

                  Text(text = "Main")
              }
              Button(onClick = { }) {
                  System.exit(0)
                  Text(text = "Exit")
                  
              }
                  
              }
          }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplTheme {
        Greeting("Android")
    }