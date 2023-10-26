package com.example.galantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.galantapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        MAIN = this


        binding.apply {
            toggle = ActionBarDrawerToggle(MAIN, drawer, R.string.open, R.string.close)
            drawer.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawer.open()
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.firstFragmentItem -> {
                    navController.navigate(R.id.firstFragment)
                    binding.drawer.close()
                }

                R.id.secondFragmentItem -> {
                    navController.navigate(R.id.secondFragment)
                    binding.drawer.close()
                }
                R.id.galleryFragmentItem -> {
                    navController.navigate(R.id.galleryFragment)
                    binding.drawer.close()
                }
            }
            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            true
        }
        return super.onOptionsItemSelected(item)
    }


}
