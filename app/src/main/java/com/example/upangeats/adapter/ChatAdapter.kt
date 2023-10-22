package com.example.upangeats.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.MessagesFragment
import com.example.upangeats.R
import com.google.android.material.appbar.MaterialToolbar

class ChatAdapter(val fragment: Fragment) : RecyclerView.Adapter<ChatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatPosition = position
        return holder.bind(fragment)
    }
}

class ChatViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fragment: Fragment) {
        view.setOnClickListener {

            val toolbar = fragment.requireActivity().findViewById<MaterialToolbar>(R.id.toolbar)
            val toolbar2 = fragment.requireActivity().findViewById<MaterialToolbar>(R.id.toolbar2)
            toolbar?.visibility = View.GONE
            toolbar2?.visibility = View.GONE
            fragment.requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.nav_enter_anim,
                    R.anim.nav_exit_anim,
                    R.anim.nav_enter_anim,
                    R.anim.nav_exit_anim
                )
                .replace(R.id.navFragment, MessagesFragment(), "MessagesFragment")
                .addToBackStack(null)
                .commit()
        }
    }
}