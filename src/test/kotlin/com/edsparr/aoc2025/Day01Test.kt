package com.edsparr.aoc2025

import com.edsparr.aoc2025.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 01")
class Day01Test {

    private val input = listOf("L68","L30","R48","L5","R60","L55","L1","L99","R14","L82")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart1()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day01(resourceAsListOfString("Day01.txt")).solvePart1()
            assertThat(answer).isEqualTo(1023)
        }
    }

    //@Nested
    //@DisplayName("Part 2")
    //inner class Part2 {
    //    @Test
    //    fun `Matches example`() {
    //        val answer = Day01(input).solvePart2()
    //        assertThat(answer).isEqualTo(6)
    //    }
//
    //    @Test
    //    fun `Actual answer`() {
    //        val answer = Day01(resourceAsListOfString("Day01.txt")).solvePart2()
    //        assertThat(answer).isEqualTo(5299)
    //    }
    //}
}

