"""
N, M, K, X
최단 거리가 정확히 K인 모든 도시들의 번호를 출력

4 4 2 1
1 2
1 3
2 3
2 4

"""
import sys

input = sys.stdin.readline

N, M, K, X = map(int, input().strip().split())

graph = [[] for _ in range(N)]
for i in range(M):
    n, v = map(int, input().split())

    graph[n].append(v)

print(graph)