class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reverseList(head: ListNode) -> ListNode:
    curr, prev = head, None
    while curr:
        next, curr.next = curr.next, prev
        prev, curr = curr, next

    return prev

print(reverseList(ListNode([1, 2, 3, 4, 5])))