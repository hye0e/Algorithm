import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))

# 사전 순으로 출력하기 위함
arr.sort()

# 중복 출력을 막기 위함
visited = [False for _ in range(N)]

output = []
def dfs(cnt):
    if cnt == M:
        print(' '.join(output))
        return

    for i in range(len(arr)):
        # 백트래킹 조건
        if visited[i]:
            continue

        output.append(str(arr[i]))
        visited[i] = True
        dfs(cnt+1)
        visited[i] = False
        output.pop()

dfs(0)

