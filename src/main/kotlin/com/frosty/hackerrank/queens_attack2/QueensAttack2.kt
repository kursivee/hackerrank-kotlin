package com.frosty.hackerrank.queens_attack2

import kotlin.math.sqrt

class QueensAttack2 {

    var north = 0
    var s = 0
    var e = 0
    var w = 0
    var nw = 0
    var ne = 0
    var sw = 0
    var se = 0
    fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {
        val x = obstacles.map {
            (it[1] to it[0])
        }.toTypedArray()
        return solve((c_q to r_q), n, x)
    }

    fun solve(queenPos: Pair<Int, Int>, n: Int, obstacles: Array<Pair<Int, Int>>? = null) : Int {
        var sum = 0
        createEndpoints(n, queenPos)
            .also {
                obstacles?.forEach { obstacle ->
                    if(isValidPoint(queenPos, obstacle)) {
                        replacePoint(it, queenPos, obstacle)
                    }
                }
            }
            .forEach { t, u ->
                when(t) {
                    "N", "S" -> sum += calcLine(queenPos.second, u.second)
                    "E", "W" -> sum += calcLine(queenPos.first, u.first)
                    "NW", "NE", "SW", "SE" -> sum += calcDiagonal(queenPos, u)
                    else -> print("BAD")
                }
        }
        return sum - (north + s + w + e + nw + ne + sw + se)
    }

    fun calcLine(queenStart: Int, y: Int) : Int {
        return Math.abs(y - queenStart)
    }

    fun calcDiagonal(queenStart: Pair<Int, Int>, point: Pair<Int, Int>) : Int {
        val xDiff = Math.abs(queenStart.first - point.first)
        val yDiff = Math.abs(queenStart.second - point.second)
        return Math.min(xDiff, yDiff)
    }

    fun createDiagonalNEPoint(queenPos: Pair<Int, Int>, n: Int) : Pair<Int, Int> {
        val xDiff = Math.abs(queenPos.first - n)
        val yDiff = Math.abs(queenPos.second - n)
        val offSet = Math.min(xDiff, yDiff)
        return (queenPos.first + offSet to queenPos.second + offSet)
    }

    fun createDiagonalNWPoint(queenPos: Pair<Int, Int>, point: Pair<Int, Int>) : Pair<Int, Int> {
        val offSet = calcDiagonal(queenPos, point)
        return (queenPos.first - offSet to queenPos.second + offSet)
    }

    fun createDiagonalSWPoint(queenPos: Pair<Int, Int>, point: Pair<Int, Int>) : Pair<Int, Int> {
        val offSet = calcDiagonal(queenPos, point)
        return (queenPos.first - offSet to queenPos.second - offSet)
    }

    fun createDiagonalSEPoint(queenPos: Pair<Int, Int>, point: Pair<Int, Int>) : Pair<Int, Int> {
        val offSet = calcDiagonal(queenPos, point)
        return (queenPos.first + offSet to queenPos.second - offSet)
    }

    fun createEndpoints(n: Int, queenPos: Pair<Int, Int>) : MutableMap<String, Pair<Int, Int>> {
        val map = mutableMapOf(
            "N" to (queenPos.first to n),
            "S" to (queenPos.first to 1),
            "E" to (n to queenPos.second),
            "W" to (1 to queenPos.second),
            "NE" to (createDiagonalNEPoint(queenPos, n)),
            "NW" to (createDiagonalNWPoint(queenPos, (1 to n))),
            "SE" to (createDiagonalSEPoint(queenPos, (n to 1))),
            "SW" to (createDiagonalSWPoint(queenPos, (1 to 1)))
        )
        return map
    }

    fun isValidPoint(queenPos: Pair<Int, Int>, point: Pair<Int, Int>) : Boolean =
        when {
            (queenPos == point) -> false
            (queenPos.first == point.first || queenPos.second == point.second) -> true
            (Math.abs(queenPos.first - point.first) == Math.abs(queenPos.second - point.second)) -> true
            else -> false
        }

    fun replacePoint(map: MutableMap<String, Pair<Int, Int>>, queenPos: Pair<Int, Int>, point: Pair<Int, Int>) : MutableMap<String, Pair<Int, Int>>{
        if(queenPos.first == point.first) {
            if(queenPos.second > point.second) {
                if(queenPos.dist(point) < queenPos.dist(map["S"]!!)) {
                    s = 1
                    map["S"] = point
                }
            } else {
                if(queenPos.dist(point) < queenPos.dist(map["N"]!!)) {
                    north = 1
                    map["N"] = point
                }
            }
        } else if(queenPos.second == point.second) {
            if(queenPos.first > point.first) {
                if(queenPos.dist(point) < queenPos.dist(map["W"]!!)) {
                    w = 1
                    map["W"] = point
                }

            } else {
                if(queenPos.dist(point) < queenPos.dist(map["E"]!!)) {
                    e = 1
                    map["E"] = point
                }
            }
        } else if(queenPos.first > point.first) {
            if(queenPos.second > point.second) {
                if(queenPos.dist(point) < queenPos.dist(map["SW"]!!)) {
                    sw = 1
                    map["SW"] = point
                }
            } else {
                if(queenPos.dist(point) < queenPos.dist(map["NW"]!!)) {
                    nw = 1
                    map["NW"] = point

                }
            }
        } else {
            if(queenPos.second > point.second) {
                if(queenPos.dist(point) < queenPos.dist(map["SE"]!!)) {
                    se = 1
                    map["SE"] = point
                }
            } else {
                if(queenPos.dist(point) < queenPos.dist(map["NE"]!!)) {
                    ne = 1
                    map["NE"] = point
                }
            }
        }
        return map
    }


    fun Pair<Int, Int>.dist(p1: Pair<Int, Int>) : Double {
        return sqrt(Math.pow(p1.first - first.toDouble(), 2.0) + Math.pow(p1.second - second.toDouble(), 2.0))
    }
}