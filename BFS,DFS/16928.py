"""
6시까지 고민해보기
"""
import sys
from collections import deque, defaultdict
input = sys.stdin.readline

N, M = map(int, input().strip().split())
now = 1

# 모든 경우의 수
all = [[_ + (i + 1) for i in range(6)] for _ in range(101)]

board = [0 for _ in range(101)]
visited = [False] * 101

answer = 1e9

stair = defaultdict(int)
snake = defaultdict(int)

for i in range(N):
    x, y = map(int, input().strip().split())
    stair[x] = y

for i in range(M):
    x, y = map(int, input().strip().split())
    snake[x] = y

# 1부터 시작
queue = deque([1])

while queue:
    go = queue.popleft()

    if go == 100:
        print(board[go])
        break

    for i in all[go]:
        next_step = i
        # index 초과 막기 위해
        if next_step <= 100 and not visited[next_step]:
            if i in stair.keys():
                next_step = stair[i]

            if i in snake.keys():
                next_step = snake[i]

            if not visited[next_step]:
                visited[next_step] = True
                board[next_step] = board[go] + 1
                queue.append(next_step)
