import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
arr = []
visited = [False for _ in range(N + 1)]


def dfs():
    global visited
    if len(arr) == M:
        print(' '.join(arr))
        return

    for i in range(1, N + 1):
        if visited[i]:
            continue

        arr.append(str(i))
        visited[i] = True
        dfs()
        arr.pop()
        visited[i] = False

dfs()