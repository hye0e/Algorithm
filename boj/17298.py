import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
ans = [-1] * N
stack = deque()

for i in range(N):
    while stack and (stack[-1][0] < arr[i]):
        tmp, idx = stack.pop()
        ans[idx] = arr[i]
    stack.append([arr[i], i])

print(*stack)
# 4
# 3 5 2 7