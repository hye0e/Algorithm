"""
5 17
"""
import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().strip().split())

visited = [0] * 1000000  # 최대 

def bfs():
    queue = deque()
    queue.append(N)

    while queue:
        n = queue.popleft()

        if n == K:
            print(visited[n])
            break

        for nx in (n - 1, n + 1, n * 2):   
            if 0 <= nx < 100000 and not visited[nx]:
                visited[nx] = visited[n] + 1
                queue.append(nx)
  
bfs()
