package com.example.upangeats

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.adapter.StallsAdapter
import com.example.upangeats.databinding.FragmentStallsBinding
import com.example.upangeats.viewModel.SharedViewModel
import com.google.android.material.appbar.MaterialToolbar

class StallsFragment : Fragment() {
    private lateinit var binding : FragmentStallsBinding
    private lateinit var sharedViewModel: SharedViewModel
    val stallList = listOf<Stalls>(
        Stalls( "Aljon","Aljon"),
        Stalls("Jose","Jose"),
        Stalls("Menard","Menard"),
        Stalls("Lord", "Lord"),
        Stalls("Jeremy", "Jeremy"),
        Stalls("Neil", "Neil"),
        Stalls("Julius", "Julius")
    )



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentStallsBinding.inflate(inflater, container, false)
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val toolbar = requireActivity().findViewById<MaterialToolbar>(R.id.toolbar)
        val toolbar2 = requireActivity().findViewById<MaterialToolbar>(R.id.toolbar2)


        binding.stallsRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.stallsRecyclerView.adapter = StallsAdapter(
            stallList,
        ) { selectedItem: Stalls ->
            toolbar?.visibility = View.GONE
            toolbar2?.visibility = View.GONE
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.go_up,
                    R.anim.compress,
                    R.anim.decompress,
                    R.anim.go_down
                )
                .replace(R.id.navFragment, StallsInfoFragment(), "StallsInfo")
                .addToBackStack(null)
                .commit()
            sharedViewModel.currentFragmentTag.value = "StallsInfo"
        }





        return binding.root
    }


}