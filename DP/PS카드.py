import sys

input = sys.stdin.readline

N = int(input().strip())
card_cost = [0] + list(map(int, input().strip().split()))
dp = [0 for i in range(N + 1)]

dp[1] = card_cost[0]

for i in range(1, N + 1):
    for j in range(1, i + 1):
        dp[i] = max(dp[i - j] + card_cost[j], dp[i])

print(dp)

# import sys
# from itertools import product
#
# input = sys.stdin.readline
#
# N = int(input().strip())
# card_cost = list(map(int, input().strip().split()))
# card_cnt = [i for i in range(1, N + 1)]
# index_arr = []
#
# arr = []
# answer = 0
# def dfs(arr):
#     global answer
#     if sum(arr) == N:
#         temp_answer = 0
#         for index in arr:
#             temp_answer += card_cost[index - 1]
#         answer = max(answer, temp_answer)
#         return
#     elif sum(arr) > N:
#         return
#
#     for i in range(len(card_cost)):
#         arr.append(card_cnt[i])
#         dfs(arr)
#         arr.pop()
#
# dfs(arr)
# print(answer)