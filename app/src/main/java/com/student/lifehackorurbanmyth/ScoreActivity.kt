package com.student.lifehackorurbanmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * ScoreActivity - The Score Screen.
 *
 * Displays the user's final score out of 10.
 * Uses a when expression to provide personalised feedback based on the score.
 * Offers two buttons: one to review all answers, one to play again.
 *
 * Reference: Kotlin when expressions -
 * https://kotlinlang.org/docs/control-flow.html#when-expression
 */
class ScoreActivity : AppCompatActivity() {

    private val TAG = "ScoreActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // Retrieve the score and total passed from QuizActivity
        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 10)

        Log.d(TAG, "ScoreActivity loaded. User scored: $score / $total")

        // Link UI elements to variables
        val tvScore: TextView = findViewById(R.id.tvScore)
        val tvPersonalisedFeedback: TextView = findViewById(R.id.tvPersonalisedFeedback)
        val tvSubFeedback: TextView = findViewById(R.id.tvSubFeedback)
        val tvTrophy: TextView = findViewById(R.id.tvTrophy)
        val btnReview: Button = findViewById(R.id.btnReview)
        val btnPlayAgain: Button = findViewById(R.id.btnPlayAgain)

        // Display the score
        tvScore.text = "You scored $score / $total"

        // Use a when expression to set personalised feedback based on score ranges
        when {
            score == total -> {
                tvPersonalisedFeedback.text = "🌟 PERFECT SCORE! Master Hacker!"
                tvSubFeedback.text = "You're a walking encyclopedia of life hacks. Absolutely impressive!"
                tvTrophy.text = "🌟"
            }
            score >= 8 -> {
                tvPersonalisedFeedback.text = "🎯 Excellent! Hack Expert!"
                tvSubFeedback.text = "You clearly know your stuff. Just a couple slipped through the net!"
                tvTrophy.text = "🏆"
            }
            score >= 6 -> {
                tvPersonalisedFeedback.text = "👍 Good Job! Hack Apprentice!"
                tvSubFeedback.text = "Solid knowledge! A bit more practice and you'll be a true expert."
                tvTrophy.text = "😊"
            }
            score >= 4 -> {
                tvPersonalisedFeedback.text = "🤔 Keep Practising! Myth Believer!"
                tvSubFeedback.text = "You got some right, but those urban myths really caught you out!"
                tvTrophy.text = "📚"
            }
            else -> {
                tvPersonalisedFeedback.text = "😅 Stay Safe Online! Myth Victim!"
                tvSubFeedback.text = "Time to fact-check everything! Hit review to learn what's real."
                tvTrophy.text = "💡"
            }
        }

        // Navigate to ReviewActivity when the Review button is clicked
        btnReview.setOnClickListener {
            Log.d(TAG, "Review button clicked - navigating to ReviewActivity")
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        // Navigate back to the Welcome Screen when Play Again is clicked
        btnPlayAgain.setOnClickListener {
            Log.d(TAG, "Play Again clicked - restarting from MainActivity")
            val intent = Intent(this, MainActivity::class.java)
            // FLAG_ACTIVITY_CLEAR_TOP clears the back stack so the user starts fresh
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}