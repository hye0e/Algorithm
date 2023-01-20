import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
arr = sorted(list(map(int, input().strip().split())))
visited = [False for _ in range(N)]
output = []

def dfs(before, count):
    if len(output) == M:
        print(' '.join(output))
        return

    for i in range(N):
        if arr[before] > arr[i]:
            continue

        output.append(str(arr[i]))
        dfs(i, count + 1)
        output.pop()

dfs(0, 0)