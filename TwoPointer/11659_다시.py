"""
1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
"""
import sys

input = sys.stdin.readline

M, N = map(int, input().strip().split())
num_arr = list(map(int, input().strip().split()))
prefix_sum = [0]
sum = 0
for i in range(len(num_arr)):
    sum += num_arr[i]
    prefix_sum.append(sum)

for k in range(N):
    i, j = map(int, input().split())
    print(prefix_sum[j] - prefix_sum[i - 1])