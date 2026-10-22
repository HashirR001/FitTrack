package com.example.fittrack.data

import com.example.fittrack.model.Difficulty
import com.example.fittrack.model.Exercise

object ExerciseRepository {

    val categories = listOf("Strength", "Cardio", "Flexibility", "HIIT")

    private val exercises = listOf(
        // Strength
        Exercise(
            1, "Push-ups", "Strength", Difficulty.BEGINNER,
            "Works your chest and arms.",
            listOf(
                "Get in a plank position.",
                "Lower your chest to the floor.",
                "Push back up."
            ),
            10
        ),
        Exercise(
            2, "Squats", "Strength", Difficulty.BEGINNER,
            "Works your legs.",
            listOf(
                "Stand with your feet apart.",
                "Bend your knees and sit back.",
                "Stand back up."
            ),
            10
        ),
        Exercise(
            3, "Pull-ups", "Strength", Difficulty.ADVANCED,
            "Works your back and arms.",
            listOf(
                "Hang from a bar.",
                "Pull yourself up until your chin is over the bar.",
                "Lower yourself back down."
            ),
            15
        ),

        // Cardio
        Exercise(
            4, "Jumping Jacks", "Cardio", Difficulty.BEGINNER,
            "Gets your heart rate up.",
            listOf(
                "Stand with your feet together.",
                "Jump and spread your arms and legs.",
                "Jump back to the start."
            ),
            10
        ),
        Exercise(
            5, "Jump Rope", "Cardio", Difficulty.INTERMEDIATE,
            "Good for endurance.",
            listOf(
                "Hold the rope handles.",
                "Swing the rope over your head.",
                "Jump over it each time."
            ),
            15
        ),
        Exercise(
            6, "Running", "Cardio", Difficulty.INTERMEDIATE,
            "Simple cardio you can do anywhere.",
            listOf(
                "Warm up by walking.",
                "Run at a steady pace.",
                "Cool down by walking."
            ),
            20
        ),

        // Flexibility
        Exercise(
            7, "Toe Touch", "Flexibility", Difficulty.BEGINNER,
            "Stretches your legs.",
            listOf(
                "Stand up straight.",
                "Bend down and reach for your toes.",
                "Hold for 30 seconds."
            ),
            5
        ),
        Exercise(
            8, "Arm Stretch", "Flexibility", Difficulty.BEGINNER,
            "Stretches your shoulders.",
            listOf(
                "Pull one arm across your chest.",
                "Hold it with your other arm for 30 seconds.",
                "Switch arms."
            ),
            5
        ),
        Exercise(
            9, "Yoga Flow", "Flexibility", Difficulty.INTERMEDIATE,
            "Stretches your whole body.",
            listOf(
                "Start standing.",
                "Move slowly through a few yoga poses.",
                "Breathe deeply the whole time."
            ),
            15
        ),

        // HIIT
        Exercise(
            10, "Burpees", "HIIT", Difficulty.INTERMEDIATE,
            "A full body workout.",
            listOf(
                "Squat down and put your hands on the floor.",
                "Jump your feet back into a plank.",
                "Jump back up."
            ),
            10
        ),
        Exercise(
            11, "Mountain Climbers", "HIIT", Difficulty.INTERMEDIATE,
            "Works your core.",
            listOf(
                "Get in a plank position.",
                "Bring one knee to your chest.",
                "Switch legs quickly."
            ),
            10
        ),
        Exercise(
            12, "High Knees", "HIIT", Difficulty.ADVANCED,
            "Fast cardio that works your legs.",
            listOf(
                "Run in place.",
                "Bring your knees up high.",
                "Go as fast as you can."
            ),
            10
        )
    )

    fun getExercisesByCategory(category: String): List<Exercise> {
        return exercises.filter { it.category == category }
    }

    fun getExerciseById(id: Int): Exercise? {
        return exercises.find { it.id == id }
    }
}