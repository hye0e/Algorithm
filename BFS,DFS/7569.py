"""
5 3 1
0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1
"""
import sys
from collections import deque

queue = deque()
input = sys.stdin.readline

M, N, H = map(int, input().split())
graph = []

for _ in range(H):
    graph.append([list(map(int, input().strip().split())) for _ in range(N)])
 
def bfs():
    dx, dy, dz = [-1, 0, 0, 0, 0, 1], [0, -1, 0, 0, 1, 0], [0, 0, -1, 1, 0, 0]
    while queue:
        x, y, z = queue.popleft()

        for i in range(6):
            nx = dx[i] + x
            ny = dy[i] + y
            nz = dz[i] + z

            if 0 > nx or nx >= H or 0 > ny or ny >= N or 0 > nz or nz >= M:
                continue

            if graph[nx][ny][nz] == 0:
                graph[nx][ny][nz] = graph[x][y][z] + 1
                queue.append([nx, ny, nz])
                

for i in range(H): # 2
    for j in range(N): # 3
        for k in range(M): # 2
            if graph[i][j][k] == 1:
                queue.append([i, j, k])
bfs()
result = 0
for i in range(H): # 2
    for j in range(N): # 3
        for k in range(M): # 2
            if graph[i][j][k] == 0:
                print(-1)
                exit(0)
                
            result = max(result, graph[i][j][k])    
print(result - 1)