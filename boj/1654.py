import sys
input = sys.stdin.readline

K, N = map(int, input().split())
lines = [int(input()) for i in range(K)]

def count(len):
    cnt = 0
    for line in lines:
        cnt += line // len

    return cnt

left = 1
right = max(lines)
result = 0

while left <= right:
    mid = (left + right) // 2
    if count(mid) >= N:
        result = mid
        left = mid + 1
    else:
        right = mid - 1
   
print(result)