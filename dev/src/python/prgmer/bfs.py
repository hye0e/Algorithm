from collections import deque

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

dict = {}
graph = []
f = ["A", "A", "B", "B", "C", "D", "D"]
t = ["B", "C", "C", "D", "E", "A", "E"]
l = []
# for index, value in enumerate(f):

n, m, v = map(int, read().split())

graph = [[0] * (n + 1) for _ in range(n + 1)] 
visit_list = [0] * (n + 1)
visit_list2 = [0] * (n + 1)

for _ in range(m):
  a, b = map(int, read().split())
  graph[a][b] = graph[b][a] = 1

# print(graph)

# print(dict['A'].value)