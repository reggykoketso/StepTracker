import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.navigation.compose.rememberNavController
import com.example.steptracker.DetailedScreen
import com.example.steptracker.R
import com.example.steptracker.ui.theme.StepTrackerTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StepTrackerTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("main") { MainScreen(navController) }
        composable("details") { DetailsScreen(navController) }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("main")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.subway_9151034_1280),
                contentDescription = "Logo"
            )
            Text(
                text = "Step Tracker",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Regina Mothiba")
            Text(text = "ST10439241")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("main") }) {
                Text(text = "Enter App")
            }
            Button(onClick = { }) {
                Text(text = "Exit App")
            }
            Button(onClick={
               val nav= Intent(this@MainActivity, DetailedScreen::class.java)
            }) {

            }
        }
    }
}

data class StepData(
    val day: String,
    var morningSteps: Int = 0,
    var afternoonSteps: Int = 0,
    var activityNotes: String = ""
)

@Composable
fun MainScreen(navController: NavHostController) {
    var stepData by remember { mutableStateOf(
        listOf(
            StepData("Monday", 2000, 3000, "Walked to classes and around campus."),
            StepData("Tuesday", 150, 4000, "Strolled during study breaks"),
            StepData("Wednesday"),
            StepData("Thursday"),
            StepData("Friday"),
            StepData("Saturday"),
            StepData("Sunday", morningSteps = 0, afternoonSteps = 0, activityNotes = "Walked to campus.")
        )
    ) }



