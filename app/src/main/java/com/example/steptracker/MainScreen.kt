package com.example.steptracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.steptracker.ui.theme.StepTrackerTheme
import kotlin.system.exitProcess

class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
        data class
            val dates = arrayOf(
                "2024-10-07",
                "2024-1008",
                "2024-10-09",
                "2024-10-10",
                "2024-10-11",
                "2024-10-12",
                "2024-10-13"
            )

            val morningSteps = arrayOf(2000,150,445,1111,453,662,443)
            val afternoonSteps = arrayOf(3000,6667,765,886,33,76,54)
            val activityNotes= arrayOf("walked to classes and around campus","Strolled during study breaks","Walked around town before and after classes"," Went to the staff room running and back to classes running","Accompanied my friends to got to the shops","waled from the bus stop to my house")



            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Text(text = "Main: Step Tracker")
            Spacer(modifier = Modifier.size(16.dp))




            Button(onClick = { /*TODO*/ }) {
                Text(text = "Submit")

            }
            Button(onClick = {
                val nav = Intent(this@MainScreen, DetailedScreen::class.java)
                startActivity(nav)
            })

            {
                Text(text = "View Details")

            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Clear")

            }

        }


