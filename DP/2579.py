"""
6
10
20
15
25
10
20
"""
import sys

input = sys.stdin.readline

T = int(input().strip())

stair = [int(input().strip()) for _ in range(T)]
dp = [0] * T

dp[0] = stair[0] # 첫번째 계단부터
dp[1] = max(stair[0] + stair[1], stair[1])
dp[2] = max(stair[0] + stair[2], stair[1] + stair[2])

for i in range(3, T):
    # 경우의 수 1. 마지막 계단만 2. 마지막 계단 + 마지막 계단 이전
    # 조건에 의해 i - 2, i - 3
    dp[i] = max(dp[i - 2] + stair[i], dp[i - 3] + stair[i] + stair[i - 1])

print(dp[T-1])

result = 0
