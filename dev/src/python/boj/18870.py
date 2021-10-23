import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

dict = {}
sort_arr = sorted(arr)
index = 0
for i in sort_arr:
    dict[i] = index
    index += 1

for i in arr:
    for key, value in enumerate(dict):
        if i == value:
            print(key, end = '')
print(arr)
print(sort_arr)