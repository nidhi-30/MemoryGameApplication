package com.example.memorygameapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.memorygameapplication.R
import com.example.memorygameapplication.databinding.FragmentLobbyBinding
import com.example.memorygameapplication.util.Card

class LobbyFragment : Fragment() {

    private var _binding: FragmentLobbyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLobbyBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.option34.setOnClickListener {
            Card.size = 6
            Card.cardGrid = 3
            findNavController().navigate(R.id.action_LobbyFragment_to_GameFragment)
        }
        binding.option52.setOnClickListener {
            Card.size = 5
            Card.cardGrid = 5
            findNavController().navigate(R.id.action_LobbyFragment_to_GameFragment)
        }
        binding.option44.setOnClickListener {
            Card.size = 8
            Card.cardGrid = 4
            findNavController().navigate(R.id.action_LobbyFragment_to_GameFragment)
        }
        binding.option45.setOnClickListener {
            Card.size = 10
            Card.cardGrid = 4
            findNavController().navigate(R.id.action_LobbyFragment_to_GameFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}