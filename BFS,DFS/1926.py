import sys
from collections import deque


def bfs(x, y):
    queue = deque([])
    queue.append(x, y)
    dx, dy = [0, 0, 1, -1], [-1, 1, 0, 0]

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx >= N or 0 > ny or ny >= M:
                continue

            if graph[x][y] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])


input = sys.stdin.readline
N, M = map(int, input().strip().split())
graph = [int(input().strip().split()) for i in range(N)]
bfs(0, 0)

