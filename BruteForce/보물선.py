import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().strip().split())
graph = []
answer = 0

for _ in range(N):
    graph.append(list(input().strip()))

land = []

def bfs(x, y):
    cnt = 0
    queue = deque([])
    visited = [[0 for _ in range(M)] for _ in range(N)]
    visited[x][y] = 1
    queue.append([x, y])

    while queue:
        x, y = queue.popleft()
        dx, dy = [1, -1, 0, 0], [0, 0, -1, 1]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if visited[nx][ny] == 0 and graph[nx][ny] == 'L':
                    visited[nx][ny] = visited[x][y] + 1
                    cnt = max(cnt, visited[nx][ny])
                    queue.append([nx, ny])

    return cnt - 1

for i in range(N):
    for j in range(M):
        if graph[i][j] == 'L':
            answer = max(answer, bfs(i, j))

print(answer)