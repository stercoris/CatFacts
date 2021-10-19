package com.wsr.catsfacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wsr.catsfacts.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.getRandomCatFact.setOnClickListener {
            addFragmentToFactsList(CatFactFragment())
        }
    }

    private fun addFragmentToFactsList(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(binding.factsScrollView.id, fragment)
            .commit()
    }

}