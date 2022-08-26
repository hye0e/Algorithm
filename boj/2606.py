"""
연결되어 있는 1번의 컴퓨터 수 - BFS
7
6
1 2
2 3
1 5
5 2
5 6
4 7
"""
import sys
from collections import deque

input = sys.stdin.readline

N = int(input()) # 컴퓨터의 수 = 노드의 개수
M = int(input())

graph = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)

# 입력
for i in range(M):
    n, v = map(int, input().split())
    graph[n].append(v)
    graph[v].append(n)

# 정렬
for i in range(len(graph)):
    graph[i].sort()


def bfs(graph, start, visited):
    result = 0
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                result += 1

    return result

print(bfs(graph, 1, visited))