package gyooha

class FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        var i = 0
        var firstValue = -1
        var secondValue = -1

        for (f in 0 until nums.size) {
            if (nums[f] == target) {
                firstValue = f
                break
            }
            i++
        }

        for (j in nums.size - 1 downTo i) {
            println(nums[j])
            if (nums[j] == target) {
                secondValue = j
                break
            }
        }

        return intArrayOf(firstValue, secondValue)
    }
}

private fun main() {
    FindFirstAndLastPositionOfElementInSortedArray().apply {
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).toList())
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).toList())
        println(searchRange(intArrayOf(0), 0).toList())
        /*    require(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentEquals(intArrayOf(3, 4)))
            require(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).contentEquals(intArrayOf(-1, -1)))
            require(searchRange(intArrayOf(), 0).contentEquals(intArrayOf(-1, -1)))*/
    }
}