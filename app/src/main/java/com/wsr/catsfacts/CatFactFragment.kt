package com.wsr.catsfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wsr.catsfacts.api.cats.CatsAPI
import com.wsr.catsfacts.api.cats.models.CatFact
import com.wsr.catsfacts.databinding.FragmentCatFactBinding

class CatFactFragment : Fragment() {
    private lateinit var binding: FragmentCatFactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatFactBinding.inflate(layoutInflater, container, false)
        fillFact()
        return binding.root
    }

    private fun fillFact() {
        getFactData { catFact ->
            activity?.runOnUiThread { setFields(catFact) }
        }
    }

    private fun setFields(catFact: CatFact) {
        binding.factText.text = catFact.fact
        binding.lengthText.text = catFact.length.toString()
    }

    private fun getFactData(callback: (cf: CatFact) -> Unit) {
        Thread { CatsAPI.getFact(callback) }.start()
    }
}