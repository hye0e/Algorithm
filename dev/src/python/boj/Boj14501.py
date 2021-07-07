import sys

n = int(sys.stdin.readline())
t = []
p = []
dp = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    t.append(a)
    p.append(b)
    dp.append(b)

for i in range(n):
    if t[i] + 1 > n:
        dp[i] = dp[i] + p[t[i]]
    else:
        dp[i] = max(dp[i], p[i] + dp[i + t[i]])
print(max(dp))