import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int, input().strip().split())
queue = deque()

def bfs():
    dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx >= N or 0 > ny or ny >= M:
                continue
            
            if graph[nx][ny] == 0: 
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])

graph = []

"""
[list(map(int, input().split())) for _ in range(N)]
"""
for i in range(N):
    graph.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            queue.append([i, j])


bfs()
result = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            print(-1)
            exit(0) # 종료
        result = max(result, graph[i][j])

# 1부터 차근차근 늘려갔으므로 -1
print(result - 1)