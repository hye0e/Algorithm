# F S G U D
# 10 1 10 2 1
import sys
from collections import deque

input = sys.stdin.readline

F, S, G, U, D = map(int, input().strip().split())

visited = [False] * F
count = [0 for _ in range(F + 1)]

def bfs(num):
    queue = deque()
    queue.append(num)
    visited[num] = True

    while queue:
        new_num = queue.pop()

        if new_num == G:
            return count[new_num]

        for i in (new_num - D, new_num + U):
            if 0 < i <= F and not visited[i]:
                visited[i] = True
                count[i] = count[new_num] + 1
                queue.append(i)

    return -1

print(bfs(S))

