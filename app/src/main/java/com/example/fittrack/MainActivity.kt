package com.example.fittrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.fittrack.navigation.DashboardRoute
import com.example.fittrack.navigation.ExerciseDetailRoute
import com.example.fittrack.navigation.ExerciseListRoute
import com.example.fittrack.screens.DashboardScreen
import com.example.fittrack.screens.ExerciseDetailScreen
import com.example.fittrack.screens.ExerciseListScreen
import com.example.fittrack.ui.theme.FitTrackTheme
import com.example.fittrack.viewmodel.WorkoutViewModel

class MainActivity : ComponentActivity() {

    private val workoutViewModel: WorkoutViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitTrackTheme {
                FitTrackApp(workoutViewModel)
            }
        }
    }
}

@Composable
fun FitTrackApp(viewModel: WorkoutViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DashboardRoute
    ) {
        composable<DashboardRoute> {
            DashboardScreen(
                viewModel = viewModel,
                onCategoryClick = { category ->
                    navController.navigate(ExerciseListRoute(category = category))
                }
            )
        }

        composable<ExerciseListRoute> { backStackEntry ->
            val route: ExerciseListRoute = backStackEntry.toRoute()
            ExerciseListScreen(
                category = route.category,
                onExerciseClick = { id ->
                    navController.navigate(ExerciseDetailRoute(exerciseId = id))
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<ExerciseDetailRoute> { backStackEntry ->
            val route: ExerciseDetailRoute = backStackEntry.toRoute()
            ExerciseDetailScreen(
                exerciseId = route.exerciseId,
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}