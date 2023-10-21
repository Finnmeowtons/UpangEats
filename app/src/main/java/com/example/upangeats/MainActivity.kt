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
import androidx.core.view.WindowCompat
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
import com.google.android.material.bottomnavigation.BottomNavigationView
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
                R.anim.enter_anim,
                R.anim.exit_anim
            )
            .replace(R.id.navFragment, HomeFragment())
            .commit()
        //Setting the selected item in side nav
        binding.sideNavDrawer.setCheckedItem(R.id.home_item)
        //Making the back button on toolbar2 go back
        binding.appBarMain.toolbar2.setNavigationOnClickListener {
            onBackPressedMethod()
        }


        //Managing the navigation states using view model
        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        bottomNavViewModel = ViewModelProvider(this)[BottomNavViewModel::class.java]
        sideNavState()

        sharedViewModel.currentFragmentTag.observe(this) { activeFragment ->
            when (activeFragment) {
                "StallsInfo" -> {
                    Log.e("MyTag", "cliped")
                }

            }
        }



    }

    //Managing the navigation states using view model
    private fun sideNavState() {
        sharedViewModel.sideNavDrawerSelectedState.observe(this) { selectedItem ->
            when (selectedItem) {
                R.id.home_item -> {
                    binding.sideNavDrawer.setCheckedItem(R.id.home_item)
                    binding.appBarMain.toolbar2.title = "Home"
                    visibleToolbarOne()
                }

                R.id.favorite_item -> {
                    binding.sideNavDrawer.setCheckedItem(R.id.favorite_item)
                    binding.appBarMain.toolbar2.title = "Favorite"
                    visibleToolbarTwo()
                }

                R.id.history_item -> {
                    binding.sideNavDrawer.setCheckedItem(R.id.history_item)
                    binding.appBarMain.toolbar2.title = "History"
                    visibleToolbarTwo()
                }

                R.id.settings_item -> {
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
                R.anim.enter_anim,
                R.anim.exit_anim
            )
            .replace(R.id.navFragment, fragment)
            .commit()
    }

    //Managing the navigation states
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home_item -> {

                if (sharedViewModel.sideNavDrawerSelectedState.value == R.id.home_item) {
                    sharedViewModel.sideNavDrawerSelectedState.postValue(item.itemId)
                    binding.appBarMain.toolbar2.title = "Home"
                    Log.e("MyTag", binding.sideNavDrawer.checkedItem?.itemId.toString())
                    replaceFragment(HomeFragment())
                    visibleToolbarOne()
                }

            }

            R.id.history_item -> {
                sharedViewModel.sideNavDrawerSelectedState.value = item.itemId
                replaceFragment(HistoryFragment())
                binding.appBarMain.toolbar2.title = "History"
                visibleToolbarTwo()


            }

            R.id.favorite_item -> {
                sharedViewModel.sideNavDrawerSelectedState.value = item.itemId
                replaceFragment(FavoritesFragment())
                binding.appBarMain.toolbar2.title = "Favorite"
                visibleToolbarTwo()


            }

            R.id.settings_item -> {
                sharedViewModel.sideNavDrawerSelectedState.value = item.itemId
                replaceFragment(SettingsFragment())
                binding.appBarMain.toolbar2.title = "Settings"
                visibleToolbarTwo()


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
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) { //If nakabukas side nav drawer
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (supportFragmentManager.backStackEntryCount > 0) { //If may nakapatong
                when (sharedViewModel.currentFragmentTag.value) {
                    "StallsInfo" -> {
                        Log.e("MyTag", "clipeddd")
                    }

                }
                supportFragmentManager.popBackStack()


            } else if (binding.sideNavDrawer.checkedItem?.itemId != R.id.home_item) { //If hindi selected ang home item
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.nav_enter_anim,
                        R.anim.nav_exit_anim
                    )
                    .replace(R.id.navFragment, HomeFragment())
                    .commit()
                when (bottomNavViewModel.selectedItemId.value) {
                    R.id.bottomNavChat -> {
                        binding.appBarMain.toolbar.title = "Chat"
                    }

                    R.id.bottomNavTray -> {
                        binding.appBarMain.toolbar.title = "Tray"

                    }

                    R.id.bottomNavStalls -> {
                        binding.appBarMain.toolbar.title = "Stalls"

                    }

                    else -> {
                        binding.appBarMain.toolbar.title = "Home"

                    }
                }


            } else if (
                binding.sideNavDrawer.checkedItem?.itemId == R.id.home_item &&
                bottomNavViewModel.selectedItemId.value == R.id.bottomNavChat ||
                bottomNavViewModel.selectedItemId.value == R.id.bottomNavTray ||
                bottomNavViewModel.selectedItemId.value == R.id.bottomNavStalls
            ) {
                val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                bottomNavViewModel.selectedItemId.value = R.id.bottomNavHome
                binding.appBarMain.toolbar.title = "Home"
                bottomNavBar.selectedItemId = R.id.bottomNavHome
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.nav_enter_anim,
                        R.anim.nav_exit_anim
                    )
                    .replace(R.id.frameLayout, HomeHomeFragment())
                    .commit()
            }
            sharedViewModel.sideNavDrawerSelectedState.postValue(R.id.home_item)
            binding.sideNavDrawer.setCheckedItem(R.id.home_item)
        }
    }
}