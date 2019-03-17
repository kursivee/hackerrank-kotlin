package com.frosty.hackerrank.clouds_revisited

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CloudsRevisitedTest {

    val cloudsRevisited = CloudsRevisited()

    @Test
    fun `test`() {
        val ans = cloudsRevisited.jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 1, 1, 0), 2)
        assertEquals(ans, 92)
    }


    @Test
    fun `test 2`() {
        val ans = cloudsRevisited.jumpingOnClouds(arrayOf(1, 1, 1, 0, 1, 1, 0, 0, 0, 0
        ), 3)
        assertEquals(ans, 94)
    }
}