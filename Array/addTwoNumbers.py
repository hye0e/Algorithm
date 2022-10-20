# Definition for singly-linked list.
from collections import deque

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1, l2):
    # 데크형으로 변환
    num1_queue = deque()
    num2_queue = deque()
    while l1:
        num1_queue = (l1.val)
        l1 = l1.next

    while l2:
        num2_queue = (l2.val)
        l2 = l2.next

    num1 = 0
    num2 = 0
    while num1_queue:
        num1 += num1_queue.pop() * (int('1' + len(num1_queue) * '0'))
    while num2_queue:
        num2 += num2_queue.pop() * (int('1' + len(num2_queue) * '0'))
    return list(str(num1 + num2))[::-1]


print(addTwoNumbers(ListNode([2, 4, 3]), ListNode([5, 6, 4])))