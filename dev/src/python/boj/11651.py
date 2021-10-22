import sys

input = sys.stdin.readline

N = int(input())
num_list = [input().split() for _ in range(N)]


num_list.sort(key = lambda x: (int(x[1]),int(x[0])))

for i in num_list:
    print(i[0], i[1])