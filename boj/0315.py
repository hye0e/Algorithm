import sys

input = sys.stdin.readline
li = [i for i in range(1, 21)]

for i in range(0, 10):
    n, m = int(input().split())
    arr = li[n:m + 1]
    li[n:m + 1] = arr[::-1]

print(' '.join(li))