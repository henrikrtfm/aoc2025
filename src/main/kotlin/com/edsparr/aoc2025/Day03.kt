package com.edsparr.aoc2025

class Day03(private val input: List<String>) {

    private val batteryBanks: List<IntArray> = parseInput(input)

    fun solvePart1(): Long = batteryBanks.sumOf { batteryBank ->
        findBestJoltage(batteryBank, 2)
    }

    fun solvePart2(): Long = batteryBanks.sumOf { batteryBank ->
        findBestJoltage(batteryBank, 12)
    }

    private tailrec fun findBestJoltage(batteryBank: IntArray, amount: Int, offset: Int = 0, cumulativeResult: Long = 0): Long {
        val remaining = batteryBank.size - offset
        if (remaining == amount) {
            var result = cumulativeResult
            var i = offset
            while (i < batteryBank.size) {
                result = (result * 10L) + batteryBank[i]
                i++
            }
            return result
        }
        val searchEnd = batteryBank.size - amount + 1
        var max = batteryBank[offset]
        var index = offset
        if (max < 9) {
            var i = offset + 1
            while (i < searchEnd) {
                val current = batteryBank[i]
                if (current == 9) {
                    max = 9
                    index = i
                    break
                }
                if (current > max) {
                    max = current
                    index = i
                }
                i++
            }
        }
        val newResult = cumulativeResult * 10L + max
        if (amount == 1) return newResult
        return findBestJoltage(batteryBank, amount - 1, index + 1, newResult)
    }

    fun parseInput(input: List<String>): List<IntArray> =
        input.map { line ->
            IntArray(line.length) { i -> line[i].digitToInt() }
        }
}
