import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
arr = sorted(list(map(int, input().strip().split())))
output = []

def dfs(count):
    if len(output) == M:
        print(' '.join(output))
        return

    for i in range(N):
        output.append(str(arr[i]))
        dfs(count + 1)
        output.pop()

dfs(0)