"""
12시까지 고민해보기
"""
import sys

input = sys.stdin.readline

n, k = map(int, input().strip().split())
coin = [int(input().strip()) for _ in range(n)]
output = []
dp = [0 for _ in range(k + 1)]
dp[0] = 1
for co in coin:
    for i in range(1, k + 1):
        if i - co >= 0:
            dp[i] += dp[i - co]

print(dp[k])