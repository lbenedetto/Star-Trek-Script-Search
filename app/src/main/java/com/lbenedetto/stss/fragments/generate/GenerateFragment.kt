package com.lbenedetto.stss.fragments.generate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lbenedetto.stss.R
import com.lbenedetto.stss.fragments.search.SearchFragment

class GenerateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_generate, null)
    }

    companion object {
        @JvmStatic
        fun newInstance() = GenerateFragment()
    }
}
