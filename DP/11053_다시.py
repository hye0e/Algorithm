"""
6
10 20 10 30 20 50

input:
4
1 4 2 3
output: 3

input:
5
10 20 1 2 3
output: 3
"""
import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().strip().split()))
dp = [1 for _ in range(N)]

for i in range(1, N):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[j] + 1, dp[i])

print(max(dp))
