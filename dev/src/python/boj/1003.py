#-*- coding:utf-8 -*-
""" 
문제.
    숫자 n 의 0출력 횟수와 1출력 횟수를 각각 출력하라

해결방안.
    1. 테스트 케이스 t를 입력 받는다.
    2. for 문을 돌려 n을 입력받는다
    3. 
"""
import sys

test_case = int(sys.stdin.readline())
zero_dp = [1, 0] + [0] * 100
one_dp = [0, 1] + [0] * 100

for i in range(test_case):
    num = int(sys.stdin.readline())

    for j in range(2, num + 1):
        if one_dp[j] == 0 or zero_dp[j] == 0:
            zero_dp[j] = zero_dp[j - 2] + zero_dp[j - 1]
            one_dp[j] = one_dp[j - 2] + one_dp[j - 1]
    print(f'{zero_dp[num]} {one_dp[num]}')

