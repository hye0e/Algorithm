# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution(object):
    def isPalindrome(self, head):
        queue = []
        
        node = head
        
        while node is not None:
            queue.append(node.val)
            node = node.next
        
        while queue and len(queue) > 1:
            if queue.pop(0) != queue.pop():
                return False

        return True
        """
        :type head: ListNode
        :rtype: bool
        """
        