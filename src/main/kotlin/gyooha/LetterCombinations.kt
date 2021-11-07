package gyooha

class LetterCombinations {
    private val phoneMapper = mapOf(
        '2' to listOf("a", "b", "c"),
        '3' to listOf("d", "e", "f"),
        '4' to listOf("g", "h", "i"),
        '5' to listOf("j", "k", "l"),
        '6' to listOf("m", "n", "o"),
        '7' to listOf("p", "q", "r", "s"),
        '8' to listOf("t", "u", "v"),
        '9' to listOf("w", "x", "y", "z")
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return listOf()
        if (digits.length == 1) return phoneMapper[digits.first()] ?: listOf()

        val base = phoneMapper[digits.first()] ?: emptyList()
        val result = mutableListOf<String>()
        base.forEach { s ->
            result.addAll(composeChar(s, digits.drop(1)))
        }

        return result
    }

    private fun composeChar(digitChars: String, remainingDigis: String): List<String> = when {
        remainingDigis.isEmpty() -> listOf(digitChars)
        else -> {
            val result = mutableListOf<String>()
            phoneMapper[remainingDigis.first()]?.forEach { s ->
                result.addAll(composeChar(digitChars + s, remainingDigis.drop(1)))
            }

            result
        }
    }
}