package gyooha

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var lastIdx = 1
        var currentVal = nums[0]

        nums.forEachIndexed { index, _ ->
            if (nums[index] > currentVal) {
                currentVal = nums[index]
                nums[lastIdx] = nums[index]
                lastIdx++
            }
        }

        return lastIdx
    }
}

fun main() {
    RemoveDuplicatesFromSortedArray().apply {
        println(removeDuplicates(intArrayOf(1, 1, 2)))
    }
}