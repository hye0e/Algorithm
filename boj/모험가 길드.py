import sys

input = sys.stdin.readline

N = int(input())
X_list = list(map(int, input().split()))

x_cnt = 0
group = 0
X_list = sorted(X_list)

for x in X_list:
    x_cnt += 1
    if x <= x_cnt:
        group += 1
        x_cnt = 0

print(group)
    