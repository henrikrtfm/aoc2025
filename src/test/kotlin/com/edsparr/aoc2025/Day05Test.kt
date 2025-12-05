package com.edsparr.aoc2025

import com.edsparr.aoc2025.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 05")
class Day05Test {

    private val input = """
    3-5
    10-14
    16-20
    12-18

    1
    5
    8
    11
    17
    32
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example 1`() {
            val answer = Day05(input).solvePart1()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day05(resourceAsListOfString("Day05.txt")).solvePart1()
            assertThat(answer).isEqualTo(761)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example 1`() {
            val answer = Day05(input).solvePart2()
            assertThat(answer).isEqualTo(14)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day05(resourceAsListOfString("Day05.txt")).solvePart2()
            assertThat(answer).isEqualTo(345755049374932)
        }
    }
}

