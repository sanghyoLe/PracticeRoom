package com.example.practiceroom

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DogAdapter(val context: Context, val dogs: List<Dog>) :
    RecyclerView.Adapter<DogAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_dog, parent, false)
            return Holder(view)
        }

        override fun getItemCount(): Int {
            return dogs.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder?.bind(dogs[position])
        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            val nameTv = itemView?.findViewById<TextView>(R.id.itemName)
            val lifeTv = itemView?.findViewById<TextView>(R.id.itemLifeSpan)
            val originTv = itemView?.findViewById<TextView>(R.id.itemOrigin)

            fun bind(dog: Dog){
                nameTv?.text = dog.dogName
                lifeTv?.text = dog.lifeSpan.toString()
                originTv?.text = dog.origin
            }
        }


}
