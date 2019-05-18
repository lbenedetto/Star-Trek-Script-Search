package com.lbenedetto.stss.fragments.generate

enum class Series(private val seriesName: String, var currentEpisodeNum: Int) {
    TOS("StarTrek", 0),
    TNG("NextGen", 100),
    DS9("DS9", 400),
    VOY("Voyager", 100),
    ENT("Enterprise", 0);

    private val skippedEpisodeNums: HashMap<String, IntArray>
    //The script database has a few odd gaps in VOY's numbering, so we'll skip over those
    private val voyagerEpisodeGaps: HashMap<Int, Int>
    private var canGetNextEpisode: Boolean = false

    init {
        canGetNextEpisode = true
        //Initialize the HashMap of skipped episodes for each series
        skippedEpisodeNums = HashMap()
        skippedEpisodeNums["StarTrek"] = intArrayOf()
        skippedEpisodeNums["NextGen"] = intArrayOf(102)
        skippedEpisodeNums["DS9"] = intArrayOf(402, 474)
        skippedEpisodeNums["Voyager"] = intArrayOf()
        skippedEpisodeNums["Enterprise"] = intArrayOf(2)
        //Initialize the gaps in Voyagers production numbers
        voyagerEpisodeGaps = HashMap()
        voyagerEpisodeGaps[120] = 201
        voyagerEpisodeGaps[226] = 301
        voyagerEpisodeGaps[322] = 401
        voyagerEpisodeGaps[424] = 501
        voyagerEpisodeGaps[526] = 601
        voyagerEpisodeGaps[626] = 701
    }

    fun resetInstance() {
        currentEpisodeNum = when (this) {
            TOS -> 0
            TNG -> 100
            DS9 -> 400
            VOY -> 100
            else -> 0
        }
        canGetNextEpisode = true
    }

    override fun toString(): String {
        return seriesName
    }

    /**
     * Check if the current episode is the last episode of the series
     *
     * @return boolean
     */
    fun hasNextEpisode(): Boolean {
        canGetNextEpisode = true
        return when (this) {
            TOS -> currentEpisodeNum < 79
            TNG -> currentEpisodeNum < 277
            DS9 -> currentEpisodeNum < 575
            VOY -> currentEpisodeNum < 722
            ENT -> currentEpisodeNum < 98
        }
    }

    /**
     * If the current episode number is skipped, increment the current episode past the gap
     */
    private fun validateEpisodeNum() {
        skippedEpisodeNums[this.seriesName]?.forEach { skippedNum ->
            if (skippedNum == currentEpisodeNum)
                currentEpisodeNum++
        }

        if (this == VOY && voyagerEpisodeGaps.containsKey(currentEpisodeNum + 1))
            currentEpisodeNum = voyagerEpisodeGaps[currentEpisodeNum + 1]!!
    }

    fun moveToNextEpisode() {
        if (!canGetNextEpisode) throw IllegalStateException("Tried to get next episode without checking first")
        currentEpisodeNum++
        validateEpisodeNum()
        canGetNextEpisode = false
    }
}