"""
10 15
5 1 3 5 10 7 4 9 2 8
"""
import sys

input = sys.stdin.readline

N, S = map(int, input().strip().split())
num = list(map(int, input().strip().split()))

start, end = 0, 0
temp = []
ans = 1e9
cnt = 0
internal_sum = 0
for i in range(len(num)):
    start = i
    while internal_sum <= S and end < N:
        internal_sum += num[end]
        end += 1

    if internal_sum >= S:
        ans = min(ans, end - start)

    internal_sum -= num[start]

print(ans if ans != 1e9 else 0)