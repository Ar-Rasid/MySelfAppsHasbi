package com.example.myselfappshasbi

//Nama  : Muhammad Hasbi Ar-Rasid
//NIM   : 10120228
//Kelas : IF 6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainViewActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Tampilkan fragment home
                    val fragment = HomeFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.daily -> {
                    // Tampilkan fragment daily
                    val fragment = DailyFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.gallery -> {
                    // Tampilkan fragment gallery
                    val fragment = GalleryFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.music -> {
                    // Tampilkan fragment music
                    val fragment = MusicFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    // Tampilkan fragment profile
                    val fragment = ProfileFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        // Tampilkan fragment home saat aplikasi pertama kali dijalankan
        val fragment = HomeFragment()
        loadFragment(fragment)

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}