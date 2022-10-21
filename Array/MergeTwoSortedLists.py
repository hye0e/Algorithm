class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution(object):
    def mergeTwoLists(self, list1, list2):
        result_head = ListNode(0)

        for li1, li2 in zip(list1, list2):
            result_head.val = min(li1, li2)
            result_head.next = max(li1, li2)

        return result_head
        
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
result_head = ListNode(0)

for li1, li2 in zip([1,2,3,4], [5,6,7,8]):
    result_head.val = min(li1, li2)
    result_head.next = max(li1, li2)

print(list(result_head))