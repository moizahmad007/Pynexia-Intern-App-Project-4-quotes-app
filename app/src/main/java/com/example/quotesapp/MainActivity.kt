package com.example.quotesapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var quoteText: TextView
    private lateinit var authorText: TextView
    private lateinit var quoteCounter: TextView
    private var currentQuote: Quote? = null

    // A small offline collection of original, app-written motivational lines.
    private val quotes = listOf(
        Quote("Small steps still move you forward.", "Unknown"),
        Quote("Make room for the things that make you feel alive.", "Unknown"),
        Quote("Progress is built one ordinary day at a time.", "Unknown"),
        Quote("You do not need the whole map to take the next step.", "Unknown"),
        Quote("Let curiosity be louder than doubt.", "Unknown"),
        Quote("A fresh start can begin in the middle of an ordinary day.", "Unknown"),
        Quote("Focus on what you can grow, not what you cannot control.", "Unknown"),
        Quote("Give your ideas the patience they need to become real.", "Unknown"),
        Quote("Consistency turns quiet effort into visible change.", "Unknown"),
        Quote("There is value in trying, learning, and trying again.", "Unknown"),
        Quote("Choose a direction, then keep showing up.", "Unknown"),
        Quote("Your pace is allowed to be your own.", "Unknown")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteText = findViewById(R.id.quoteText)
        authorText = findViewById(R.id.authorText)
        quoteCounter = findViewById(R.id.quoteCounter)

        findViewById<MaterialButton>(R.id.nextButton).setOnClickListener {
            showRandomQuote()
        }
        findViewById<MaterialButton>(R.id.shareButton).setOnClickListener {
            shareCurrentQuote()
        }

        showRandomQuote()
    }

    private fun showRandomQuote() {
        if (quotes.isEmpty()) {
            Toast.makeText(this, "No quotes available yet.", Toast.LENGTH_SHORT).show()
            return
        }

        val candidates = if (quotes.size > 1 && currentQuote != null) {
            quotes.filter { it != currentQuote }
        } else {
            quotes
        }
        currentQuote = candidates.random()

        quoteText.text = "“${currentQuote!!.text}”"
        authorText.text = "— ${currentQuote!!.author}"
        quoteCounter.text = "A THOUGHT TO TAKE WITH YOU  ·  ${quotes.size} QUOTES"
    }

    private fun shareCurrentQuote() {
        val quote = currentQuote ?: run {
            Toast.makeText(this, "Choose a quote first.", Toast.LENGTH_SHORT).show()
            return
        }

        val shareText = "“${quote.text}”\n— ${quote.author}\n\nShared from Daily Quotes"
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }
        startActivity(Intent.createChooser(sendIntent, "Share this quote"))
    }
}
