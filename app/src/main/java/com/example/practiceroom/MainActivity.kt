package com.example.practiceroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var dogDb: DogDB? = null
    private var dogList = listOf<Dog>()
    lateinit var mAdapter : DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mRecyclerView = findViewById<RecyclerView>(R.id.mRecyclerView)

        val mAddBtn = findViewById<Button>(R.id.mAddBtn)
        dogDb = DogDB.getInstance(this)

        mAdapter = DogAdapter(this, dogList)

        var r = Runnable{
            try {
                dogList = dogDb?.dogDao()?.getAll()!!

                mAdapter = DogAdapter(this, dogList)
                mAdapter.notifyDataSetChanged()


                mRecyclerView.adapter = mAdapter
                mRecyclerView.layoutManager = LinearLayoutManager(this)
                mRecyclerView.setHasFixedSize(true)
            } catch(e :Exception){
                Log.d("tag","Error - $e")
            }

        }

        val thread = Thread(r)
        thread.start()

        mAddBtn.setOnClickListener{
            val i = Intent(this, AddActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    override fun onDestroy() {
        DogDB.destroyInstance()
        dogDb = null
        super.onDestroy()


    }
}