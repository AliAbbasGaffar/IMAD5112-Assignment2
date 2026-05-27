package com.student.lifehackorurbanmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * QuizActivity - The Flashcard Question Screen.
 *
 * This activity loops through the list of questions stored in QuestionBank.
 * For each question, the user can select "Hack" (True) or "Myth" (False).
 * It tracks the score and provides immediate feedback after each answer.
 * After all questions are answered, it navigates to the ScoreActivity.
 *
 * Reference: Android Intents and passing data -
 * https://developer.android.com/guide/components/intents-filters
 */
class QuizActivity : AppCompatActivity() {

    // TAG for identifying log messages from this Activity
    private val TAG = "QuizActivity"

    // Declare all UI elements
    private lateinit var tvQuestionCount: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnHack: Button
    private lateinit var btnMyth: Button
    private lateinit var btnNext: Button
    private lateinit var progressBar: ProgressBar

    // Quiz state: tracks which question we're on and the user's score
    private var currentQuestionIndex = 0
    private var score = 0

    // Prevents the user from answering a question more than once
    private var hasAnswered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        Log.d(TAG, "QuizActivity created - starting quiz with ${QuestionBank.questions.size} questions")

        // Link all variables to their XML views
        tvQuestionCount = findViewById(R.id.tvQuestionCount)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnHack = findViewById(R.id.btnHack)
        btnMyth = findViewById(R.id.btnMyth)
        btnNext = findViewById(R.id.btnNext)
        progressBar = findViewById(R.id.progressBar)

        // Load the first question when the screen opens
        loadQuestion()

        // HACK button: user believes the statement is a real life hack
        btnHack.setOnClickListener {
            if (!hasAnswered) {
                Log.d(TAG, "User selected HACK for question ${currentQuestionIndex + 1}")
                checkAnswer(userAnsweredHack = true)
            }
        }

        // MYTH button: user believes the statement is an urban myth
        btnMyth.setOnClickListener {
            if (!hasAnswered) {
                Log.d(TAG, "User selected MYTH for question ${currentQuestionIndex + 1}")
                checkAnswer(userAnsweredHack = false)
            }
        }

        // NEXT button: moves to the next question or the score screen
        btnNext.setOnClickListener {
            currentQuestionIndex++
            Log.d(TAG, "Moving to question index: $currentQuestionIndex")

            // Loop through the questions list using the index
            if (currentQuestionIndex < QuestionBank.questions.size) {
                // There are still questions left — load the next one
                loadQuestion()
            } else {
                // All questions have been answered — go to Score Screen
                Log.d(TAG, "All questions answered. Final score: $score / ${QuestionBank.questions.size}")
                navigateToScoreScreen()
            }
        }
    }

    /**
     * Loads the current question onto the screen.
     * Resets feedback, hides the Next button, and re-enables the answer buttons.
     */
    private fun loadQuestion() {
        // Reset state variables for the new question
        hasAnswered = false
        tvFeedback.text = ""
        btnNext.visibility = View.INVISIBLE
        btnHack.isEnabled = true
        btnMyth.isEnabled = true

        // Get the current question object from the QuestionBank list
        val question = QuestionBank.questions[currentQuestionIndex]

        // Update the UI elements with the current question's data
        tvQuestion.text = question.statement
        tvQuestionCount.text = "Question ${currentQuestionIndex + 1} of ${QuestionBank.questions.size}"
        progressBar.progress = currentQuestionIndex + 1

        Log.d(TAG, "Loaded question ${currentQuestionIndex + 1}: ${question.statement}")
    }

    /**
     * Checks whether the user's answer is correct, updates the score,
     * displays feedback, and shows the Next button.
     *
     * @param userAnsweredHack True if the user pressed the Hack button, false for Myth.
     */
    private fun checkAnswer(userAnsweredHack: Boolean) {
        // Mark as answered to prevent double-clicking
        hasAnswered = true

        // Get the correct answer for the current question
        val question = QuestionBank.questions[currentQuestionIndex]

        // Disable buttons so the user cannot change their answer
        btnHack.isEnabled = false
        btnMyth.isEnabled = false

        // Compare the user's answer to the correct answer
        if (userAnsweredHack == question.isHack) {
            // ✅ Correct answer
            score++
            tvFeedback.text = "🎉 Correct! That's a real time-saver!"
            tvFeedback.setTextColor(getColor(R.color.colorHack))
            Log.d(TAG, "Correct! Score is now: $score")
        } else {
            // ❌ Wrong answer
            tvFeedback.text = "😬 Wrong! That's just an urban myth."
            tvFeedback.setTextColor(getColor(R.color.colorMyth))
            Log.d(TAG, "Incorrect. Score remains: $score")
        }

        // Show the Next button so the user can proceed
        btnNext.visibility = View.VISIBLE

        // Change the Next button text on the last question
        if (currentQuestionIndex == QuestionBank.questions.size - 1) {
            btnNext.text = "SEE RESULTS 🏆"
        }
    }

    /**
     * Navigates to the ScoreActivity, passing the final score and total as extras.
     */
    private fun navigateToScoreScreen() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("SCORE", score)
        intent.putExtra("TOTAL", QuestionBank.questions.size)
        startActivity(intent)
        finish() // Closes QuizActivity so the user cannot press Back to it
    }
}