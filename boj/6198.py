import sys

input = sys.stdin.readline

N = int(input())
li = [int(input()) for _ in range(N)]

stack, res = [], 0
for i in range(N):
    while stack and stack[-1] <= li[i]:
        stack.pop()
    stack.append(li[i])
    res += len(stack)-1

print(res)