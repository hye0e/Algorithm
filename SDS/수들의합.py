import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
num = list(map(int, input().strip().split()))

start, end = 0, 0
internal_sum = 0
answer = 0

for start in range(len(num)):
    while internal_sum < M and end < N:
        internal_sum += num[end]
        end += 1

    if internal_sum == M:
        answer += 1

    internal_sum -= num[start]


print(answer)