"""
5 17
4
"""
import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().strip().split())
MAX = 10 ** 5
visited = [0] * (MAX + 1)

def bfs():
    queue = deque()
    queue.append(N)

    while queue:
        n = queue.popleft()
        if n == K:
            print(visited[n])
            return
        
        for i in (n - 1, n + 1, n * 2):
            if 0 <= i <= MAX and not visited[i]:
                visited[i] = visited[n] + 1
                queue.append(i)

bfs()