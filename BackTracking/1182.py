"""
N개의 정수로 이루어진 수열이 있을 때,
크기가 양수인 부분수열 중에서
그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

8시30분까지

5 0
-7 -3 -2 5 8
"""
import sys
from collections import deque

input = sys.stdin.readline

N, S = map(int, input().strip().split())
num = list(map(int, input().strip().split()))

stack = deque([])
ans = 0

def dfs(start):
    global ans

    if sum(stack) == S and len(stack) > 0:
        ans += 1
        # return
        # return
        # return 을 쓰면 안되는 이유: 재귀 호출을 끝내면, 이 이후 수열을 더하지 않고 return 해버림

    for k in range(start, len(num)):
        stack.append(num[k])
        dfs(k + 1)
        print(stack)
        stack.pop()

dfs(0)
print(ans)
