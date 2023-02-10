import sys

input = sys.stdin.readline

N, S = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))

start, end = 0, 0
internal_sum = 0
answer = 1e9

for start in range(N):
    while internal_sum < S and end < N:
        internal_sum += arr[end]
        end += 1

    if internal_sum >= S:
        answer = min(end - start, answer)

    internal_sum -= arr[start]

print(answer if answer != 1e9 else 0)