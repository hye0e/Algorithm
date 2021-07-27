#-*- coding:utf-8 -*-
import heapq
import sys

input = sys.stdin.readline
INF = 100000

n, m = map(int, input().split())
start = int(input())
graph = [[] for i in range(n + 1)]
print(graph)
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    graph[a].append((b, c))

print(graph)
def dijkstra(start):
    q = []
    # start (시작 노드로 가기위한 최단 경로) -> 0
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q: # 큐가 비어 있지 않다면
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)

