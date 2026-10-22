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
fun ExerciseDetailScreen(
    exerciseId: Int,
    viewModel: WorkoutViewModel,
    onBackClick: () -> Unit
) {
    val exercise = ExerciseRepository.getExerciseById(exerciseId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        if (exercise == null) {
            Text("Exercise not found")
        } else {
            Text("Exercise: ${exercise.name}")

            // temporary test button to check the ViewModel is shared
            Button(onClick = { viewModel.logWorkout(exercise, 10) }) {
                Text("Test log 10 min")
            }
        }

        Button(onClick = onBackClick) {
            Text("Back")
        }
    }
}