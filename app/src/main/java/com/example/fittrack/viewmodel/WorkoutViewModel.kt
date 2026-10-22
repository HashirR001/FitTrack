package com.example.fittrack.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.fittrack.model.Exercise
import com.example.fittrack.model.WorkoutLogEntry
import com.example.fittrack.model.WorkoutUiState

class WorkoutViewModel : ViewModel() {

    var uiState by mutableStateOf(WorkoutUiState())
        private set

    private var nextId = 1

    fun logWorkout(exercise: Exercise, minutes: Int) {
        val entry = WorkoutLogEntry(
            id = nextId,
            exerciseName = exercise.name,
            category = exercise.category,
            durationMinutes = minutes,
            timestamp = System.currentTimeMillis()
        )
        nextId++

        uiState = uiState.copy(
            totalWorkouts = uiState.totalWorkouts + 1,
            totalMinutes = uiState.totalMinutes + minutes,
            history = listOf(entry) + uiState.history   // newest goes first
        )
    }

    fun clearLogs() {
        uiState = WorkoutUiState()
    }
}