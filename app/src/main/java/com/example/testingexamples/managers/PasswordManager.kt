package com.example.testingexamples.managers

import com.example.testingexamples.R
import com.example.testingexamples.ValidationUtils.isContainsDigit
import com.example.testingexamples.ValidationUtils.isContainsSpecialCharachter

object PasswordManager {

    fun calculatePassword(password: String) : PasswordStatus {
        val types = mutableListOf<InvalidTypes>()

        if (password.length < 8) {
            types.add(InvalidTypes.Minimo8Charachters)
        }

        if (isContainsDigit(password).not()) {
            types.add(InvalidTypes.OneNumberMinimum)
        }

        if (password.length > 15) {
            types.add(InvalidTypes.GreaterThan15)
        }

        if (isContainsSpecialCharachter(password).not()) {
            types.add(InvalidTypes.OneSpecialCharacther)
        }

        if (types.isNotEmpty())
            return PasswordStatus.Invalid(types)


        return PasswordStatus.Valid(StrengthLevel.STRONG)
    }

}




sealed class PasswordStatus {

    class Invalid(
        val types: List<InvalidTypes>
        ) : PasswordStatus()

    class Valid(
        val strengthLevel: StrengthLevel
    ) : PasswordStatus()

}


// Weak = Requerimentos minimos
// Medium = Mais que 8 caracteres
// Strong = Mais que 10 caracteres
enum class StrengthLevel(val color: Int) {
    NONE(android.R.color.transparent),
    WEAK(R.color.password_strength_weak),
    MEDIUM(R.color.password_strength_medium),
    STRONG(R.color.password_strength_strong)
}

enum class InvalidTypes(val reason: String) {
    Minimo8Charachters("No minimo 8 caracteres"),
    OneNumberMinimum("Ao menos 1 numero"),
    OneSpecialCharacther("Ao um character especial"),
    GreaterThan15("Maior que 15 caracteres")
}