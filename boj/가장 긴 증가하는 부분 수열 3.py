import sys

input = sys.stdin.readline

N = int(input())
num_list = list(map(int, input().split()))
result = [num_list[0]]

def binary_search(left, right, target):
    while left < right:
        mid = (left + right) // 2
        if num_list[mid] < target:
            left = mid + 1
        else:
            right = mid

    return right

for i in range(1, N):
    if result[-1] < num_list[i]:
        result.append(num_list[i])
    else:
        idx = binary_search(0, len(result) - 1, num_list[i])
        result[idx] = num_list[i]

print(result)
