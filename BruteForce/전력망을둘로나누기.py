from collections import deque

def bfs(start, graph, visited):
    queue = deque([start])
    visited[start] = True
    cnt = 0

    while queue:
        v = queue.popleft()
        cnt += 1

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

    return cnt

def solution(n, wires):
    answer = 1e9

    # 2. 전헌 하나를 끊고, 연결된 노드 수 받아오기
    for i in range(len(wires)):
        temp_wires = wires.copy()
        # 하나 끊기
        temp_wires.pop(i)
        visited = [False] * (n + 1)
        graph = [[] for _ in range(n + 1)]

        # 양방향이므로 tree 형태로 만들기
        for wire in temp_wires:
            a, b = wire
            graph[a].append(b)
            graph[b].append(a)

        cnt = bfs(i, graph, visited)
        rest_cnt = n - cnt

        answer = min(answer, abs(cnt - rest_cnt))

    return answer

print(solution(9, [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]))