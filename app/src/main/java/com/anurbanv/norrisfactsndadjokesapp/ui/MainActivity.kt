package com.anurbanv.norrisfactsndadjokesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.anurbanv.norrisfactsndadjokesapp.R
import com.anurbanv.norrisfactsndadjokesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = getString(R.string.landing_fragment_title)

        navController = Navigation.findNavController(this, R.id.navigationHost)

        binding.toolbar.setupWithNavController(navController)
    }
}