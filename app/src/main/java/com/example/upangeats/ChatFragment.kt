package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.adapter.ChatAdapter
import com.example.upangeats.databinding.FragmentChatBinding


class ChatFragment : Fragment() {
    private lateinit var binding : FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)

        binding.rvChat.adapter = ChatAdapter(this)
        binding.rvChat.layoutManager = LinearLayoutManager(this.context)


        // Inflate the layout for this fragment
        return binding.root
    }
}