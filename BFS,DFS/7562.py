"""
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
"""
import sys
from collections import deque

input = sys.stdin.readline

T = int(input().strip())

def bfs(x, y):
    dx, dy = [2, 2, 1, 1, -1, -1, -2, -2], [-1, 1, -2, 2, -2, 2, -1, 1]
    queue = deque()
    queue.append([x, y])
    
    while queue:
        x, y = queue.popleft()

        if x == end_x and y == end_y:
            print(graph[x][y])
            return

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx >= N or 0 > ny or ny >= N:
                continue

            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])

for i in range(T):
    N = int(input().strip()) # 체스판
    graph = [[0] * N for _ in range(N)] 
    now_x, now_y = map(int, input().strip().split())
    end_x, end_y = map(int, input().strip().split())

    bfs(now_x, now_y)
