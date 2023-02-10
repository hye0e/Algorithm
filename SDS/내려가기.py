"""
3
1 2 3
4 5 6
4 9 0
"""
import sys

input = sys.stdin.readline

N = int(input().strip())

max_dp = [0 for _ in range(3)]
min_dp = [0 for _ in range(3)]

for i in range(N):
    first, second, third = map(int, input().strip().split())

    temp = [0 for _ in range(3)]
    temp[0] = first + min(min_dp[0], min_dp[1])
    temp[1] = second + min(min_dp[0], min_dp[1], min_dp[2])
    temp[2] = third + min(min_dp[1], min_dp[2])

    min_dp = temp[:]

    temp = [0 for _ in range(3)]

    temp[0] = first + max(max_dp[0], max_dp[1])
    temp[1] = second + max(max_dp[0], max_dp[1], max_dp[2])
    temp[2] = third + max(max_dp[1], max_dp[2])

    max_dp = temp[:]

print(max(max_dp), min(min_dp), end = ' ')