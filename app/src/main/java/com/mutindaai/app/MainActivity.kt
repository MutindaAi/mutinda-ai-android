package com.mutindaai.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 32, 24, 20)
            setBackgroundColor(Color.rgb(15, 20, 35))
        }

        val title = TextView(this).apply {
            text = "MUTINDA AI"
            textSize = 28f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Your AI. Your possibilities."
            textSize = 14f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        val chat = TextView(this).apply {
            text = "Hello! I'm MUTINDA AI.\\n\\nHow can I help you today?"
            textSize = 17f
            setTextColor(Color.WHITE)
            setPadding(12, 24, 12, 24)
        }

        val scroll = ScrollView(this).apply {
            addView(chat)
        }

        val input = EditText(this).apply {
            hint = "Ask MUTINDA AI anything..."
            setHintTextColor(Color.GRAY)
            setTextColor(Color.WHITE)
            setSingleLine(false)
        }

        val send = Button(this).apply {
            text = "Send"
            setOnClickListener {
                val message = input.text.toString().trim()

                if (message.isNotEmpty()) {
                    chat.append("\\n\\nYou: $message")
                    chat.append(
                        "\\n\\nMUTINDA AI: Thanks for your message! " +
                        "My AI brain is still being connected. Stay tuned!"
                    )
                    input.text.clear()
                    scroll.post {
                        scroll.fullScroll(ScrollView.FOCUS_DOWN)
                    }
                }
            }
        }

        root.addView(title)
        root.addView(subtitle)

        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        root.addView(input)
        root.addView(send)

        setContentView(root)
    }
}
