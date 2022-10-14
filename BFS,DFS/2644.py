"""
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
"""
import sys
input = sys.stdin.readline

# 전체 사람의 수
n = int(input())
x, y = map(int, input().strip().split())
m = int(input())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)
answer = 0

for i in range(m):
    node, vertex = map(int, input().strip().split())
    graph[node].append(vertex)
    graph[vertex].append(node)


def dfs(graph, v, visited):
    for i in graph[v]:
        if not visited[i] != 0:
            visited[i] = visited[v] + 1
            dfs(graph, i, visited)

dfs(graph, x, visited)
print(visited[y] if visited[y] > 0 else -1)