#-*- coding:utf-8 -*-
""" 
해결방안.
    1. i = 3부터 for
"""
import sys

test_case = int(sys.stdin.readline())

def padoban(dp):
    for j in range(3, len(dp)):
        dp[j] = dp[j-2] + dp[j-3]
    return dp

for i in range(test_case):
    n = int(sys.stdin.readline())
    dp = [1] * (n + 1)
    if n > 3:
        padoban(dp)
    print(dp[n-1])
