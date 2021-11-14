package gyooha

class RemoveElement {
    /*fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0
        val result = nums.filter { it != `val` }.size

        nums.forEachIndexed { index, _ ->
            var i = index
            var j = i + 1
            if (nums[i] == `val`) {
                while (j < nums.size) {
                    if (nums[j] != `val`) {
                        nums[i] = nums[j]
                        i++
                        j++
                    } else {
                        j++
                    }
                }
            }
        }

        println(nums.toList())
        return result
    }*/

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var size = 0
        nums.forEachIndexed { index, _ ->
            if (nums[index] != `val`) {
                nums[size++] = nums[index]
            }
        }

        return size
    }
}

fun main() {
    RemoveElement().apply {
        println(removeElement(intArrayOf(3, 2, 2, 3), 3))
        println(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
    }
}