package com.frosty.hackerrank.beautiful_days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BeautifulDaysTest {
    val beautifulDays = BeautifulDays()

    @Test
    fun `when reverse 12 return 21`() {
        assertEquals(21, beautifulDays.reverse(12))
    }

    @Test
    fun `when reverse 120 return 21`() {
        assertEquals(21, beautifulDays.reverse(120))
    }
}