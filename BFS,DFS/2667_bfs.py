from collections import deque
import sys

input = sys.stdin.readline
count = 0
def bfs(graph, x, y):
    dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]
    N = len(graph)
    queue = deque([])
    queue.append([x, y])

    # 초기화
    count = 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 > nx or nx >= N or 0 > ny or ny >= N:
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append([nx, ny])
                count += 1
    return count

N = int(input())
graph = [list(map(int, input().strip())) for i in range(N)]

result = 0
count_list = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            count_list.append(bfs(graph, i, j))

count_list.sort()
print(len(count_list))
for c in count_list:
    print(c)
