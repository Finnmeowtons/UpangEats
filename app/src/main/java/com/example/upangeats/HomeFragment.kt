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


        val toolbar2 = activity?.findViewById<MaterialToolbar>(R.id.toolbar2)
        val toolbar = activity?.findViewById<MaterialToolbar>(R.id.toolbar)

        bottomNavViewModel = ViewModelProvider(requireActivity())[BottomNavViewModel::class.java]
        // Inflate the layout for this fragment
        if (bottomNavViewModel.selectedItemId.value == 2131361916) {
            replaceFragment(ChatFragment())
            toolbar?.title = "Chat"
            binding.bottomNavigationView.selectedItemId = R.id.bottomNavChat

        } else if (bottomNavViewModel.selectedItemId.value == 2131361918) {
            replaceFragment(StallsFragment())
            toolbar?.title = "Stalls"
            binding.bottomNavigationView.selectedItemId = R.id.bottomNavStalls

        } else if (bottomNavViewModel.selectedItemId.value == 2131361919) {
            replaceFragment(OrderTrayFragment())
            toolbar?.title = "Tray"
            binding.bottomNavigationView.selectedItemId = R.id.bottomNavTray

        } else {
            replaceFragment(HomeHomeFragment())
            toolbar?.title = "Home"
            binding.bottomNavigationView.selectedItemId = R.id.bottomNavHome
        }


        toolbar?.visibility = View.VISIBLE
        toolbar2?.visibility = View.GONE

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            bottomNavViewModel.selectedItemId.value = item.itemId
            Log.e("tag", "${item.itemId}")
            when (item.itemId) {
                R.id.bottomNavHome -> {
                    replaceFragment(HomeHomeFragment())
                    toolbar?.title = "Home"
                    true
                }

                R.id.bottomNavTray -> {
                    replaceFragment(OrderTrayFragment())
                    toolbar?.title = "Tray"
                    true
                }

                R.id.bottomNavChat -> {
                    replaceFragment(ChatFragment())
                    toolbar?.title = "Chat"
                    true
                }

                R.id.bottomNavStalls -> {
                    replaceFragment(StallsFragment())
                    toolbar?.title = "Stalls"
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
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

}
