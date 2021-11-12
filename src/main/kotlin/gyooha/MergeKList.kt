package gyooha

import util.ListNode

class MergeKList {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        val result = mutableListOf<Int>()
        lists.forEach { list ->
            var current: ListNode? = list

            while (current != null) {
                result.add(current.`val`)
                current = current.next
            }
        }
        if (result.isEmpty()) return null

        result.sort()

        val head = ListNode(0)
        var dummy: ListNode? = head

        result.forEach { value ->
            dummy?.next = ListNode(value)
            dummy = dummy?.next
        }

        return head.next
    }
}