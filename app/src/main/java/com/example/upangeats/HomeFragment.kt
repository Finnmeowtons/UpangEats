package com.example.upangeats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.upangeats.databinding.FragmentHomeBinding
import com.example.upangeats.viewModel.BottomNavViewModel
import com.google.android.material.appbar.MaterialToolbar


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bottomNavViewModel: BottomNavViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        bottomNavViewModel = ViewModelProvider(requireActivity())[BottomNavViewModel::class.java]
        // Inflate the layout for this fragment
        when (bottomNavViewModel.selectedItemId.value) {
            R.id.bottomNavChat -> {
                replaceFragment(ChatFragment())
                binding.bottomNavigationView.selectedItemId = R.id.bottomNavChat
            }

            R.id.bottomNavStalls -> {
                replaceFragment(StallsFragment())
                binding.bottomNavigationView.selectedItemId = R.id.bottomNavStalls
            }

            R.id.bottomNavTray -> {
                replaceFragment(OrderTrayFragment())
                binding.bottomNavigationView.selectedItemId = R.id.bottomNavTray
            }

            else -> {
                replaceFragment(HomeHomeFragment())
                binding.bottomNavigationView.selectedItemId = R.id.bottomNavHome
            }
        }

        val toolbar2 = activity?.findViewById<MaterialToolbar>(R.id.toolbar2)

        val title = activity?.findViewById<MaterialToolbar>(R.id.toolbar)

        title?.visibility = View.VISIBLE
        toolbar2?.visibility = View.GONE

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            bottomNavViewModel.selectedItemId.postValue(item.itemId)
            Log.e("tag", "${item.itemId}")
            when (item.itemId) {
                R.id.bottomNavHome -> {
                    replaceFragment(HomeHomeFragment())
                    title?.title = "Home"
                    true
                }

                R.id.bottomNavTray -> {
                    replaceFragment(OrderTrayFragment())
                    title?.title = "Tray"
                    true
                }

                R.id.bottomNavChat -> {
                    replaceFragment(ChatFragment())
                    title?.title = "Chat"
                    true
                }

                R.id.bottomNavStalls -> {
                    replaceFragment(StallsFragment())
                    title?.title = "Stalls"
                    true
                }

                else -> false
            }

        }





        return binding.root


    }


    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.nav_enter_anim,
                R.anim.nav_exit_anim
            )
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

}
