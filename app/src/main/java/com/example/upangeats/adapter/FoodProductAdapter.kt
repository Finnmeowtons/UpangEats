package com.example.upangeats.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R
import com.example.upangeats.dataclass.Food
import com.example.upangeats.dialog.AddFoodProductDialogFragment
import com.example.upangeats.viewModel.SharedViewModel

class FoodProductAdapter(var foodList: List<Food>, val fragment : Fragment) : RecyclerView.Adapter<FoodProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_product_list_item,parent,false)
        return FoodProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodProductViewHolder, position: Int) {
        val food = foodList[position]
        Log.e("MyTag", "$foodList")
        return holder.bind(food, fragment)

    }

    fun updateFoodList(newFoodList: List<Food>) {
        foodList = newFoodList
        notifyDataSetChanged()
    }
}
class FoodProductViewHolder(val view: View):RecyclerView.ViewHolder(view){
    private val nameTextView: TextView = view.findViewById(R.id.tvFoodProductName)
    private val descriptionTextView: TextView = view.findViewById(R.id.tvFoodDescription)
    private lateinit var sharedViewModel: SharedViewModel


    fun bind(food:Food, fragment: Fragment) {
        sharedViewModel = ViewModelProvider(fragment.requireActivity())[SharedViewModel::class.java]

        nameTextView.text = food.name
        descriptionTextView.text = food.description
        view.setOnClickListener {
            sharedViewModel.selectedProduct.value = food
            fragment.requireActivity().supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(R.id.frameLayoutSeller, AddFoodProductDialogFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
