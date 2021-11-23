package com.example.testingexamples

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ValidationUtilsTest {


    @Test
    fun `validate function isDigitOnly works correctly`() {
        val stringWithNumber = "teste123"
        val stringWithNumber2 = "1teste"

        val stringWithoutNumber = "teste"

        assertThat(ValidationUtils.isContainsDigit(stringWithNumber)).isTrue()

        assertThat(ValidationUtils.isContainsDigit(stringWithNumber2)).isTrue()

        assertThat(ValidationUtils.isContainsDigit(stringWithoutNumber)).isFalse()
    }

    @Test
    fun `validate function isContainsSpecialCharacter` () {

        val stringWithSpecialCharacter = "te %ste!"

        val stringWithoutSpecialCharacter = "t este"
        val stringWithoutSpecialCharacter2 = "t2este"

        assertThat(ValidationUtils.isContainsSpecialCharachter(stringWithSpecialCharacter)).isTrue()
        assertThat(ValidationUtils.isContainsSpecialCharachter(stringWithoutSpecialCharacter)).isFalse()
        assertThat(ValidationUtils.isContainsSpecialCharachter(stringWithoutSpecialCharacter2)).isFalse()
    }

}