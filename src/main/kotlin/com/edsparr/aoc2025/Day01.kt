package com.edsparr.aoc2025

import kotlin.math.absoluteValue

class Day01(private val input: List<String>) {
    
    private companion object {
        private const val SAFE = 100
        private const val INITIAL_POINTER = 50
    }
    private val rotations = input.map { parse(it) }

    fun solvePart1(): Int =
        rotations.runningFold(INITIAL_POINTER) { pointer, rotation ->
            (pointer + rotation) % SAFE
        }
            .count { it == 0 }

    fun solvePart2(): Int =
        rotations.runningFold(INITIAL_POINTER to 0) { (pointer, counter), rotation ->
            val newPointer = (pointer + rotation) % SAFE
            val rotationCounter = rotate(pointer, counter + rotation)
            newPointer to rotationCounter
        }
            .sumOf { it.component2() }

    private fun rotate(currentIndex: Int, rotation: Int): Int = when {
        currentIndex < rotation -> (rotation.floorDiv(SAFE) - currentIndex.floorDiv(SAFE)).absoluteValue
        currentIndex > rotation -> rotate(-currentIndex, -rotation)
        else -> 0
    }

    private fun parse(input: String): Int = when (input.first()) {
        'R' -> input.drop(1).toInt()
        'L' -> -input.drop(1).toInt()
        else -> throw IllegalArgumentException("Direction must be 'L' or 'R'")
    }
}
