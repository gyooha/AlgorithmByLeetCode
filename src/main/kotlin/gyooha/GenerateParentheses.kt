package gyooha

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        recursive("", n, n, result)
        return result
    }

    private fun recursive(str: String, left: Int, right: Int, acc: MutableList<String>) {
        when {
            left == 0 && right == 0 -> acc.add(str)
            else -> {
                if (left <= right && left != 0) recursive(str.plus('('), left - 1, right, acc)
                if (right != 0) recursive(str.plus(')'), left, right - 1, acc)
            }
        }
    }
}

fun main() {
    GenerateParentheses().apply {
        println(generateParenthesis(3))
        println(generateParenthesis(8))
    }
}