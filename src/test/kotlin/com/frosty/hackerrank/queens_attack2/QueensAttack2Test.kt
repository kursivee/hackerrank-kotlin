package com.frosty.hackerrank.queens_attack2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueensAttack2Test {
    private val queensAttack2 = QueensAttack2()

    @Test
    fun `when n has no block when pos is 8 it should return 4`() {
        val n = queensAttack2.calcLine(4, 8)
        assertEquals(4, n)
    }

    @Test
    fun `when s has no block when pos is 1 it should return 3`() {
        val n = queensAttack2.calcLine(4, 1)
        assertEquals(3, n)
    }

    @Test
    fun `when queen (4,4) when end (8,8) it should return 4`() {
        val n = queensAttack2.calcDiagonal((4 to 4), (8 to 8))
        assertEquals(n, 4)
    }

    @Test
    fun `when queen (4,4) when end (1,7) it should return 3`() {
        val n = queensAttack2.calcDiagonal((4 to 4), (1 to 7))
        assertEquals(n, 3)
    }

    @Test
    fun `when queen (4,4) when end (1,1) it should return 3`() {
        val n = queensAttack2.calcDiagonal((4 to 4), (1 to 1))
        assertEquals(n, 3)
    }

    @Test
    fun `when queen (4,4) when end (7,1) it should return 3`() {
        val n = queensAttack2.calcDiagonal((4 to 4), (7 to 1))
        assertEquals(n, 3)
    }

    @Test
    fun `when creating points when board size is 8 when queen pos is (4, 4) it should return mapOf`() {
        val expected = mapOf(
                "N" to (4 to 8),
                "S" to (4 to 1),
                "E" to (8 to 4),
                "W" to (1 to 4),
                "NE" to (8 to 8),
                "NW" to (1 to 7),
                "SE" to (7 to 1),
                "SW" to (1 to 1)
        )
        val ans = queensAttack2.createEndpoints(8, (4 to 4))
        assertEquals(expected, ans)
    }

    @Test
    fun `when creating points when board size is 5 when queen pos is (4, 4) it should return mapOf`() {
        val expected = mapOf(
                "N" to (3 to 5),
                "S" to (3 to 1),
                "E" to (5 to 4),
                "W" to (1 to 4),
                "NE" to (4 to 5),
                "NW" to (2 to 5),
                "SE" to (5 to 2),
                "SW" to (1 to 2)
        )
        val ans = queensAttack2.createEndpoints(5, (3 to 4))
        assertEquals(expected, ans)
    }

    @Test
    fun `when solve when boardsize is 8 when queen pos is (4, 4) it should return 27`() {
        val ans = queensAttack2.solve((4 to 4), 8)
        assertEquals(27, ans)
    }

    @Test
    fun `when solve when boardsize is 8 when queen pos is (4, 4) with obstacles it should return 24`() {
        val ans = queensAttack2.solve((4 to 4), 8, arrayOf((5 to 3)))
        assertEquals(24, ans)
    }

    @Test
    fun `when solve when boardsize is 5 when queen pos is (4, 3) with obstacles it should return 10`() {
        val ans = queensAttack2.solve((3 to 4), 5, arrayOf((5 to 5), (2 to 4), (3 to 2)))
        assertEquals(10, ans)
    }

    @Test
    fun `when solve when boardsize is 4 when queen pos is (4, 4) it should return 10`() {
        val ans = queensAttack2.solve((4 to 4), 4)
        assertEquals(9, ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is (1, 7) it should return true`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (1 to 7))
        assertTrue(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is NE it should return true`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (5 to 5))
        assertTrue(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is NW it should return true`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (7 to 4))
        assertTrue(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is SW it should return true`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (3 to 3))
        assertTrue(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is SE it should return true`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (5 to 3))
        assertTrue(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is !NE it should return false`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (5 to 6))
        assertFalse(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is !NW it should return false`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (5 to 6))
        assertFalse(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is !SW it should return false`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (3 to 2))
        assertFalse(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is !SE it should return false`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (6 to 3))
        assertFalse(ans)
    }

    @Test
    fun `when isValidPoint when queen pos is (4, 4) when point is == it should return false`() {
        val ans = queensAttack2.isValidPoint((4 to 4), (4 to 4))
        assertFalse(ans)
    }

    @Test
    fun `when given map when queen pos is (4,4) when board size is 8 when replacing (5, 3) it should replace SE`() {
        val map = mutableMapOf(
                "N" to (4 to 8),
                "S" to (4 to 1),
                "E" to (8 to 4),
                "W" to (1 to 4),
                "NE" to (8 to 8),
                "NW" to (1 to 7),
                "SE" to (7 to 1),
                "SW" to (1 to 1)
        )

        val expected = mapOf(
                "N" to (4 to 8),
                "S" to (4 to 1),
                "E" to (8 to 4),
                "W" to (1 to 4),
                "NE" to (8 to 8),
                "NW" to (1 to 7),
                "SE" to (5 to 3),
                "SW" to (1 to 1)
        )

        val ans = queensAttack2.replacePoint(map, (4 to 4), (5 to 3))
        assertEquals(expected, ans)
    }
    @Test
    fun `when given map when queen pos is (3, 4) when board size is 5 when replacing points`() {
        val map = mutableMapOf(
                "N" to (3 to 5),
                "S" to (3 to 1),
                "E" to (5 to 4),
                "W" to (1 to 4),
                "NE" to (4 to 5),
                "NW" to (2 to 5),
                "SE" to (1 to 2),
                "SW" to (5 to 2)
        )

        val expected = mapOf(
                "N" to (3 to 5),
                "S" to (3 to 2),
                "E" to (5 to 4),
                "W" to (2 to 4),
                "NE" to (4 to 5),
                "NW" to (2 to 5),
                "SE" to (1 to 2),
                "SW" to (5 to 2)
        )

        val ans = queensAttack2.replacePoint(map, (3 to 4), (3 to 1)).also {
            queensAttack2.replacePoint(it, (3 to 4), (2 to 4)).also {
                queensAttack2.replacePoint(it, (3 to 4), (3 to 2))
            }
        }
        assertEquals(expected, ans)
    }

    @Test
    fun `when hackerrank solve when boardsize is 8 when queen pos is (4, 4) it should return 27`() {
        val array = arrayOf(
                arrayOf(5, 3)
        )
        val ans = queensAttack2.queensAttack(8, 0, 4, 4, array)
        assertEquals(24, ans)
    }
}


