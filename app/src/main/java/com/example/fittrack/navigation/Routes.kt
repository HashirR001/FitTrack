package com.example.fittrack.navigation

import kotlinx.serialization.Serializable

@Serializable
object DashboardRoute

@Serializable
data class ExerciseListRoute(val category: String)

@Serializable
data class ExerciseDetailRoute(val exerciseId: Int)