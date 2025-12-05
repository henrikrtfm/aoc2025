package com.edsparr.aoc2025

class Day05(private val input: List<String>) {

    private val freshIngredientIdRanges: List<Pair<Long, Long>> = input
        .takeWhile { it.isNotEmpty() }
        .map { it.split("-")
        .let { (start, end) -> start.toLong() to end.toLong() } }

    private val ingredients: List<Long> = input
        .dropWhile { it.isNotEmpty() }
        .drop(1)
        .map { it.toLong() }

    fun solvePart1(): Int = ingredients.countFreshIngredients()

    fun solvePart2(): Long = mergeRanges(freshIngredientIdRanges).sumOf { it.second - it.first + 1 }

    private fun List<Long>.countFreshIngredients(): Int =
        map{ id -> freshIngredientIdRanges.any { range -> id in range.first..range.second } }
        .count { it }

    private fun mergeRanges(ranges: List<Pair<Long, Long>>): List<Pair<Long, Long>> {
        if (ranges.isEmpty()) return ranges
        
        // Sort ranges by start value
        val sortedRanges = ranges.sortedBy { it.first }
        
        // Merge ranges in a single pass using fold
        return sortedRanges.drop(1).fold(listOf(sortedRanges.first())) { mergedRanges, currentRange ->
            val lastMergedRange = mergedRanges.last()
            
            when {
                // Current range is contained in the last merged range -> skip it
                isContainedIn(currentRange, lastMergedRange) -> mergedRanges
                // Last merged range is contained in current range -> replace it
                isContainedIn(lastMergedRange, currentRange) -> mergedRanges.dropLast(1) + currentRange
                // Ranges overlap -> merge them
                overlaps(currentRange, lastMergedRange) -> {
                    val merged = minOf(currentRange.first, lastMergedRange.first) to 
                                maxOf(currentRange.second, lastMergedRange.second)
                    mergedRanges.dropLast(1) + merged
                }
                // No overlap -> add as new range
                else -> mergedRanges + currentRange
            }
        }
    }
    
    private fun overlaps(range1: Pair<Long, Long>, range2: Pair<Long, Long>): Boolean =
        range1.first <= range2.second && range1.second >= range2.first
    
    private fun isContainedIn(range1: Pair<Long, Long>, range2: Pair<Long, Long>): Boolean =
        range1.first > range2.first && range1.second < range2.second
}


