package com.example.fittrack.model

enum class Difficulty(val label: String) {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced")
}

data class Exercise(
    val id: Int,
    val name: String,
    val category: String,
    val difficulty: Difficulty,
    val summary: String,
    val steps: List<String>,
    val recommendedMinutes: Int
)

data class WorkoutLogEntry(
    val id: Int,
    val exerciseName: String,
    val category: String,
    val durationMinutes: Int,
    val timestamp: Long
)

data class WorkoutUiState(
    val totalWorkouts: Int = 0,
    val totalMinutes: Int = 0,
    val history: List<WorkoutLogEntry> = emptyList()
)