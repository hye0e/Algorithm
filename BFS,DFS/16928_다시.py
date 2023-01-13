"""
3 7
32 62
42 68
12 98
95 13
97 25
93 37
79 27
75 19
49 47
67 17
"""
import sys
from collections import deque, defaultdict

input = sys.stdin.readline

N, M = map(int, input().split())

snake = defaultdict(int)
stair = defaultdict(int)

board = [0 for _ in range(101)]
visited = [False for _ in range(101)]

for i in range(N):
    x, y = map(int, input().split())
    snake[x] = y

for j in range(M):
    u, v = map(int, input().split())
    stair[u] = v

queue = deque([])

queue.append(1)
while queue:
    now = queue.popleft()

    if now == 100:
        print(board[now])
        break

    for i in range(1, 7):
        next = now + i

        if next in stair:
            next = stair[next]

        if next in snake:
            next = snake[next]

        if 0 < next <= 100 and not visited[next]:
            visited[next] = True
            board[next] = board[now] + 1
            queue.append(next)