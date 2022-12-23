import sys
from collections import deque
import copy

input = sys.stdin.readline

N, M = map(int, input().strip().split())

# 입력
graph = []
for i in range(N):
    graph.append(list(map(int, input().strip().split())))

answer = 0

def bfs():
    count = 0
    visited = [[False for i in range(M)] for _ in range(N)]

    dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]

    # 바이러스 칸
    queue = deque([])
    temp_graph = copy.deepcopy(graph)

    for i in range(N):
        for j in range(M):
            if temp_graph[i][j] == 2:
                queue.append([i, j])

    while queue:
        x, y = queue.popleft()
        visited[x][y] = True

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if temp_graph[nx][ny] == 0 and not visited[nx][ny]:
                    temp_graph[nx][ny] = 2
                    visited[nx][ny] = True
                    queue.append([nx, ny])

    for i in range(N):
        count += temp_graph[i].count(0)

    return max(answer, count)

ans = []
def wall(cnt):
    if cnt == 3:
        # 바이러스 퍼짐
        ans.append(bfs())
        return

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                # 벽 세움
                graph[i][j] = 1
                wall(cnt + 1)
                # 벽 치움
                graph[i][j] = 0

wall(0)
print(max(ans))