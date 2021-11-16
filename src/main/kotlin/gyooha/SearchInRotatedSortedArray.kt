package gyooha

class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = (left + right) / 2

            when {
                nums[mid] == target -> return mid
                nums[left] <= nums[mid] -> {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid - 1
                    } else {
                        left = mid + 1
                    }
                }
                else -> {
                    if (nums[mid] <= nums[right]) {
                        if (nums[mid] <= target && nums[right] >= target) {
                            left = mid + 1
                        } else {
                            right = mid - 1
                        }
                    }
                }
            }
        }
        return if (nums[left] == target) left else -1
    }
}

fun main() {
    SearchInRotatedSortedArray().apply {
        println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    }
}