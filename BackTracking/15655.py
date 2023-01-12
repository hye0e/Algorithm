import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))

output = []

# 중복 출력을 막기 위함
visited = [False for _ in range(N)]

# 사전 순으로 출력하기 위함
arr.sort()

def dfs(before, cnt):
    if M == len(output):
        print(' '.join(output))
        return

    for i in range(len(arr)):
        if visited[i] or before > arr[i]:
            continue

        visited[i] = True
        output.append(str(arr[i]))
        dfs(arr[i], cnt + 1)
        visited[i] = False
        output.pop()

dfs(0, 0)