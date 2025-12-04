package com.edsparr.aoc2025

import com.edsparr.aoc2025.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 03")
class Day03Test {

    private val input = listOf("987654321111111","811111111111119","234234234234278","818181911112111")


    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example 1`() {
            val answer = Day03(input).solvePart1()
            assertThat(answer).isEqualTo(357)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day03(resourceAsListOfString("Day03.txt")).solvePart1()
            assertThat(answer).isEqualTo(17144)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example 1`() {
            val answer = Day03(input).solvePart2()
            assertThat(answer).isEqualTo(3121910778619)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day03(resourceAsListOfString("Day03.txt")).solvePart2()
            assertThat(answer).isEqualTo(170371185255900)
        }
    }
}

