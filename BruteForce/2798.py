"""
블랙잭
5 21
5 6 7 8 9

M(10 ≤ M ≤ 300,000)
"""
import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
num = list(map(int, input().strip().split()))
answer = 0
for i in range(N):
    for j in range(i + 1):
        for k in range(j + 1):
            if i != j != k and num[i] + num[j] + num[k] <= M:
                answer = max(answer, num[i] + num[j] + num[k])
print(answer)

