package gyooha

import util.ListNode

class ReverseNodesInKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (k == 1) return head

        var current: ListNode? = head
        var size = 0
        while (current != null) {
            size++
            current = current.next
        }

        val loopSize = size / k
        val dummy: ListNode = ListNode(-1).apply {
            next = head
        }
        var d: ListNode? = dummy
        for (i in 0 until loopSize) {
            val temp = d?.next
            val result = reverse(temp, k)
            d?.next = result.first
            d = temp
            d?.next = result.second
        }

        return dummy.next
    }

    private fun reverse(head: ListNode?, k: Int): Pair<ListNode?, ListNode?> {
        var prev: ListNode? = null
        var node = head
        for (i in 0 until k) {
            val temp = node?.next
            node?.next = prev
            prev = node
            node = temp
        }
        return prev to node
    }
}

fun main() {
    ReverseNodesInKGroup().reverseKGroup(
        ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        next = ListNode(5).apply {
                            next = ListNode(6).apply {
                                next = ListNode(7)
                            }
                        }
                    }
                }
            }
        },
        2
    )
}