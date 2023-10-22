package com.example.upangeats.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.upangeats.R
import com.example.upangeats.SellerFoodProductsFragment
import com.example.upangeats.adapter.FoodProductAdapter
import com.example.upangeats.databinding.FragmentAddFoodProductDialogBinding
import com.example.upangeats.dataclass.Food
import com.example.upangeats.db.FoodDatabaseHelper
import com.example.upangeats.viewModel.SharedViewModel

class AddFoodProductDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentAddFoodProductDialogBinding
    private lateinit var db: FoodDatabaseHelper
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddFoodProductDialogBinding.inflate(inflater, container, false)
        db = FoodDatabaseHelper(this.requireContext())
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        if (sharedViewModel.selectedProduct.value != null){
            val foodViewModel = sharedViewModel.selectedProduct.value

            binding.materialToolbar2.title = "Edit Food Product"
            binding.materialToolbar2.menu.findItem(R.id.delete_item).isVisible = true
            binding.materialToolbar2.menu.findItem(R.id.save_item).title = "save"
            binding.etFoodName.setText(foodViewModel?.name.toString())
            binding.etPrice.setText(foodViewModel?.price.toString())
            binding.etDescription.setText(foodViewModel?.description.toString())
        }


        binding.materialToolbar2.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.save_item -> {
                    val foodName = binding.etFoodName.text.toString()
                    val price = binding.etPrice.text.toString().toInt()
                    val description = binding.etDescription.text.toString()
                    val food = listOf<Food>()

                    // Check if a product is selected
                    if (sharedViewModel.selectedProduct.value != null) {
                        // If a product is selected, update it instead of adding a new one
                        val selectedFood = sharedViewModel.selectedProduct.value
                        if (selectedFood != null) {
                            val updatedFood = Food(selectedFood.id, foodName, price, description)
                            db.updateFood(updatedFood)
                            updateRecyclerView()
                        }
                    } else {
                        // If no product is selected, add a new one
                        val newFood = Food(1, foodName, price, description)
                        db.addFood(newFood)
                        updateRecyclerView()
                    }
                    sharedViewModel.selectedProduct.value = null
                    requireActivity().supportFragmentManager.popBackStack()
                }
                R.id.delete_item ->{
                    val selectedFood = sharedViewModel.selectedProduct.value
                    if (selectedFood != null) {
                        db.deleteFood(selectedFood.id)
                        requireActivity().supportFragmentManager.popBackStack()

                    }
                    sharedViewModel.selectedProduct.value = null
                }
            }
            true
        }

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // The only reason you might override this method when using
        // onCreateView() is to modify the dialog characteristics. For example,
        // the dialog includes a title by default, but your custom layout might
        // not need it. Here, you can remove the dialog title, but you must
        // call the superclass to get the Dialog.
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return super.onCreateDialog(savedInstanceState)
    }

    private fun updateRecyclerView(updatedFood: Food? = null) {
        val fragment = parentFragment
        if (fragment is SellerFoodProductsFragment) {
            // Assuming your fragment has a reference to the FoodProductAdapter
            val adapter = fragment.adapter
            updatedFood?.let { food ->
                val position = adapter.foodList.indexOfFirst { it.id == food.id }
                if (position != -1) {
                    adapter.notifyItemChanged(position)
                }
            } ?: run {
                // If no specific item is updated, refresh the whole list
                adapter.updateFoodList(db.getFoodListFromDatabase())
            }
        }
    }

}