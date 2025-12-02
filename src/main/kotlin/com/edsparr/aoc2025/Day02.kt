package com.edsparr.aoc2025

class Day02(private val input: String) {
    
    private companion object {
        private const val MIN_REPETITIONS = 2
        private const val HALF_DIVISOR = 2
    }
    private val idRanges = parse(input)

    fun solvePart1(): Long =
        idRanges.flatMap { (start, end) -> (start..end).map { it.toString() } }.sumOf { isInvalid(it) }

    fun solvePart2(): Long =
        idRanges.flatMap { (start, end) -> (start..end).map { it.toString() } }.sumOf { isInvalidMultiple(it) }

    private fun isInvalid(id: String): Long =
        if (id.length % HALF_DIVISOR != 0) 0L
        else {
            val halfLength = id.length / HALF_DIVISOR
            if (id.take(halfLength) == id.drop(halfLength)) id.toLong() else 0L
        }

    private fun isInvalidMultiple(id: String): Long =
        (1..id.length / HALF_DIVISOR)
            .map { id.take(it) }
            .firstOrNull { pattern -> matchesPattern(id, pattern) }
            ?.let { id.toLong() }
            ?: 0L

    private fun matchesPattern(id: String, pattern: String): Boolean {
        val repetitions = id.length / pattern.length
        return repetitions >= MIN_REPETITIONS && id.length % pattern.length == 0 && pattern.repeat(repetitions) == id
    }

    private fun parse(input: String): List<Pair<Long, Long>> =
        input.split(",").map { range ->
            range.split("-").let { parts -> parts[0].toLong() to parts[1].toLong() }
        }
}
