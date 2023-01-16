import sys
from collections import defaultdict
input = sys.stdin.readline

W, N = map(int, input().strip().split())
arr = []
total = 0

for i in range(N):
    m, p = map(int, input().strip().split())
    arr.append([m, p])


arr.sort(key = lambda x: x[1], reverse= True)

in_bag = 0
answer = 0
rest = W
while rest != 0:
    for i in range(len(arr)):
        total = arr[i][0]
        per_price = arr[i][1]
        if rest == 0:
            break

        if total == 0:
            continue

        if total <= rest:
            answer += total * per_price
            in_bag += total
            rest -= total

            arr[i][0] = 0
        elif total > rest:
            arr[i][0] -= rest
            in_bag += rest
            answer += rest * per_price

            rest = 0
            # answer += rest * per_price

print(answer)