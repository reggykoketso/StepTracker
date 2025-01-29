package com.example.steptracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.steptracker.R
import com.example.steptracker.ui.theme.StepTrackerTheme
import com.example.steptracker.ui.theme.StepTrackerTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StepTrackerTheme {
                AppNavigator()
            }
        }
    }
}

@Composable
fun AppNavigator() {
    var showSplashScreen by remember { mutableStateOf(true) }
    var showNavigationDialog by remember { mutableStateOf(false) }

    if (showSplashScreen) {
        SplashScreen {
            showSplashScreen = false
            showNavigationDialog = true
        }
    } else {
        MainContent()
    }

    if (showNavigationDialog) {
        NavigationDialog(
            onNavigateToMainScreen = {
                showNavigationDialog = false
            },
            onExitApp = {
                showNavigationDialog = false
            }
        )
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(7000)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "THE STEP TRACKER",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00E5FF)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painterResource(R.drawable.subway_9151034_1280), null, Modifier
                    .size(200.dp)
                    .clip(shape = CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "REGINA MOTHIBA",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00E5FF)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "ST10439241",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00E5FF)
            )
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("detailed") { DetailedViewScreen(navController) }
    }
}

data class Stepsdata(
    val day: String,
    var morningTemp: String = "",
    var afternoonTemp: String = "",
    var weatherCondition: String = ""
)

@Composable
fun MainScreen(navController: NavHostController) {
    var stepsData by remember { mutableStateOf(
        listOf(
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY")
        )
    ) }
    val listState = rememberLazyListState()

    fun calculateAveragesteps(): Double {
        var totalsteps = 0.0
        var count = 0
        for (record in stepsData) {
            val morningsteps = record.morningTemp.toDoubleOrNull() ?: 0.0
            val afternoonsteps = record.afternoonTemp.toDoubleOrNull() ?: 0.0
            totalsteps += morningsteps + afternoonsteps
            count += if (morningsteps > 0) 1 else 0
            count += if (afternoonsteps > 0) 1 else 0
        }
        return if (count > 0) totalsteps / count else 0.0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.weight(1f)
        ) {
            items(stepsData.size) { index ->
                val record = stepsData[index]
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = record.day)
                    TextField(
                        value = record.morningsteps,
                        onValueChange = { newsteps ->
                            stepsData = stepsData.toMutableList().also {
                                it[index] = it[index].copy(morningsteps = newsteps)
                            }
                        },
                        label = { Text("Morning Steps") }
                    )
                    TextField(
                        value = record.afternoonTemp,
                        onValueChange = { newsteps ->
                            stepsData = stepsData.toMutableList().also {
                                it[index] = it[index].copy(afternoonTemp = newsteps)
                            }
                        },
                        label = { Text("Afternoon Steps") }
                    )
                    TextField(
                        value = record.weatherCondition,
                        onValueChange = { newCondition ->
                            stepsData = stepsData.toMutableList().also {
                                it[index] = it[index].copy(weatherCondition = newCondition)
                            }
                        },
                        label = { Text("Activity Notes") }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))



        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { stepsData = List(7) { stepsData(it.toString()) } }) {
            Text(text = "Clear Data")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("detailed") }) {
            Text(text = "Detailed View")
        }
        val itemList = remember { mutableListOf<String>() }
    }
}

@Composable
fun DetailedViewScreen(navController: NavHostController) {
    val weatherData by remember { mutableStateOf(
        listOf(
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY"),
            Stepsdata("DAY")
        )
    ) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(weatherData.size) { index ->
                val record = weatherData[index]
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = record.day,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Morning Steps: ${record.morningSteps}",
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Afternoon Steps: ${record.afternoonSteps}",
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Activity Notes: ${record.activityNotes}",
                        fontSize = 16.sp
                    )
                }

                Button(
                    onClick = { navController.navigate("main") },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Back")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}

@Composable
fun NavigationDialog(
    onNavigateToMainScreen: () -> Unit,
    onExitApp: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "Navigate") },
        text = { Text(text = "Do you want to navigate to the main screen or exit the app?") },
        confirmButton = {
            Button(onClick = onNavigateToMainScreen) {
                Text("Main Screen")
            }
        },
        dismissButton = {
            Button(onClick = onExitApp) {
                Text("Exit App")
            }
        }
    )
}