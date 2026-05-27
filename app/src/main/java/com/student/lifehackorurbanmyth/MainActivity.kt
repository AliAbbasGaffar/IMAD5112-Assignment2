package com.student.lifehackorurbanmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity - The Welcome Screen.
 *
 * This is the first screen the user sees when they open the app.
 * It displays the app title, a brief description of the quiz,
 * and a Start button to begin.
 *
 * Reference: Android Activity lifecycle -
 * https://developer.android.com/guide/components/activities/activity-lifecycle
 */
class MainActivity : AppCompatActivity() {

    // TAG is used to identify log messages from this Activity
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Log that the welcome screen has loaded
        Log.d(TAG, "Welcome screen loaded successfully")

        // Find the Start button in the layout
        val btnStart: Button = findViewById(R.id.btnStart)

        // Set a click listener: when clicked, navigate to the QuizActivity
        btnStart.setOnClickListener {
            Log.d(TAG, "Start button clicked - navigating to QuizActivity")
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}