package com.lbenedetto.stss.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lbenedetto.stss.R
import com.lbenedetto.stss.model.SearchRequest
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_search, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSearchPrimary.setOnClickListener(this::search)
        btnSearchSecondary.setOnClickListener(this::search)
    }

    private fun search(v: View) {
        SearchRequest(
            sivWordOrPhrase.getInputs(),
            sivCharacterSpeaker.getInputs(),
            sivCharacterListener.getInputs(),
            sivEpisode.getInputs(),
            sivLocation.getInputs()
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}
