package com.lbenedetto.stss.model

data class SearchRequest(
    val wordsAndPhrases: List<String> = emptyList(),
    val speakingCharacters: List<String> = emptyList(),
    val listeningCharacters: List<String> = emptyList(),
    val episodes: List<String> = emptyList(),
    val locations: List<String> = emptyList()
)