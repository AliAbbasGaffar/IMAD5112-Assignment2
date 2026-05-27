package com.student.lifehackorurbanmyth

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

/**
 * ReviewActivity - The Review Screen.
 *
 * Loops through all questions in the QuestionBank and dynamically builds
 * a card for each one, showing the statement, whether it was a Hack or Myth,
 * and a detailed explanation.
 *
 * This screen helps users learn from their mistakes after completing the quiz.
 *
 * Reference: Dynamically adding views in Android -
 * https://developer.android.com/reference/android/view/ViewGroup#addView(android.view.View)
 */
class ReviewActivity : AppCompatActivity() {

    private val TAG = "ReviewActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        Log.d(TAG, "ReviewActivity loaded - building ${QuestionBank.questions.size} review cards")

        val reviewContainer: LinearLayout = findViewById(R.id.reviewContainer)
        val btnBackToScore: Button = findViewById(R.id.btnBackToScore)

        // Loop through every question in the QuestionBank and create a card for each
        for (i in QuestionBank.questions.indices) {
            val question = QuestionBank.questions[i]

            Log.d(TAG, "Building review card for question ${i + 1}: ${question.statement}")

            // --- Create the outer Card ---
            val card = CardView(this).apply {
                radius = 16f
                cardElevation = 4f
                setCardBackgroundColor(getColor(android.R.color.white))
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.bottomMargin = 24
                layoutParams = params
            }

            // --- Inner layout inside the card ---
            val innerLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(32, 24, 32, 24)
            }

            // --- Question number and statement ---
            val tvStatement = TextView(this).apply {
                text = "${i + 1}. ${question.statement}"
                textSize = 16f
                setTextColor(getColor(R.color.colorText))
                setPadding(0, 0, 0, 12)
            }

            // --- Answer label (green for Hack, red for Myth) ---
            val answerColor = if (question.isHack) getColor(R.color.colorHack) else getColor(R.color.colorMyth)
            val answerText = if (question.isHack) "✅ REAL HACK" else "❌ URBAN MYTH"

            val tvAnswer = TextView(this).apply {
                text = answerText
                textSize = 15f
                setTextColor(answerColor)
                typeface = android.graphics.Typeface.DEFAULT_BOLD
                setPadding(0, 0, 0, 8)
            }

            // --- Explanation text ---
            val tvExplanation = TextView(this).apply {
                text = question.explanation
                textSize = 14f
                setTextColor(getColor(R.color.colorSubtext))
                lineSpacingExtra = 4f
            }

            // --- Assemble the card ---
            innerLayout.addView(tvStatement)
            innerLayout.addView(tvAnswer)
            innerLayout.addView(tvExplanation)
            card.addView(innerLayout)
            reviewContainer.addView(card)
        }

        // Back button returns to the Score Screen
        btnBackToScore.setOnClickListener {
            Log.d(TAG, "Back button clicked - returning to ScoreActivity")
            finish() // Closes ReviewActivity and goes back to ScoreActivity
        }
    }
}