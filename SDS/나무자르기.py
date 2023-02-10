import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
trees = list(map(int, input().strip().split()))

trees.sort()

left = trees[0]
right = trees[-1]
target = 0

result = 0
def cut_tree(trees, mid):
    sum = 0
    for tree in trees:
        if tree >= mid:
            sum += tree - mid

    return sum

while left <= right:
    mid = (left + right) // 2
    target = cut_tree(trees, mid)
    if target >= M:
        result = mid
        left = mid + 1
    else:
        right = mid - 1

print(result)

