package com.example.testingexamples.managers

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class PasswordManagerTest{


    @Test
    fun `digita senha menor que 8 digitos, retorna erro de 8 digitos `() {
        val password = buildString {
            for (i in 1 until 8) {
                append(i)
            }
        }
        val result = PasswordManager.calculatePassword(password)

        assertThat(result.javaClass).isEqualTo(PasswordStatus.Invalid::class.java)
        assertThat((result as PasswordStatus.Invalid).types)
            .contains(InvalidTypes.Minimo8Charachters)
    }

    @Test
    fun `digita sem numeros, retorna erro de falta de numero `() {
        val password = buildString {
            for (i in 1 until 8) {
                append("a")
            }
        }
        val result = PasswordManager.calculatePassword(password)

        assertThat(result.javaClass).isEqualTo(PasswordStatus.Invalid::class.java)
        assertThat((result as PasswordStatus.Invalid).types)
            .contains(InvalidTypes.OneNumberMinimum)
    }

    @Test
    fun `se a senha tiver mais que 15 characteres, retorna erro de grande demais `() {
        val password = buildString {
            for (i in 1 until 17) {
                append("a")
            }
        }
        val result = PasswordManager.calculatePassword(password)

        assertThat(result.javaClass).isEqualTo(PasswordStatus.Invalid::class.java)
        assertThat((result as PasswordStatus.Invalid).types)
            .contains(InvalidTypes.GreaterThan15)
    }

    @Test
    fun `se a senha tiver nao conter caractere especial, retorna erro referente `() {
        val password = buildString {
            for (i in 1 until 8) {
                append("a")
            }
        }
        val result = PasswordManager.calculatePassword(password)

        assertThat(result.javaClass).isEqualTo(PasswordStatus.Invalid::class.java)
        assertThat((result as PasswordStatus.Invalid).types)
            .contains(InvalidTypes.OneSpecialCharacther)
    }


}