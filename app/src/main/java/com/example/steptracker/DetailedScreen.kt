package com.example.steptracker

import StepData
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
        @Composable
        fun DetailsScreen(navController: NavHostController) {
            var stepData by remember { mutableStateOf(
                listOf(
                    StepData("Monday", 2000, 3000, "Walked to classes and around campus."),
                    StepData("Tuesday", 150, 4000}
            fun calculateTotalSteps(): Int {
                return stepData.sumOf { it.morningSteps + it.afternoonSteps }
            }

            fun calculateAverageSteps(): Double {
                return calculateTotalSteps().toDouble() / stepData.size
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(stepData.size) { index ->
                        val record = stepData[index]
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(text = record.day)
                            Text(text = "Morning Steps: ${record.morningSteps}")
                            Text(text = "Afternoon Steps: ${record.afternoonSteps}")
                            Text(text = "Activity Notes: ${record.activityNotes}")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigate("details") }) {
                    Text(text = "View Details")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Total Steps: $calculateTotalSteps()")
                Text(text = "Average Steps: ${calculateAverageSteps().toString()}")
            }
        }
                    
                
