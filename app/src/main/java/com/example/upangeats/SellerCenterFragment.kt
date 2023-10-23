package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upangeats.databinding.FragmentSellerCenterBinding

class SellerCenterFragment : Fragment() {
    private lateinit var binding : FragmentSellerCenterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSellerCenterBinding.inflate(inflater, container, false)

        binding.cvFoodProduct.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.enter_anim,
                    R.anim.exit_anim
                )
                .replace(R.id.frameLayoutSeller, SellerFoodProductsFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.cvOrders.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.enter_anim,
                    R.anim.exit_anim
                )
                .replace(R.id.frameLayoutSeller, SellerOrdersFragment())
                .addToBackStack(null)
                .commit()
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}