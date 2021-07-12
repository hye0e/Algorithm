#-*- coding:utf-8 -*-
""" 
문제.
해결방안.
    1. n 입력받기 
    2. 0 * n 만큼 dp 리스트 만들기 
    3. i = 3부터 dp[i-1] + dp[i-2] 점화식 시작
    4. 
"""
import sys

n = int(sys.stdin.readline())
dp = [0] * (n+1)

dp[1] = 1
if n > 1:
    dp[2] = 2

for i in range(3, n + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % 15746

print(dp[n])