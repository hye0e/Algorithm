"""
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
"""
import sys

input = sys.stdin.readline

N = int(input())
t_list = []
p_list = []
dp = []

for i in range(N):
    T, P = map(int, input().strip().split())
    t_list.append(T)
    p_list.append(P)
    dp.append(T)

# dp[7]까지
dp.append(0)

answer = 0





