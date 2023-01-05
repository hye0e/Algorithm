import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))

prefix_sum = [0]

temp_sum = 0
for i in arr:
    temp_sum += i
    prefix_sum.append(temp_sum)

for i in range(M):
    left, right = map(int, input().strip().split())
    print(prefix_sum[right] - prefix_sum[left-1])