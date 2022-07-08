import sys
from collections import deque

queue = deque()
input = sys.stdin.readline

queue.app
queue.appendleft(input())
print(queue)
queue.append(input())
print(queue)
queue.appendleft(input())
print(queue)
queue.append(input())
print(queue)
queue.pop()
print(queue)
queue.popleft()
print(queue)