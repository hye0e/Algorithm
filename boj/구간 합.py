import sys

input = sys.stdin.readline

N, M = map(int, input().split())
num_list = list(map(int, input().split()))

for count in range(M):
    i, j = map(int, input().split())
    sum = 0
    for index in range(i, j + 1):
        sum += num_list[index-1]

    print(sum)
