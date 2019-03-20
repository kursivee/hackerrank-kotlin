package com.frosty.leetcode.decode_string

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeStringTest {
    val decoder = DecodeString()

    @Test
    fun `when decoding abc return "abc"`() {
        assertEquals("abc", decoder.decodeString("abc").str)
    }

    @Test
    fun `when decoding 3(a) return "aaa"`() {
        assertEquals("aaa", decoder.decodeString("3[a]").str)
    }

    @Test
    fun `when decoding 3(a)2(bc) return "aaabcbc"`() {
        assertEquals("aaabcbc", decoder.decodeString("3[a]2[bc]").str)
    }

    @Test
    fun `when decoding 3(a2(c)), return "accaccacc"`() {
        assertEquals("accaccacc", decoder.decodeString("3[a2[c]]").str)

    }

    @Test
    fun `when decoding 2(abc)3(cd)ef, return "abcabccdcdcdef"`() {
        assertEquals("abcabccdcdcdef", decoder.decodeString("2[abc]3[cd]ef").str)
    }

    @Test
    fun `when decoding 10(a), return "aaaaaaaaaa"`() {
        assertEquals("a".repeat(10), decoder.decodeString("10[a]").str)
    }

    @Test
    fun `when decoding slkjdf34(b), return "aaaaaaaaaa"`() {
        assertEquals("slkjdf" + "b".repeat(10), decoder.decodeString("slkjdf10[b]").str)
    }
}