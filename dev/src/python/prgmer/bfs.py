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

for i in range(0, len(f)):
    for j in range(0, len(f)-1):
        if f[j] != f[j+1]:
            graph.append(l)
            l = []
            break
        else:
            l.append(t[j])

# print(graph)

# print(dict['A'].value)