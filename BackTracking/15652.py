import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
arr = []
visited = [False for _ in range(N + 1)]

def dfs(before, cnt):
    if len(arr) == M:
        print(' '.join(arr))
        return

    for i in range(1, N + 1):
        if before > i:
            continue

        arr.append(str(i))
        dfs(i, cnt + 1)
        arr.pop()


dfs(0, 0)