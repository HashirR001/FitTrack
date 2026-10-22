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

@Composable
fun ExerciseListScreen(
    category: String,
    onExerciseClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    val exercises = ExerciseRepository.getExercisesByCategory(category)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        Text("Category: $category")

        exercises.forEach { exercise ->
            Button(onClick = { onExerciseClick(exercise.id) }) {
                Text(exercise.name)
            }
        }

        Button(onClick = onBackClick) {
            Text("Back")
        }
    }
}