"""
11시까지 고민해보기
"""
import sys
from collections import deque, defaultdict

input = sys.stdin.readline

N = int(input().strip())
K = int(input().strip())

board = [[0 for _ in range(N)] for _ in range(N)]

queue = deque([])
queue.append([0, 0])

# 사과
for i in range(K):
    x, y = map(int, input().strip().split())
    board[x - 1][y - 1] = 2

changeDir = defaultdict(str)
L = int(input().strip())

for i in range(L):
    x, c = input().strip().split()
    changeDir[int(x)] = c

x, y = 0, 0
# 뱀 초기 상태
board[x][y] = 1
time = 0
direction = 0
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

now = 'Right'
def print_board(board):
    for i in board:
        print(*i)

# def turn(alpha):
#     global direction
#     # 왼쪽
#     if direction == 'L':
#         direction = (direction - 1) % 4
#     # 오른쪽
#     else:
#         direction = (direction + 1) % 4

def go(dir):
    global time
    global changeDir
    global now

    if time in changeDir:
        if dir == 'Right':
            if changeDir[time] == 'L':
                nx, ny = x - 1, y
                now = 'Up'
            elif changeDir[time] == 'D':
                nx, ny = x + 1, y
                now = 'Down'
        elif dir == 'Down':
            if changeDir[time] == 'L':
                nx, ny = x, y + 1
                now = 'Right'
            elif changeDir[time] == 'D':
                nx, ny = x, y - 1
                now = 'Left'
        elif dir == 'Left':
            if changeDir[time] == 'L':
                nx, ny = x + 1, y
                now = 'Down'
            elif changeDir[time] == 'D':
                nx, ny = x - 1, y
                now = 'Up'
        elif dir == 'Up':
            if changeDir[time] == 'L':
                nx, ny = x, y - 1 # 수정
                now = 'Left'
            elif changeDir[time] == 'D':
                nx, ny = x, y + 1
                now = 'Right'
    else:
        if dir == 'Right':
            nx, ny = x, y + 1
        elif dir == 'Down':
            nx, ny = x + 1, y
        elif dir == 'Left':
            nx, ny = x, y - 1
        elif dir == 'Up':
            nx, ny = x - 1, y

    return nx, ny

while True:
    x, y = go(now)
    time += 1

    if x < 0 or x >= N or y < 0 or y >= N:
        break

    # 사과 존재
    if board[x][y] == 2:
        # 사과 먹음처리
        board[x][y] = 1
        queue.append([x, y])
    # 전진
    elif board[x][y] == 0:
        # 뱀 이동
        board[x][y] = 1
        queue.append([x, y])

        # 뱀 꼬리 가져오기
        px, py = queue.popleft()
        board[px][py] = 0
    else:
        break

print(time)