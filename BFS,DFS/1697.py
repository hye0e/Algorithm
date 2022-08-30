"""
5 17
"""
import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().strip().split())
MAX = 10 ** 5
visited = [0] * (MAX + 1)  # index 이므로 +1
print(MAX)

def bfs():
    queue = deque()
    queue.append(N)

    while queue:
        n = queue.popleft()

        if n == K:
            print(visited[n])
            break

        for nx in (n - 1, n + 1, n * 2):   
            if 0 <= nx <= MAX and not visited[nx]:
                visited[nx] = visited[n] + 1
                queue.append(nx)

bfs()
