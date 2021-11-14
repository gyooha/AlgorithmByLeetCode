package gyooha

class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.isEmpty() && needle.isEmpty()) return 0
        val needleCount = needle.length

        for (i in haystack.indices) {
            if (i + needleCount <= haystack.length) {
                val result = haystack.substring(i until i + needleCount)

                if (result == needle) {
                    return i
                }
            }
        }
        return -1
    }
}

fun main() {
    ImplementStrStr().apply {
        println(strStr("hello", "ll"))
        println(strStr("aaaaa", "bba"))
        println(strStr("a", "a"))
    }
}