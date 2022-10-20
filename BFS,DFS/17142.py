"""
0은 빈 칸, 1은 벽, 2는 바이러스의 위치

연구소의 크기 N(4 ≤ N ≤ 50), 놓을 수 있는 바이러스의 개수 M
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2

"""
import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline
inf = 1e9
N, M = map(int, input().strip().split())
graph = [list(map(int, input().strip().split())) for i in range(N)]

def bfs(active):
    queue = deque([])

    result = 0
    visited = [[-1] * N for _ in range(N)]
    dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

    # 활성 바이러스 0으로 활성화
    for x, y in active:
        queue.append([x, y])
        visited[x][y] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx >= N or 0 > ny or ny >= N:
                continue

            # 빈칸이고 방문한적 없는 곳 -> 바이러스 감염
            if graph[nx][ny] == 0 and visited[nx][ny] == -1:
                visited[nx][ny] = visited[x][y] + 1
                queue.append([nx, ny])
                # ??
                result = max(result, visited[nx][ny])

            # 바이러스이고 방문한적 없는 곳
            elif graph[nx][ny] == 2 and visited[nx][ny] == -1:
                visited[nx][ny] = visited[x][y] + 1
                queue.append([nx, ny])

    # 방문하지 않은 곳과 벽의 개수가 일치하지 않는 것은 퍼뜨리지 않는 바이러스가 있다는 의미
    # sum(visited, []) -> N차원 배열을 1차원으로 배열로
    if sum(visited, []).count(-1) != wall_cnt:
        return inf
    return result

wall_cnt = 0
virus = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            wall_cnt += 1
        elif graph[i][j] == 2:
            virus.append([i, j])

ans = inf
for active in combinations(virus, M):
    ans = min(ans, bfs(active))

print(ans if ans != inf else -1)
