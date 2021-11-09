package com.example.bottomnavigationdanfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageFragment = imageFragment()
        val mailFragment = mailFragment()
        val settingFragment = settingFragment()
        val whatsappFragment = whatsappFragment()

        makeCurrentFragment(imageFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemImage -> makeCurrentFragment(imageFragment)
                R.id.itemMail -> makeCurrentFragment(mailFragment)
                R.id.itemSettings -> makeCurrentFragment(settingFragment)
                R.id.itemWhatsApp -> makeCurrentFragment(whatsappFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.content, fragment)
            commit()
        }
    }
}