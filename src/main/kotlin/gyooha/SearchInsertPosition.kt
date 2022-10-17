package gyooha

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0

        val halfIndex = nums.size / 2
        val middleValue = nums[nums.size / 2]

        if (middleValue > target) {
            for (i in nums.indices) {
                when {
                    nums[i] > target -> return i
                    nums[i] == target -> return i
                    nums[i + 1] == target || nums[i + 1] > target -> return i + 1
                }

            }
        } else {
            for (i in nums.size - 1 downTo halfIndex) {
                when {
                    nums[i] < target -> return i + 1
                    nums[i] == target -> return i
                    nums[i - 1] == target || nums[i - 1] < target -> i - 1
                }
            }
        }

        return 0
    }
}

private fun main() {
    SearchInsertPosition().apply {
        println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
        println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
        println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
        println(searchInsert(intArrayOf(1, 3, 5, 6), 0))
    }
}