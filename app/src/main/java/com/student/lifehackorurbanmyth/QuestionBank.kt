package com.student.lifehackorurbanmyth

/**
 * QuestionBank - A singleton object that stores all quiz questions.
 *
 * This acts as the data source for the quiz. It holds a list of 10 Question
 * objects that the QuizActivity will loop through.
 *
 * Reference: Kotlin object declarations - https://kotlinlang.org/docs/object-declarations.html
 */
object QuestionBank {

    // A list of 10 Life Hack or Urban Myth questions
    val questions: List<Question> = listOf(

        Question(
            statement = "Drinking a glass of water before a meal helps you eat less.",
            isHack = true,
            explanation = "✅ REAL HACK! Drinking water before meals creates a feeling of fullness, helping reduce overall calorie intake."
        ),
        Question(
            statement = "Humans only use 10% of their brain at any given time.",
            isHack = false,
            explanation = "❌ URBAN MYTH! Brain scans show that we use virtually all parts of our brain and most of it is active almost all the time."
        ),
        Question(
            statement = "Putting your phone in a bag of rice overnight fixes water damage.",
            isHack = false,
            explanation = "❌ URBAN MYTH! Rice absorbs very little moisture from electronics. Silica gel packets or a repair shop are far more effective."
        ),
        Question(
            statement = "Laughing for 10 to 15 minutes can burn up to 40 extra calories.",
            isHack = true,
            explanation = "✅ REAL HACK! Genuine laughter increases your heart rate and engages your core muscles, burning a small number of extra calories."
        ),
        Question(
            statement = "Hair and fingernails continue to grow after a person dies.",
            isHack = false,
            explanation = "❌ URBAN MYTH! After death, the skin dehydrates and retracts, making nails and hair appear longer. They do not actually keep growing."
        ),
        Question(
            statement = "Chewing gum while cutting onions stops your eyes from watering.",
            isHack = true,
            explanation = "✅ REAL HACK! Chewing gum causes you to breathe through your mouth, which redirects the onion fumes away from your eyes."
        ),
        Question(
            statement = "You lose most of your body heat through the top of your head.",
            isHack = false,
            explanation = "❌ URBAN MYTH! You lose body heat proportionally through all exposed skin. The head is not special — it just gets cold when uncovered."
        ),
        Question(
            statement = "Applying raw honey to a small wound can help it heal faster.",
            isHack = true,
            explanation = "✅ REAL HACK! Medical-grade honey has proven antibacterial properties and has been used in wound care for centuries."
        ),
        Question(
            statement = "Swallowed chewing gum stays in your stomach for 7 years.",
            isHack = false,
            explanation = "❌ URBAN MYTH! Although gum base is indigestible, it still moves through your digestive system and passes within a few days."
        ),
        Question(
            statement = "Putting a rubber band around your wallet stops contactless card payments going off accidentally.",
            isHack = true,
            explanation = "✅ REAL HACK! A rubber band creates a physical barrier that can disrupt the contactless signal, preventing accidental payments."
        )
    )
}