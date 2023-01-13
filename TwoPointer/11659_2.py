import sys

input = sys.stdin.readline

N, M = map(int, input().split())
num = list(map(int, input().split()))
prefix_sum = [0, num[0]]
sum = num[0]
for i in range(1, N):
    sum += num[i]
    prefix_sum.append(sum)

for i in range(M):
    start, end = map(int, input().strip().split())
    print(prefix_sum[end] - prefix_sum[start - 1])
