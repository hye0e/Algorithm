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
        global cnt
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx <= i or 0 > ny or ny <= i:
                continue

            if graph[x][y] == 0: # 체스판 0: 안가본 곳 1: 가본 곳 2: 도착 지
                graph[x][y] = 1
                cnt += 1
                queue.append([nx, ny])

            if graph[x][y] == 2:
                print(cnt)
                break

for i in range(T):
    i = int(input().strip()) # 체스판
    graph = [[0] * i for _ in range(i)] 
    now_x, now_y = map(int, input().strip())
    end_x, end_y = map(int, input().strip())
    cnt = 0

    graph[end_x][end_y] = 2
    graph[now_x][now_x] = 1
    bfs(now_x, now_y)
