package gyooha

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

    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun RemoveNthNodeFromEndofList.ListNode?.printNode() {
        var current = this
        while (current != null) {
            print("${current.`val`}, ")
            current = current.next
        }
        println()
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

        removeNthFromEnd(first, 1).printNode()
        removeNthFromEnd(second, 1).printNode()
        removeNthFromEnd(third, 2).printNode()
        removeNthFromEnd(four, 2).printNode()
        removeNthFromEnd(five, 2).printNode()
    }


}