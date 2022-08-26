import sys
from collections import deque


input = sys.stdin.readline

N = int(input())
stack = deque([i for i in range(1, N + 1)])

while len(stack) != 1:
    stack.popleft()
    num = stack.popleft()
    stack.append(num)

print(stack[0])

