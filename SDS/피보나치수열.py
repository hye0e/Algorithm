import sys

input = sys.stdin.readline

N = int(input())
dp = [0 for _ in range(N + 1)]
dp[1] = 1

def fibonacchi(n):
    if dp[n] != 0:
        return dp[n]
    if n >= 2:
        for i in range(2, n + 1):
            dp[i] = dp[i - 2] + dp[i - 1]

    return dp[n]

print(fibonacchi(N))