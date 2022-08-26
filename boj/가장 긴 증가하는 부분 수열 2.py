import sys

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))

left = 0
right = N
result = 0

def count(mid):
    result = 0
    for num in arr:
        if arr[mid] > num:
            result += 1
    return result

while left <= right:
    mid = (left + right) // 2
    if count(mid) >= result:
        result = count(mid)
        right = mid - 1
    else:
        left = mid + 1
        
print(result)