#-*- coding:utf-8 -*-
""" 양방향으로 꺼낼 수 있는 deque """
from collections import deque 

def bfs(graph, start, visited):
    queue = deque([start])
    # 현재 노드를 방문 처리
    visited[start] = True
    # 큐가 빌 때까지 반복
    v = queue.popleft()
    print(v, end = ' ')
    # 해당 원소에 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
    for i in graph[v]:
        if not visited[i]:
            queue.append(i)
            visited[i] = True

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현 (노드의 개수만큼)
visited = [False] * 9

bfs(graph, 1, visited)