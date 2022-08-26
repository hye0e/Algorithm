import sys

N, M = map(int, sys.stdin.readline().split())
music = [i for i in range(1, N + 1)]

left = 1
right = sum(music)
result = right

def count(len):
    sum = 0
    cnt = 0
    for i in music:
        if sum <= len:
            sum += i
            cnt += 1
        if cnt == N:
            break

    return sum

while left <= right:
    mid = (left + right) // 2
    if count(mid) >= left:
        result = mid
        right = mid - 1
    else:
        left = mid + 1


print(mid)