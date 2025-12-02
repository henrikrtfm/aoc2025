package com.edsparr.aoc2025

fun main() {
    val input = Resources.resourceAsListOfString("Day01.txt")
    val day01 = Day01(input)
    println("Part 1: ${day01.solvePart1()}")
    println("Part 2: ${day01.solvePart2()}")
}