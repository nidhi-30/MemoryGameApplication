package com.example.memorygameapplication.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.example.memorygameapplication.R
import com.example.memorygameapplication.adapter.CardAdapter
import com.example.memorygameapplication.databinding.FragmentGameBinding
import com.example.memorygameapplication.util.Card
import com.example.memorygameapplication.util.MemoryCard

class GameFragment : Fragment(), CardAdapter.OnItemClickListener {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private val images = arrayListOf(R.drawable.memory_bat_card_front, R.drawable.memory_cat_card_front,
        R.drawable.memory_cow_front, R.drawable.memory_dragon_card_front,
        R.drawable.memory_garbage_man_card_front, R.drawable.memory_ghost_dog_card_front,
        R.drawable.memory_hen_card_front, R.drawable.memory_horse_card_front,
        R.drawable.memory_pig_card_front, R.drawable.memory_spider_card_front)

    private lateinit var imagesGame : ArrayList<Int>
    private lateinit var uniqueImages : ArrayList<Int>
    private val cardsAdapter = CardAdapter(this)

    private var getSelectedCard: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Card.cards = listOf()

        images.shuffle()
        imagesGame = images.take((Card.size)) as ArrayList<Int>
        uniqueImages = imagesGame
        imagesGame.addAll(imagesGame)
        imagesGame.shuffle()

        Card.cards = imagesGame.indices.map { index -> MemoryCard(uniqueImages[index]) }

        binding.cardRecycler.layoutManager = GridLayoutManager(this.context, Card.cardGrid)

        updateCardFlips()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        val clickedCard = Card.cards[position]

        if(clickedCard.isFaceUp){

            val dialog = this.context?.let { Dialog(it) }
            dialog?.setContentView(R.layout.dialog_alert)
            dialog?.show()

            val dismissButton = dialog?.findViewById<Button>(R.id.error_button)
            dismissButton?.setOnClickListener {
                dialog.dismiss()
            }

            return
        }
        if(getSelectedCard == null){
            resetCardFace()
            getSelectedCard = position
        }
        else {
            matchCards(getSelectedCard!!, position)
            getSelectedCard = null
        }
        clickedCard.isFaceUp = !clickedCard.isFaceUp

        updateCardFlips()
    }

    private fun updateCardFlips(){
        cardsAdapter.setCards(Card.cards)
        binding.cardRecycler.adapter = cardsAdapter
    }

    private fun matchCards(card1: Int, card2: Int) {
        if (Card.cards[card1].identifier == Card.cards[card2].identifier) {
            Card.cards[card1].isMatched = true
            Card.cards[card2].isMatched = true
        }
    }

    private fun resetCardFace() {
        for (card in Card.cards) {
            if (!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }

}