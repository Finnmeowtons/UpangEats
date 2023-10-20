package com.example.upangeats

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.upangeats.databinding.ActivityMainBinding
import com.example.upangeats.viewModel.BottomNavViewModel
import com.example.upangeats.viewModel.SharedViewModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var bottomNavViewModel: BottomNavViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Handling of the system ui back button
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        //Disable Dark Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        //Setting the toolbar as a top app bar
        setSupportActionBar(binding.appBarMain.toolbar)


        //Initializing Side Navigation Drawer
        binding.sideNavDrawer.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.open,
            R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //Opening the Home Fragment
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                androidx.transition.R.anim.abc_fade_in,
                androidx.transition.R.anim.abc_fade_out
            )
            .replace(R.id.navFragment, HomeFragment())
            .commit()
        //Setting the selected item in side nav
        binding.sideNavDrawer.setCheckedItem(R.id.home_item)


        binding.appBarMain.toolbar2.setNavigationOnClickListener {
            onBackPressedMethod()
        }





        //Managing the navigation states using view model
        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        bottomNavViewModel = ViewModelProvider(this)[BottomNavViewModel::class.java]
        sharedViewModel.sideNavDrawerSelectedState.observe(this) { selectedItem ->
            when (selectedItem) {
                2131362076 -> {
                    binding.sideNavDrawer.setCheckedItem(R.id.home_item)
                    title = "Home"
                    visibleToolbarOne()
                }

                2131362249 -> {
                    binding.sideNavDrawer.setCheckedItem(R.id.profile_item)
                    binding.appBarMain.toolbar.title = "Profile"
                    visibleToolbarTwo()
                }

                2131362041 -> {
                    binding.sideNavDrawer.setCheckedItem(R.id.favorite_item)
                    binding.appBarMain.toolbar.title = "Favorite"
                    visibleToolbarTwo()
                }

                2131362071 -> {
                    binding.sideNavDrawer.setCheckedItem(R.id.history_item)
                    binding.appBarMain.toolbar2.title = "History"
                    visibleToolbarTwo()
                }

                2131362296 -> {
                    binding.sideNavDrawer.setCheckedItem(R.id.settings_item)
                    binding.appBarMain.toolbar2.title = "Settings"
                    visibleToolbarTwo()
                }
            }
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
            .replace(R.id.navFragment, fragment)
            .commit()
    }

    //Managing the navigation states
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home_item -> {
                sharedViewModel.sideNavDrawerSelectedState.value = item.itemId
                replaceFragment(HomeFragment())
            }

            R.id.profile_item -> {
                sharedViewModel.sideNavDrawerSelectedState.value = item.itemId
                replaceFragment(ProfileFragment())
            }

            R.id.history_item -> {
                sharedViewModel.sideNavDrawerSelectedState.value = item.itemId
//                replaceFragment(HomeHomeFragment())
            }

            R.id.favorite_item -> {
                sharedViewModel.sideNavDrawerSelectedState.value = item.itemId
                replaceFragment(FavoritesFragment())
            }

            R.id.settings_item -> {
                sharedViewModel.sideNavDrawerSelectedState.value = item.itemId
                replaceFragment(SettingsFragment())
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun visibleToolbarTwo() {
        binding.appBarMain.toolbar.visibility = View.GONE
        binding.appBarMain.toolbar2.visibility = View.VISIBLE
    }

    private fun visibleToolbarOne() {
        binding.appBarMain.toolbar.visibility = View.VISIBLE
        binding.appBarMain.toolbar2.visibility = View.GONE
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.frameLayout)
        return navController.navigateUp()
    }

    //Handling of the system ui back button and managing the navigation states
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }
    }
    private fun onBackPressedMethod() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right,
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
                .replace(R.id.navFragment, HomeFragment())
                .commit()
            when (bottomNavViewModel.selectedItemId.value) {
                2131361916 -> {
                    binding.appBarMain.toolbar.title = "Chat"
                }

                2131361918 -> {
                    binding.appBarMain.toolbar.title = "Stalls"

                }

                2131361919 -> {
                    binding.appBarMain.toolbar.title = "Tray"

                }

                else -> {
                    binding.appBarMain.toolbar.title = "Home"

                }
            }

            sharedViewModel.sideNavDrawerSelectedState.value = 2131362076
            binding.sideNavDrawer.setCheckedItem(R.id.home_item)
        }
    }
}