package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickme = findViewById<Button>(R.id.moibutton)

        clickme.text ="eheh"

        clickme.setOnClickListener {
            clickme.text="lol you clicked bruh "
        }

        val texmt = findViewById<TextView>(R.id.textView)

        texmt.setOnClickListener {
            texmt.text = "how are you hames :)"
            texmt.setOnClickListener { //nested onclick listener if you click the text the second time it will display following data
                //similarly you can use more nested clicklistener
                texmt.text="hope you are fine"
            }
        }
    }
}