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

        data class dailyActivity(
            val date: Int,
            val morningSteps: Int,
            val afternoonSteps: Int,
            val activityNotes: String,
            val dailyActivities: String
        )
            val dailyActivites = arrayOf(
                 "2024-10-07",2000,3000,"walked to classes and around campus",
                "2024-1008",150,6667,"Strolled during study breaks",
                "2024-10-09",445,765,"Walked around town before and after classes",
                "2024-10-10",1111,886," Went to the staff room running and back to classes running",
                "2024-10-11",453,33,"Accompanied my friends to got to the shops",
                "2024-10-12",662,76,"waled from the bus stop to my house",
                "2024-10-13",443,54," Walked to campus"
                )




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
                val nav = Intent(this@MainScreen,DetailedScreen::class.java)
                startActivity(nav)
            })

            {
                Text(text = "View Details")

            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Clear")
            }




