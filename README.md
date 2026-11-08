# Daily Quotes — Android App

A small native Android app written in Kotlin with XML layouts and Material Components.

## Features
- Displays a random motivational quote on launch
- Next quote button chooses another quote (avoids an immediate repeat)
- Share quote using Android's native Sharesheet (`ACTION_SEND`)
- Quote model and in-memory Kotlin collection
- Simple, responsive card-based interface

## Run in Android Studio
1. Open this folder in Android Studio.
2. Let Gradle sync and fetch dependencies.
3. Run the `app` configuration on an emulator or Android device (minimum Android 6.0 / API 23).

## Project structure
- `Quote.kt` — quote data model
- `MainActivity.kt` — quote collection, random selection, click listeners, and share intent
- `res/layout/activity_main.xml` — UI built with XML and TextViews
- `res/values/` — theme colors and styling

## Customize
Add or edit entries in the `quotes` list in `MainActivity.kt`. Quotes in this starter are original short lines with the author set to "Unknown".
