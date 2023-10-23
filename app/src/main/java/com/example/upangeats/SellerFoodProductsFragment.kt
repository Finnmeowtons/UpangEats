package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.upangeats.adapter.FoodProductAdapter
import com.example.upangeats.databinding.FragmentSellerFoodProductsBinding
import com.example.upangeats.db.FoodDatabaseHelper
import com.example.upangeats.dialog.AddFoodProductDialogFragment
import com.example.upangeats.viewModel.SharedViewModel

class SellerFoodProductsFragment : Fragment() {
    private lateinit var binding: FragmentSellerFoodProductsBinding
    private lateinit var db : FoodDatabaseHelper
    private lateinit var sharedViewModel: SharedViewModel
    lateinit var adapter : FoodProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSellerFoodProductsBinding.inflate(inflater, container, false)
        db = FoodDatabaseHelper(this.requireContext())
        db.getFoodListFromDatabase()

        adapter = FoodProductAdapter(db.getFoodListFromDatabase(), this)

        binding.rvSellerFoodProduct.adapter = adapter
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        binding.fab.setOnClickListener {
            sharedViewModel.selectedProduct.value = null
            requireActivity().supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(R.id.frameLayoutSeller, AddFoodProductDialogFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnSearch.setOnClickListener {
            sharedViewModel.selectedProduct.value = null
            val query = binding.etSearchSignUp.text.toString().trim().lowercase()

            // Check if the query is not empty
            if (query.isNotEmpty()) {
                val filteredList = db.searchFoodByName(query)
                adapter.updateFoodList(filteredList)
            } else {
                // If the query is empty, show all items
                adapter.updateFoodList(db.getFoodListFromDatabase())
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}