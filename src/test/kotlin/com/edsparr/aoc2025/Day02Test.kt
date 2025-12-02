package com.edsparr.aoc2025

import com.edsparr.aoc2025.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 02")
class Day02Test {

    private val input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example 1`() {
            val answer = Day02(input).solvePart1()
            assertThat(answer).isEqualTo(1227775554)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day02(resourceAsText("Day02.txt")).solvePart1()
            assertThat(answer).isEqualTo(23039913998)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example 1`() {
            val answer = Day02(input).solvePart2()
            assertThat(answer).isEqualTo(4174379265)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day02(resourceAsText("Day02.txt")).solvePart2()
            assertThat(answer).isEqualTo(35950619148)
        }
    }
}

