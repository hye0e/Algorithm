"""
6시까지 고민해보기

왜 DP 인지?
이전의 집이 이후의 집까지 영향을 받기때문에
그 이전의 값만 생각해두면 됨
따라서 dp테이블을 이용
"""
import sys

input = sys.stdin.readline

N = int(input().strip())
cost_list = [list(map(int, input().strip().split())) for _ in range(N)]
check = [[2, 3], [1, 3], [1, 2]]

dp = [[cost_list[0][0], cost_list[0][1], cost_list[0][2]] for i in range(N)]

for i in range(1, N):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + cost_list[i][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + cost_list[i][1]
    dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + cost_list[i][2]

print(min(dp[N - 1]))