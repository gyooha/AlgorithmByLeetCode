package gyooha

class MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val list = mutableListOf<Int>()
        var linked1 = l1
        while (linked1 != null) {
            list.add(linked1.`val`)
            linked1 = linked1.next
        }

        var linked2 = l2
        while (linked2 != null) {
            list.add(linked2.`val`)
            linked2 = linked2.next
        }

        list.sort()

        var result: ListNode? = ListNode(0)
        val re = result
        list.forEach {
            result?.next = ListNode(it)
            result = result?.next
        }

        return re?.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}