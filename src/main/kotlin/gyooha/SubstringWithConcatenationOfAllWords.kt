package gyooha

class SubstringWithConcatenationOfAllWords {
    /* fun findSubstring(s: String, words: Array<String>): List<Int> {
         if (words.isEmpty()) return emptyList()

         val result = mutableListOf<Int>()
         val wordLength = words[0].length
         s.forEachIndexed { i, _ ->
             val copyWords = words.toMutableList()
             var dummyIndex = i
             var roopSize = words.size
             while (roopSize != 0) {
                 val size = dummyIndex + wordLength
                 if (s.length >= size) {
                     val word = s.substring(dummyIndex until size)
                     if (!copyWords.contains(word) && roopSize == words.size) break

                     if (copyWords.contains(word)) {
                         copyWords.remove(word)
                     }
                     dummyIndex += wordLength
                 }
                 roopSize--
             }
             println()

             if (copyWords.isEmpty()) {
                 result.add(i)
             }
         }
         return result
     }*/

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val ml = mutableListOf<Int>()
        if (s.isEmpty()) return ml
        if (words.isEmpty()) return ml

        val w = words.sorted().groupingBy { it }.eachCount()
        val ws = words[0].length * words.size

        for (i in 0 until s.length - ws + 1) {
            if (
                s.substring(i until i + ws)
                    .chunked(words[0].length)
                    .sorted()
                    .groupingBy { it }
                    .eachCount() == w
            ) {
                ml.add(i)
            }
        }

        return ml
    }
}

fun main() {
    SubstringWithConcatenationOfAllWords().apply {
        println(findSubstring("barfoofoobarthefoobarman", arrayOf("bar", "foo", "the")))
        println(findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "good")))
        println(findSubstring("bcabbcaabbccacacbabccacaababcbb", arrayOf("c", "b", "a", "c", "a", "a", "a", "b", "c")))
    }
}