package com.edsparr.aoc2025

tailrec fun Long.gcd(other: Long): Long =
    if (other == 0L) this
    else other.gcd(this % other)

fun Long.lcm(other: Long): Long =
    (this * other) / this.gcd(other)

fun <T> List<T>.midpoint(): T =
    this[lastIndex / 2]

operator fun List<CharArray>.get(at: Point2D): Char =
    this[at.y][at.x]

operator fun List<CharArray>.set(at: Point2D, value: Char) {
    this[at.y][at.x] = value
}

fun List<CharArray>.isSafe(at: Point2D) =
    at.y in this.indices && at.x in this[at.y].indices

fun List<String>.findSingle(target: Char): Point2D =
    flatMapIndexed { y, row ->
        row.mapIndexedNotNull { x, c ->
            if (c == target) Point2D(x, y) else null
        }
    }.first()

fun <T> List<T>.binarySearchFirst(fn: (T) -> Boolean): T =
    binarySearchFirstOrNull(fn) ?:
        throw IllegalStateException("No elements match predicate")

fun <T> List<T>.binarySearchFirstOrNull(fn: (T) -> Boolean): T? =
    binarySearchIndexOfFirstOrNull(fn)?.let { get(it) }

fun <T> List<T>.binarySearchIndexOfFirst(fn: (T) -> Boolean): Int =
    binarySearchIndexOfFirstOrNull(fn) ?:
        throw IllegalStateException("No elements match predicate")

fun <T> List<T>.binarySearchIndexOfFirstOrNull(fn: (T) -> Boolean): Int? {
    var low = 0
    var high = lastIndex
    var firstFind: Int? = null
    while (low <= high) {
        val mid = (low + high) shr 1
        if (fn(get(mid))) {
            firstFind = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return firstFind
}