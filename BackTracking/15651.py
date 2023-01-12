import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
arr = []
def dfs(start, cnt):
    if cnt == M:
        print(' '.join(arr))
        return

    for i in range(1, N + 1):
        arr.append(str(i))
        dfs(i + 1, cnt + 1)
        arr.pop()

dfs(1, 0)