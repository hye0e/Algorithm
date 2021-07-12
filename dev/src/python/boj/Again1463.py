#-*- coding:utf-8 -*-
import sys
n = int(sys.stdin.readline())

dp = [0 for _ in range(n + 1)]

for i in range(2, n+1):
    dp[i] = dp[i - 1] + 1
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)

print(dp[n])
""" 
문제.
    정수 X에 사용할 수 있는 연산
    1. x%3 == 0 
    2. x%2 == 0
    3. x -= 1
    x가 1이 되게 하는 최소 연산 횟수

해결방안.
    1. x 입력 받기 
    2. index 를 이용해서 값을 구하기 위해 x+1크기의 dp 만들기
    3. 1은 0이므로 2부터 for문 시작
    4. dp[i]는 결국 dp[i-1]에 연산3번을 한 것과 같으므로 이전 횟수 +1을 해준다 -> dp[i] = dp[i - 1] + 1
    5. i % 3 == 0 이면, dp[i//3]에서 한번 더 연산해준 것과 같다 -> dp[i//3] + 1
    6. 4번과 5번 중에 최소값을 dp[i] 에 넣어준다
    7. %2 도 5, 6 번과 같다
"""
