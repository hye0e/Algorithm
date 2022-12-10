- 다익스트라알고리즘
    - 다이나믹 프로그래밍을 활용한 대표적인 **최단경로 알고리즘**
    - 하나의 정점에서 다른 모든 정점으로 가는 최단 경로
- 동작과정
    1. 출발 노드 설정
    2. 출발 노드를 기준으로 각 노드의 최소 비용 저장
    3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드 선택
    4. 해당 노드를 거쳐서 특정 노드로 가는 경우를 고려하여 최소 비용 갱신
    5. 위 과정에서 3번 ~ 4번 반복
- 시간복잡도
    - 선형 탐색 O(N^2)
    - 힙 구조 O(N * log N)
- heap을 활용한 구현
    
    ```python
    import sys
    import heapq
    
    input = sys.stdin.readline
    
    INF = 1e9
    
    V, E = map(int, input().strip().split())
    k = int(input().strip()) # 시작 노드
    
    graph = [[] for _ in range(V + 1)]
    
    visited = [False] * (V + 1)
    distance = [INF] * (V + 1)
    
    for _ in range(E):
    		# u: 출발노드 v: 도착노드 w: 연결된 간선의 가중치
        u, v, w = map(int, input().split())
        graph[u].append((v, w))
    
    def dijkstra(start):
        queue = []
        heapq.heappush(queue, (0, start))
        distance[start] = 0
    
        while queue:
    				# 우선 순위가 가장 낮은 값(가장 작은 거리)가 나옴
            dist, now = heapq.heappop(queue)
    				
    				# 이미 입력되어있는 값이 현재노드까지의 거리보다 작다면 이미 방문 노드
            if distance[now] < dist:
                continue
    
    				# 연결된 모든 노드 탐색
            for i in graph[now]:
                if dist + i[1] < distance[i[0]]:
                    distance[i[0]] = dist + i[1]
                    heapq.heappush(queue, (dist + i[1], i[0]))
    
    dijkstra(k)
    for i in range(1, len(distance)):
        if distance[i] == INF:
            print('INF')
        else:
            print(distance[i])
    ```