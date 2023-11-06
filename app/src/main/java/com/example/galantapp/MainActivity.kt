package com.example.galantapp

import android.graphics.Color
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

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val toggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(
            this@MainActivity,
            binding.drawer,
            R.string.open,
            R.string.close
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initWindowTransparency()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        initListeners()
    }

    /**
     * Инитит вьюхи
     */
    private fun initViews() {
        initDrawer()
    }

    private fun initDrawer() {
        with(binding) {
            drawer.addDrawerListener(toggle)
            toggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    /**
     * Ставит слушатели действий
     */
    private fun initListeners() {
        initDrawerNavigationListener()
    }

    private fun initDrawerNavigationListener() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.firstFragmentItem -> {
                    navController.navigate(R.id.firstFragment)
                }

                R.id.secondFragmentItem -> {
                    navController.navigate(R.id.secondFragment)
                }
                R.id.galleryFragmentItem -> {
                    navController.navigate(R.id.galleryFragment)
                }
            }
            binding.drawer.close()
            true
        }
    }

    private fun initWindowTransparency() {
        with(window) {
            navigationBarColor = Color.TRANSPARENT
            statusBarColor = Color.TRANSPARENT
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
