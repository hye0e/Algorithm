import sys

input = sys.stdin.readline

N = int(input().strip())
cost = [list(map(int, input().strip().split())) for _ in range(N)]
dp = [[0, 0, 0] for _ in range(N)]
dp[0] = [cost[0][0], cost[0][1], cost[0][2]]

for i in range(1, N):
    dp[i] = [cost[i][0] + min(dp[i - 1][1], dp[i - 1][2]),
             cost[i][1] + min(dp[i - 1][0], dp[i - 1][2]),
             cost[i][2] + min(dp[i - 1][0], dp[i - 1][1])]

print(min(dp[N - 1]))