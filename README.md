# 🔍 Life Hack or Urban Myth?
### IMAD5112 Assignment 2 | Introduction to Mobile Application Development

---

## 📱 App Overview

**Life Hack or Urban Myth?** is a native Android flashcard quiz app built using Kotlin in Android Studio.

Users are presented with 10 statements — each is either a genuine life hack or a well-known urban myth. The goal is to correctly identify which is which, learn from your mistakes, and become a Master Hacker!

---

## 🎯 Purpose of the App

Life hacks and internet rumours are everywhere. Users often struggle to distinguish between genuine productivity tips and urban myths that have gone viral. This app gamifies fact-checking — making it fun and educational to learn which popular beliefs are real and which are completely false.

---

## ✨ Features

| Feature | Description |
|---|---|
| 🏠 Welcome Screen | App intro and Start button |
| 🃏 Flashcard Quiz | 10 questions with Hack / Myth buttons |
| 📊 Progress Bar | Visual progress through the quiz |
| 💬 Instant Feedback | Correct/incorrect message after each answer |
| 🏆 Score Screen | Final score with personalised feedback |
| 📋 Review Screen | Full list of all questions with correct answers and explanations |
| 🔄 Play Again | Restart the quiz from the score screen |

---

## 🖼️ App Screenshots





---

## 🎥 Video Demonstration

> 📺 



---


### Design Decisions
- **Purple colour scheme** — chosen for its association with creativity and knowledge
- **Card-based layout** — flashcard metaphor makes questions feel tactile and familiar
- **Emoji-driven UI** — makes the app feel fun and engaging without needing images
- **Immediate feedback** — users learn right away rather than waiting until the end
- **Progress bar** — reduces anxiety by showing how far through the quiz the user is

### Colour Palette
| Colour | Hex | Usage |
|---|---|---|
| Purple | `#6200EE` | Primary brand colour, buttons, headings |
| Green | `#2E7D32` | Correct / Hack answers |
| Red | `#C62828` | Wrong / Myth answers |
| Light Purple | `#F5F0FF` | Background |

---

## ⚙️ GitHub & Version Control

This project uses **GitHub** for version control, following a staged commit approach to demonstrate progress.

### Commit History

| Commit | Description |
|---|---|
| `Initial project setup` | Android Studio project created |
| `Stage 1: Welcome Screen` | Question model, QuestionBank, Welcome Screen |
| `Stage 2: Quiz Screen` | Flashcard loop, score tracking, feedback |
| `Stage 3: Score & Review` | Personalised score feedback, full review screen |
| `Stage 4: GitHub Actions` | Automated CI build and test pipeline |
| `Stage 5: README` | Full documentation |

---

## 🤖 GitHub Actions — Automated Build

This project uses **GitHub Actions** for Continuous Integration (CI). Every time code is pushed to the `main` branch, the workflow automatically:

1. ✅ Checks out the code
2. ✅ Sets up Java 17
3. ✅ Grants Gradle execute permissions
4. ✅ Builds the project with Gradle
5. ✅ Runs all unit tests

The workflow file is located at: `.github/workflows/build.yml`

You can see the build results under the **Actions** tab of this repository.

---

## 🛠️ How to Run the App

1. Clone this repository:
```bash
   git clone https://github.com/YOURUSERNAME/IMAD5112-Assignment-2.git
```
2. Open the project in **Android Studio**
3. Let Gradle sync complete
4. Run on an emulator (API 24 or higher) or a physical device
5. Click **▶ Run**

---

## 📚 References

- Android Developers. (2024). *Activity lifecycle*. Available at: https://developer.android.com/guide/components/activities/activity-lifecycle
- Android Developers. (2024). *Intents and intent filters*. Available at: https://developer.android.com/guide/components/intents-filters
- JetBrains. (2024). *Kotlin data classes*. Available at: https://kotlinlang.org/docs/data-classes.html
- JetBrains. (2024). *Kotlin control flow - when expression*. Available at: https://kotlinlang.org/docs/control-flow.html
- GitHub. (2024). *GitHub Actions documentation*. Available at: https://docs.github.com/en/actions
- Automated Build Android App with GitHub Action. Available at: https://github.com/marketplace/actions/automated-build-android-app-with-github-action

---



















