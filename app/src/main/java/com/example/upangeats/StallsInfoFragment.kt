package com.example.upangeats

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upangeats.bottomDialog.FoodInfoBottomSheetFragment
import com.example.upangeats.databinding.FragmentStallsInfoBinding
import com.google.android.material.tabs.TabLayout


class StallsInfoFragment : Fragment() {
    private lateinit var binding : FragmentStallsInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentStallsInfoBinding.inflate(inflater, container, false)

        childFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutFoodReviews, StallFoodsFragment())
            .commit()

        binding.imgbtnBackStallsInfo.setOnClickListener {


            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text.toString()){

                    "Food" ->{
                        childFragmentManager.beginTransaction()
                            .replace(R.id.frameLayoutFoodReviews, StallFoodsFragment())
                            .commit()
                    }
                    "Reviews" ->{
                        childFragmentManager.beginTransaction()
                            .replace(R.id.frameLayoutFoodReviews, StallReviewFragment())
                            .commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.e("tag2", "para gumana")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.e("tag2", "para gumana")
            }


        })

        return binding.root
    }
}