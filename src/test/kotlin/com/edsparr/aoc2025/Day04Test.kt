package com.edsparr.aoc2025

import com.edsparr.aoc2025.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 04")
class Day04Test {

    private val input = """
    ..@@.@@@@.
    @@@.@.@.@@
    @@@@@.@.@@
    @.@@@@..@.
    @@.@@@@.@@
    .@@@@@@@.@
    .@.@.@.@@@
    @.@@@.@@@@
    .@@@@@@@@.
    @.@.@@@.@.
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example 1`() {
            val answer = Day04(input).solvePart1()
            assertThat(answer).isEqualTo(13)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day04(resourceAsListOfString("Day04.txt")).solvePart1()
            assertThat(answer).isEqualTo(1578)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example 1`() {
            val answer = Day04(input).solvePart2()
            assertThat(answer).isEqualTo(43)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day04(resourceAsListOfString("Day04.txt")).solvePart2()
            assertThat(answer).isEqualTo(10132)
        }
    }
}

