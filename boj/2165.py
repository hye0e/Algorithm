import sys
from collections import deque

N = int(sys.stdin.readline())
stack = deque([_ for _ in range(1, N + 1)])

while len(stack) != 1:
    stack.popleft()
    # temp = stack[0]
    # stack.pop(0)
    stack.append(stack.popleft())

print(stack[0])