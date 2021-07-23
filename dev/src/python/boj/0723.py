import heapq
import sys

input = sys.stdin.readline
INF = 100000

n, m = map(int, input().split())
start = int(input())
graph = [[] for i in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

print(graph)
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    print(heapq)
    distance[start] = 0
    while q: 
        dist, now = heapq.heappop(q)
        print('dist = ', dist)
        print('now = ', now)
        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                print('cost = ', cost)
                heapq.heappush(q, (cost, i[0]))
        print('distance')
        print(distance)
        print('-------------')

dijkstra(start)

