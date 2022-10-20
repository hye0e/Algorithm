from collections import deque

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

"""
먹을 수 있는 물고기 1마리 -> GO
1마리보다 많다면 가장 가까운 물고기 

아기 상어가 몇 초 동안 엄마 상어에게 
도움을 요청하지 않고 물고기를 잡아먹을 수 있는지

-> 더이상 먹을 수 있는 물고기가 없다면
"""

dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]
now_x, now_y, size = 0, 0, 2
INF = 1e9

# 상어 위치 확인
for i in range(N):
    for j in range(N):
        if graph[i][j] == 9:
            now_x = i
            now_y = j
            graph[i][j] = 0

def bfs():
    visited = [[-1] * N for _ in range(N)]

    # 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다(Bfs)
    queue = deque([])
    queue.append([now_x, now_y])

    # 방문
    visited[now_x][now_y] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx >= N or 0 > ny or ny >= N:
                continue

            # 방문하지 않는 곳 + 자신의 크기보다 큰 물고기가 있는 칸
            if visited[nx][ny] == -1 and visited[nx][ny] <= size:
                queue.append([nx, ny])
                # 방문 처리
                visited[nx][ny] = visited[x][y] + 1
    return visited

# 먹을 물고기 찾기
def solve(visited):
    x, y = 0, 0
    min_distance = INF
    for i in range(N):
        for j in range(N):
            # BFS에서 지나지않는 경로는 최단 경로가 아님 + 아기 상어가 먹을 수 있는지 확인
            # 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
            # 따라서, 크기가 같은 물고기는 먹을 수 없지만,
            # 그 물고기가 있는 칸은 지나갈 수 있다.
            if visited[i][j] != -1 and 1 <= graph[i][j] < size:
                print(visited[i][j])
                if visited[i][j] < min_distance:
                    min_distance = visited[i][j]
                    x, y = i, j

    # 모두 탐색해도 그대로 INF이면 먹을 물고기가 없다는 뜻
    if min_distance == INF:
        return False
    else:
        return x, y, min_distance

answer = 0
food = 0

while True:
    result = solve(bfs())

    if not result:
        print(answer)
        break
    else:
        now_x, now_y = result[0], result[1]
        answer += result[2]
        # 먹으면 빈칸 처리
        graph[now_x][now_y] = 0
        food += 1
    # 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을때마다 크기가 1 증가한다.
    if food >= size:
        size += 1
        food = 0