"""
dfs
1은 집이 있는 곳을, 0은 집이 없는 곳
대각선상에 집이 있는 경우는 연결된 것이 아니다.

단지수: 1인 개수 출력
1의 개수 오름차순으로 출력
"""
import sys

input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().strip())) for _ in range(N)]
result = []
def dfs(x, y):
    dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]

    if 0 > x or 0 > y or x >= N or y >= N:
        return False

    if graph[x][y] == 1:
        global result
        result += 1
        
        # 방문 표시
        graph[x][y] = 0
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            dfs(nx, ny)
            return True
    return False

result = 0
result_list = []
total = 0

for i in range(N):
    for j in range(N):
        if dfs(i, j) == True:
            result_list.append(result)
            total += 1
            result = 0
print(total)
print(result_list)