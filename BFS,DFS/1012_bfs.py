"""
유기농 배추

input: 
테스트 케이스의 개수 T
가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50)
배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)

output: 1인 개수 세기
"""
import sys
from collections import deque

input = sys.stdin.readline

T = int(input())

def bfs(x, y):
    queue = deque([])
    queue.append([x, y])
    dx, dy = [0, 0, 1, -1], [-1, 1, 0, 0]
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 > nx or nx >= N or 0 > ny or ny >= M:
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append([nx, ny])
    return 

for t in range(T):
    M, N, K = map(int, input().strip().split())
    graph = [[0] * M for _ in range(N)]
    for k in range(K):
        n, v = map(int, input().strip().split())
        graph[v][n] = 1
    cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                bfs(i, j)
                cnt += 1

    print(cnt)
