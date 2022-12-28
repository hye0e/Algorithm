import sys
from collections import deque

input = sys.stdin.readline

R, C = map(int, input().strip().split())
graph = [list(input().strip()) for _ in range(R)]
fire_graph = [[0 for _ in range(C)] for _ in range(R)]


visited = [[False for _ in range(C)] for _ in range(R)]
visited_fire = [[False for _ in range(C)] for _ in range(R)]

fire_queue = deque([])
queue = deque([])

def bfs():
    dx, dy = [-1, 1, 0, 0], [0, 0, 1, -1]
    while fire_queue:
        x, y = fire_queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C:
                if fire_graph[nx][ny] == 0 and graph[nx][ny] != '#':
                    fire_graph[nx][ny] = fire_graph[x][y] + 1
                    fire_queue.append([nx, ny])

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C:
                if graph[nx][ny] == '.' and not visited[nx][ny]:
                    # 숫자만 계산하기 위해서
                    if graph[x][y] != '#' and graph[x][y] != 'F':
                        # 불이 안번졌거나 갈 수 있으면
                        if fire_graph[nx][ny] == 0 or fire_graph[nx][ny] > graph[x][y] + 1:
                            graph[nx][ny] = graph[x][y] + 1
                            visited[nx][ny] = True
                            queue.append([nx, ny])
            else:
                return graph[x][y]
    return "IMPOSSIBLE"

goal = deque([])
start_x, start_y = 0, 0
for i in range(R):
    for j in range(C):
        if graph[i][j] == 'F':
            fire_graph[i][j] = 1
            fire_queue.append([i, j])

        if graph[i][j] == 'J':
            graph[i][j] = 1
            queue.append([i, j])

print(bfs())




"""
4 4
####
#JF#
#..#
#..#

3 3
###
#J.
#.F

4 6
######
......
#.J###
#F####



5 4
####
#...
#.##
#.J#
####

7 7
#######
#J#####
#.....#
#.#.#.#
#.#.#.#
F.#.#.#
##F.#.#

10

7 7
#######
#J###F#
#.....#
#.#.#.#
#.#.#.#
F.#.#.#
##F.#.#

IMPOSIBBLE
"""