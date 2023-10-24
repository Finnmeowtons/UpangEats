package com.example.upangeats

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import com.example.upangeats.adapter.FoodInfoAdapter
import com.example.upangeats.adapter.FoodProductAdapter
import com.example.upangeats.adapter.StallsAdapter
import com.example.upangeats.adapter.StallsHomeAdapter
import com.example.upangeats.databinding.FragmentHomeHomeBinding
import com.example.upangeats.dialog.ReportAProblemDialogFragment

class HomeHomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeHomeBinding.inflate(inflater, container, false)

        binding.rvStalls.adapter = StallsHomeAdapter()

        binding.rvFoodHome.adapter = FoodInfoAdapter()

        binding.viewMore.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.go_up,
                    R.anim.compress,
                    R.anim.decompress,
                    R.anim.go_down
                )
                .replace(R.id.navFragment, CategoriesFragment(), "StallsInfo")
                .addToBackStack(null)
                .commit()
        }

        binding.rvFoodHome.isNestedScrollingEnabled = false

        binding.nestedScroll.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (v.getChildAt(0).bottom <= v.height + scrollY) {
                Log.i("TAG", "BOTTOM SCROLL IN Recyclerview.");
                binding.rvFoodHome.isNestedScrollingEnabled = true
            } else {
                binding.rvFoodHome.isNestedScrollingEnabled= false

            }
        })

        return binding.root
    }


}