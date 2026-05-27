package com.student.lifehackorurbanmyth

/**
 * Data class representing a single flashcard question.
 *
 * @param statement The life hack or urban myth statement shown to the user.
 * @param isHack True if the statement is a genuine hack, false if it is a myth.
 * @param explanation The explanation displayed on the review screen.
 *
 * Reference: Kotlin data classes - https://kotlinlang.org/docs/data-classes.html
 */
data class Question(
    val statement: String,
    val isHack: Boolean,
    val explanation: String
)