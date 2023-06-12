package com.example.myselfappshasbi

//Nama  : Muhammad Hasbi Ar-Rasid
//NIM   : 10120228
//Kelas : IF 6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.viewpager)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter

    }
}