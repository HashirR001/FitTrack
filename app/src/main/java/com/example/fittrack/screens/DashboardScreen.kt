package com.example.fittrack.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fittrack.data.ExerciseRepository
import com.example.fittrack.viewmodel.WorkoutViewModel

@Composable
fun DashboardScreen(
    viewModel: WorkoutViewModel,
    onCategoryClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        Text("Dashboard")
        Text("Workouts: ${viewModel.uiState.totalWorkouts}")
        Text("Minutes: ${viewModel.uiState.totalMinutes}")

        ExerciseRepository.categories.forEach { category ->
            Button(onClick = { onCategoryClick(category) }) {
                Text(category)
            }
        }
    }
}