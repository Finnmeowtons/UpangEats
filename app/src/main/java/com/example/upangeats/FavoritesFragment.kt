package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.adapter.FavoriteRecyclerViewAdapter
import com.example.upangeats.databinding.FragmentFavoritesBinding


class FavoritesFragment : Fragment() {
    private lateinit var binding : FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        binding.recyclerViewFavorites.layoutManager= LinearLayoutManager(this.context)
        binding.recyclerViewFavorites.adapter=FavoriteRecyclerViewAdapter()

        val id = 2131362041

        return binding.root
    }


}