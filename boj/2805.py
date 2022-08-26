import sys

input = sys.stdin.readline

N, M = map(int, input().split())
tree = list(map(int, input().split()))

left = 0
right = max(tree)
result = 0

def count(len):
    cut_tree = 0
    for i in tree:
        if i >= len:
            cut_tree += i - len

    return cut_tree 

while left <= right:
    mid = (left + right) // 2
    if count(mid) >= M:
        result = mid
        left = mid + 1
    else:
        right = mid - 1

print(result)