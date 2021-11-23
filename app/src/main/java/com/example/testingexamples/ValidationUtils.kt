package com.example.testingexamples

object ValidationUtils {

    fun isContainsDigit(str: CharSequence): Boolean {
        val len = str.length
        var i = 0
        while (i < len) {
            val char = str[i]
            if (Character.isDigit(char)) {
                return true
            }
            i++
        }
        return false
    }

    fun isContainsSpecialCharachter(stringWithSpecialCharacter: String): Boolean {
        return stringWithSpecialCharacter
            .replace(" ", "").any { it.isLetterOrDigit().not() }
    }

}