package gyooha

import util.ListNode

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head

        val first = mutableListOf<Int>()
        val second = mutableListOf<Int>()

        var current = head
        var flag = false
        while (current != null) {
            when (flag) {
                true -> second.add(current.`val`)
                false -> first.add(current.`val`)
            }
            flag = !flag

            current = current.next
        }

        val maxSize = if (second.size > first.size) second.size else first.size
        val mergedList = mutableListOf<Int>()
        for (i in 0..maxSize) {
            if (second.getOrNull(i) != null) mergedList.add(second[i])
            if (first.getOrNull(i) != null) mergedList.add(first[i])
        }

        val result = ListNode(0)
        var dummy: ListNode? = result

        mergedList.forEach {
            dummy?.next = ListNode(it)
            dummy = dummy?.next
        }

        return result.next
    }

    fun test(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val result = test(head.next?.next)
        val newHead = head.next
        newHead?.next = head
        newHead?.next?.next = result
        return newHead
    }
}

fun main() {
    SwapNodesInPairs().apply {
        test(
            ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3)
                }
            }
        ).also {
            println(it?.`val`)
            println(it?.next?.`val`)
            println(it?.next?.next?.`val`)
            println(it?.next?.next?.next?.`val`)
        }
    }
}