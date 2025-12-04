package com.edsparr.aoc2025

class Day04(private val input: List<String>) {

    private val warehouse: List<CharArray> = input.map { it.toCharArray() }

    fun solvePart1(): Int =
        warehouse.findAll('@').count { isRollAccessible(it) }

    fun solvePart2(): Int =
        generateSequence(warehouse.map { it.clone() } to 0) { (currentWarehouse, _) ->
            val removableRolls = currentWarehouse.findAll('@').filter { isRollAccessible(it, currentWarehouse) }
            if (removableRolls.isEmpty()) null
            else removeRolls(currentWarehouse, removableRolls) to removableRolls.size
        }
            .sumOf { it.second }

    private fun removeRolls(warehouse: List<CharArray>, removableRolls: List<Point2D>): List<CharArray> {
        val removableRollsSet = removableRolls.toSet()
        return warehouse.mapIndexed { y, row ->
            row.mapIndexed { x, char ->
                if (Point2D(x, y) in removableRollsSet) '.' else char
            }.toCharArray()
        }
    }

    private fun isRollAccessible(roll: Point2D, currentWarehouse: List<CharArray> = warehouse): Boolean {
        val neighbors = roll.neighbors().filter { currentWarehouse.isSafe(it) }.map { currentWarehouse[it] }
        return (neighbors.count { it == '.' } + 8 - neighbors.size) > 4
    }

    private fun List<CharArray>.findAll(target: Char): List<Point2D> =
        flatMapIndexed { y, row ->
            row.mapIndexed { x, c ->
                if (c == target) Point2D(x, y) else null
            }
        }.filterNotNull()
}
