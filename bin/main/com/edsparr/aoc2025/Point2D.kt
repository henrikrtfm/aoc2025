package com.edsparr.aoc2025

import kotlin.math.absoluteValue

data class Point2D(val x: Int, val y: Int) {

    fun cardinalNeighbors(): Set<Point2D> =
        setOf(
            this + NORTH,
            this + EAST,
            this + SOUTH,
            this + WEST
        )

    fun distanceTo(other: Point2D): Int =
        (x - other.x).absoluteValue + (y - other.y).absoluteValue

    operator fun div(by: Int): Point2D =
        Point2D(x / by, y / by)

    operator fun minus(other: Point2D): Point2D =
        Point2D(x - other.x, y - other.y)

    operator fun plus(other: Point2D): Point2D =
        Point2D(x + other.x, y + other.y)

    operator fun times(times: Int): Point2D =
        Point2D(x * times, y * times)

    companion object {
        val ORIGIN = Point2D(0, 0)
        val NORTH = Point2D(0, -1)
        val EAST = Point2D(1, 0)
        val SOUTH = Point2D(0, 1)
        val WEST = Point2D(-1, 0)

        fun of(input: String): Point2D =
            input.split(",").let {
                Point2D(it.first().toInt(), it.last().toInt())
            }
    }
}