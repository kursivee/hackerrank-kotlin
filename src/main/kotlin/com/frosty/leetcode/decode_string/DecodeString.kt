package com.frosty.leetcode.decode_string

class DecodeString {
    /*

    s = "abc", return "abc"
    s = "3[a]", return "aaa"
    s = "3[a]2[bc]", return "aaabcbc".
    s = "3[a2[c]]", return "accaccacc".
    s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

     */
    fun decodeString(s: String, repeat: Int = 1) : Container {
        var str = ""
        var i = 0
        var nextIndex = -1
        println("decoding s: $s")
        while(i < s.length) {
            val char = s[i]
            println("char: $char")
            if(char == ']') {
                str = str.repeat(repeat)
                nextIndex = s.length - i
                break
            } else if(char.isDigit()) {
                println("indexes: $i, ${s.substring(i, s.length).indexOf('[')}")
                val digitContainer = getDigit(s.substring(i, s.length))
                val digit = digitContainer.str.toInt()
                if(digit >= 10) {
                    i += digitContainer.offset
                }
                val container = decodeString(s.substring(s.substring(i, s.length).indexOf('[') + i + 1, s.length), digit)
                str += container.str
                i = s.length - container.offset
            } else {
                str += char
            }
            i++
        }
        println("Returning: $str")
        return Container(str, nextIndex)
    }

    fun getDigit(s: String) : Container {
        var digit = ""
        s.forEachIndexed { i, it ->
            if(it == '[')
                return Container(digit, i - 1)
            digit += it
        }
        return Container("",0)
    }

    data class Container(val str: String, val offset: Int)
}