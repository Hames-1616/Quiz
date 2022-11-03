package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickme = findViewById<Button>(R.id.moibutton)

        clickme.text ="Increment"
        val bt = findViewById<Button>(R.id.button3)
        bt.text = "decrement"

        val bt2=findViewById<Button>(R.id.button)
        bt2.text="Reset"
        val texmt = findViewById<TextView>(R.id.textView)

        var clicked = 0;
        clickme.setOnClickListener{//here both the textview and button text will change if i presses the button
            clicked++

            texmt.text= clicked.toString()
            Toast.makeText( this, "increment", Toast.LENGTH_SHORT).show()  //gives a ui kinda message at the bottom
        }

        bt.setOnClickListener{
            clicked--
            texmt.text=clicked.toString()
            Toast.makeText(this,"decrement",Toast.LENGTH_SHORT).show()
        }

        bt2.setOnClickListener {
            clicked=0
            texmt.text=clicked.toString()
            Toast.makeText(this,"Reset Successfully ",Toast.LENGTH_SHORT).show()
        }

    }
}