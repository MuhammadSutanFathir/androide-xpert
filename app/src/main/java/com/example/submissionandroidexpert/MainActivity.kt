package com.example.submissionandroidexpert

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.submissionandroidexpert.databinding.ActivityMainBinding
import com.example.submissionandroidexpert.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.cherry_rush)

        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> loadFragment(HomeFragment())
                R.id.navigation_favorite -> {
                    val uri = Uri.parse("example://favorite")
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                }
            }
            true
        }

        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }
    override fun onResume() {
        super.onResume()
        binding.navView.selectedItemId = R.id.navigation_home
    }


    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .commit()
    }
}