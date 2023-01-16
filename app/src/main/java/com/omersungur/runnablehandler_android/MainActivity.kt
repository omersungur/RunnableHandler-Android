package com.omersungur.runnablehandler_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var runnable : Runnable
    private lateinit var handler : Handler
    private lateinit var textView : TextView
    var number : Int = 0
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.buttonStart)
    }

    fun start(view : View) {

        handler = Handler()

        button.isEnabled = false

        runnable = Runnable {
            textView.text = "Time: " + number
            number++
            handler.postDelayed(runnable,1000)
        }

        handler.post(runnable)
    }

    fun stop(view : View) {
        button.isEnabled = true
        handler.removeCallbacks(runnable) // handlerı durdurdur.
        number = 0
        textView.text = "Time: " + number
    }
}