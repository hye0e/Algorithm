import sys
input = sys.stdin.readline

N = int(input().strip())

scores = [int(input().strip()) for _ in range(N)]

answer = 0

for i in range(N - 1, 0, -1):
    if scores[i] <= scores[i - 1]:
        answer += (scores[i - 1] - scores[i] + 1)
        scores[i - 1] = scores[i] - 1

print(answer)

