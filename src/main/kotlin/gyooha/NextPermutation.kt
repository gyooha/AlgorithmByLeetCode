package gyooha

class NextPermutation {
    fun nextPermutation(nums: IntArray) {
        if (nums.isEmpty()) return
        if (nums.size == 1) return

        (nums.size - 2 downTo 0).firstOrNull {
            nums[it] < nums[it + 1]
        }?.let { i ->
            (nums.size - 1 downTo i + 1).firstOrNull {
                nums[it] > nums[i]
            }?.let { nums.swap(i, it) }
            nums.reverse(i + 1, nums.lastIndex)
        } ?: nums.reverse()
    }

    tailrec fun IntArray.reverse(left: Int = 0, right: Int = lastIndex) {
        if (left < right) {
            swap(left, right)
            reverse(left + 1, right - 1)
        }
    }

    private fun IntArray.swap(i: Int, j: Int) {
        with(get(i)) {
            set(i, get(j))
            set(j, this)
        }
    }
}

fun main() {
    NextPermutation().apply {
        nextPermutation(intArrayOf(1, 2, 3))
        nextPermutation(intArrayOf(3, 2, 1))
        nextPermutation(intArrayOf(1, 1, 5))
        nextPermutation(intArrayOf(1))
    }
}