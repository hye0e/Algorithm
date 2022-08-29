"""
유기농 배추

input: 
테스트 케이스의 개수 T
가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50)
배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)

output: 1인 개수 세기
"""
import sys

# 재귀
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

T = int(input())

def dfs(x, y):
    dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]

    if 0 > x or x >= N or 0 > y or y >= M:
        return False
    
    if graph[x][y] == 1:
        graph[x][y] = 0
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            dfs(nx, ny)
        return True
    return False
        
for i in range(T):
    M, N, K = map(int, input().strip().split())
    graph = [[0] * M for _ in range(N)]

    for k in range(K):
        n, v = map(int, input().strip().split())
        graph[v][n] = 1
    
    result = 0
    for i in range(N): 
        for j in range(M): 
            if dfs(i, j) == True:
                result += 1

    print(result)
