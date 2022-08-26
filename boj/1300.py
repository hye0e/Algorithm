import sys

input = sys.stdin.readline

N = int(input())
K = int(input())

li = [i*j for i in range(1, N + 1) for j in range(1, N + 1)]
print(sorted(li)[K])