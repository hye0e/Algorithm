#-*- coding:utf-8 -*-
""" 
문제.
    방문할 수 있는 정점이 여러개 -> sort 후 적은 것 먼저 방문
    정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호 

해결방안.
    1. input split으로 자른 후, 1~input[0] dict만들기
    2. input[1] 만큼 for문 돌려서 input2받기
    3. input2.split() 한 후, split[0] 랑 dict key 랑 같으면, split[1] value값으로 
    4. input[2] 인 것 부터 차례대로 
    5. DFS -> stack
    6. BFS -> queue
"""
import sys
from collections import deque

m, n, v = map(int, sys.stdin.readline().split())
s = [[0] * (n+1) for i in range(n + 1)]

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end = ' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end = ' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

    
for i in range(m):
    x, y = map(int, sys.stdin.readline().split())
    s[x][y] = 1
    s[y][x] = 1

visited = [False] * (m + 1)
bfs(s, 1, visited)
visited = [False] * (m + 1)
bfs(s, 1, visited)