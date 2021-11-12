package gyooha

import util.ListNode
import util.print

class RemoveNthNodeFromEndofList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var testNode = head
        var size = 0
        while (testNode != null) {
            testNode = testNode.next
            size++
        }
        var currentNode: ListNode? = ListNode(0).apply {
            next = head
        }
        val result = currentNode
        val removeTarget = size - n
        var position = 0
        while(currentNode != null) {
            if (removeTarget == position) {
                currentNode.next = currentNode.next?.next
            }
            currentNode = currentNode.next
            position++
        }

        return result?.next
    }
}

fun main() {
    RemoveNthNodeFromEndofList().apply {
        val first = ListNode(1).apply { next = ListNode(2) }
        val second = ListNode(1)
        val third = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        next = ListNode(5)
                    }
                }
            }
        }
        val four = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3)
            }
        }
        val five = ListNode(1).apply {
            next = ListNode(2)
        }

        removeNthFromEnd(first, 1).print()
        removeNthFromEnd(second, 1).print()
        removeNthFromEnd(third, 2).print()
        removeNthFromEnd(four, 2).print()
        removeNthFromEnd(five, 2).print()
    }


}