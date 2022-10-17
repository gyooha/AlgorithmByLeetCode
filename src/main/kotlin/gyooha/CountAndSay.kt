package gyooha

/*
*
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
* */
private class CountAndSay {
    fun countAndSay(n: Int): String {
        return cal(n, "1")
    }


    fun cal(n: Int, s: String): String {
        if (n == 1) return s

        var string = ""
        var previousString = s[0]
        var count = 1

        for (index in 1 until s.count()) {
            if (s[index] != previousString) {
                string = string + count + previousString
                count = 1
            } else {
                count++
            }

            previousString = s[index]
        }
        println("string : $string, count : $count, previousString : $previousString")
        string = string + count + previousString

        return cal(n - 1, string)
    }
}

private fun main() {
    CountAndSay().countAndSay(4)
}