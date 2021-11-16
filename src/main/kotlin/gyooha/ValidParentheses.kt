package gyooha

import java.util.*

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
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
}

fun main() {
    require(ValidParentheses().isValid("()"))
    require(ValidParentheses().isValid("()[]{}"))
    require(!ValidParentheses().isValid("(]"))
}