package com.example.memorygameapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.memorygameapplication.R
import com.example.memorygameapplication.util.MemoryCard
import kotlinx.android.synthetic.main.card_item.view.*


class CardAdapter(val listener: OnItemClickListener) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private var cardList = mutableListOf<MemoryCard>()

    fun setCards(card : List<MemoryCard>){
        this.cardList = card.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val sCard = cardList[position]

        if(sCard.isMatched){
            holder.cardImage.card.alpha = 0.1f
        }
        holder.cardImage.card?.setBackgroundResource(if (sCard.isFaceUp) sCard.identifier else R.drawable.all_card_backs)

    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    inner class CardViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val cardImage: ImageView = itemView.card

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}