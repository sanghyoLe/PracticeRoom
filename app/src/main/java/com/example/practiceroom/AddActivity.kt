package com.example.practiceroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class AddActivity :AppCompatActivity(){

    private var dogDb : DogDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        dogDb = DogDB.getInstance(this)

        val addName = findViewById<TextView>(R.id.addName)
        val addLifeSpan = findViewById<TextView>(R.id.addLifeSpan)
        val addOrigin = findViewById<TextView>(R.id.addOrigin)
        val addBtn = findViewById<Button>(R.id.addBtn)

        val addRunnable = Runnable {
            val newDog = Dog()
            newDog.dogName = addName.text.toString()
            newDog.lifeSpan = Integer.parseInt(addLifeSpan.text.toString())
            newDog.origin = addOrigin.text.toString()
            dogDb?.dogDao()?.insert(newDog)
        }

        addBtn.setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    override fun onDestroy() {
        DogDB.destroyInstance()
        super.onDestroy()
    }
}