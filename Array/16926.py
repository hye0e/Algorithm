"""
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
"""
from collections import deque
queue = deque()

n, m, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
x, y = 0, 0
h = n
w = m

def rotate():
    for i in range(x, x+w):
        queue.append(arr[x][i])

    for i in range(y+1, y+h-1):
        queue.append(arr[i][y+w-1])

    for i in range(x+w-1, x-1, -1):
        queue.append(arr[x+h-1][i])

    for i in range(y+h-2, y, -1):
        queue.append(arr[i][y])

    queue.rotate(-r)

    for i in range(x, x+w):
        arr[x][i] = queue.popleft()

    for i in range(y+1, y+h-1):
        arr[i][y+w-1] = queue.popleft()

    for i in range(x+w-1, x-1, -1):
        arr[x+h-1][i] = queue.popleft()

    for i in range(y+h-2, y, -1):
        arr[i][y] = queue.popleft()

while True:
    if h == 0 or w == 0:
        break
    rotate()
    y += 1
    x += 1
    h -= 2
    w -= 2

for i in arr:
    print(*i)

# 3 4 8 12
# 2 11 10 16
# 1 7 6 15
# 5 9 13 14