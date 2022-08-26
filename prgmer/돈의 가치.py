from re import T
import sys

input = sys.stdin.readline

N, K = map(int, input().split())
money_list = [int(input()) for i in range(N)]
money_list = sorted(money_list, reverse=True)
cnt = 0
for money in money_list:
    if money <= K:
        cnt += K//money
        K -= money*(K//money)

    if K == 0:
        break

print(cnt)