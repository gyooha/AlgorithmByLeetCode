package gyooha

class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        if (s.isEmpty() || s.length == 1) return 0
        val stack = java.util.Stack<Int>()
        var count = 0
        stack.push(-1)
        s.forEachIndexed { index, c ->
            when (c) {
                '(' -> {
                    stack.push(index)
                }
                ')' -> {
                    stack.pop()
                    if (stack.isEmpty()) {
                        stack.push(index)
                    } else {
                        count = maxOf(count, index - stack.peek())
                    }
                }
            }
        }

        return count
    }
}

fun main() {
    LongestValidParentheses().apply {
//        println(longestValidParentheses("(()"))
//        println(longestValidParentheses(")()())"))
        println(longestValidParentheses("()(()"))
//        println(longestValidParentheses("()(())"))
    }
}