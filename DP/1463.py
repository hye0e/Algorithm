"""
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
"""
import sys

N = int(sys.stdin.readline())
dp = [0] * (N + 1)

dp[1] = 0

if N > 1:
    dp[2] = 1

if N > 2:
    dp[3] = 1

for i in range(4, N + 1):
    if i % 3 == 0 and i % 2 == 0:
        dp[i] = min(dp[i // 2] + 1, dp[i // 3] + 1, dp[i - 1] + 1)
    elif i % 3 == 0:
        dp[i] = min(dp[i - 1] + 1, dp[i // 3] + 1)
    elif i % 2 == 0:
        dp[i] = min(dp[i - 1] + 1, dp[i // 2] + 1)
    else: # 이건 맞음
        dp[i] = dp[i - 1] + 1

print(dp[N])
