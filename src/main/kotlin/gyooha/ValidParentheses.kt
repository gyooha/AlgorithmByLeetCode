package gyooha

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = CustomStack()
        s.forEach { ch ->
            when (ch) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                else -> {
                    if (stack.isEmpty()) return false

                    if (stack.pop() != ch) return false
                }
            }
        }

        if (!stack.isEmpty()) return false
        return true
    }

    class CustomStack(s: String = "") {
        private var items = mutableListOf<Char>()
        init {
            s.forEach {
                items.add(it)
            }
        }

        fun push(c: Char) {
            items.add(c)
        }

        fun pop(): Char? {
            return when (items.isEmpty()) {
                true -> null
                false -> {
                    val lastItem = items.last()
                    items.removeAt(items.size - 1)
                    return lastItem
                }
            }
        }

        fun peek(): Char? = items.lastOrNull()

        fun isEmpty(): Boolean = items.isEmpty()
    }
}

fun main() {
    require(ValidParentheses().isValid("()"))
    require(ValidParentheses().isValid("()[]{}"))
    require(!ValidParentheses().isValid("(]"))
}