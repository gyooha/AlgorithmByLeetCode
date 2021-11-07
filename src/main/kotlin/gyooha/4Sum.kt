package gyooha

class Sum4 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result: HashSet<List<Int>> = hashSetOf(mutableListOf())
        nums.sort()
        for (i in 0 until nums.size - 3) {
            for (j in i + 1 until nums.size - 2) {
                var left = j + 1
                var right = nums.size - 1
                while (left < right) {
                    val sum = nums[i] + nums[j] + nums[left] + nums[right]
                    when {
                        sum == target -> {
                            result.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                            left++
                            right--
                        }
                        sum < target -> left++
                        sum > target -> right--
                    }
                }
            }
        }

        return result.toList().filter { it.isNotEmpty() }
    }
}

fun main() {
    Sum4().apply {
        println(fourSum(intArrayOf(1,0,-1,0,-2,2), 0))
        println(fourSum(intArrayOf(2,2,2,2,2), 8))
    }
}