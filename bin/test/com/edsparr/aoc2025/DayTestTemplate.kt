package com.edsparr.aoc2025

import com.edsparr.aoc2025.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day X")
class DayXTest {

    private val input = listOf<String>()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example 1`() {
            val answer = DayX(input).solvePart1()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        fun `Actual answer`() {
            val answer = DayX(resourceAsListOfString("DayX.txt")).solvePart1()
            assertThat(answer).isEqualTo(0)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example 1`() {
            val answer = DayX(input).solvePart2()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        fun `Actual answer`() {
            val answer = DayX(resourceAsListOfString("DayX.txt")).solvePart2()
            assertThat(answer).isEqualTo(0)
        }
    }
}