package com.example.upangeats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.upangeats.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeHomeFragment())
            .commit()

        binding.bottomNavigationView.setOnItemSelectedListener {item ->
            when(item.itemId) {
                R.id.bottomNavHome -> {
                    replaceFragment(HomeHomeFragment())

                    true
                }

                R.id.bottomNavTray -> {
                    replaceFragment(OrderTrayFragment())
                    true
                }

                R.id.bottomNavChat -> {
                    replaceFragment(ChatFragment())
                    true
                }

                R.id.bottomNavStalls -> {
                    replaceFragment(StallsFragment())
                    true
                }

                else -> false
            }

        }

        return binding.root


    }

    fun replaceFragment(fragment: Fragment){
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}
