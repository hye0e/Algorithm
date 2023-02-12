"""
첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.

0 빈칸 1 집 2 치킨
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
"""
import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
graph = [list(map(int, input().strip().split())) for _ in range(N)]

chicken = []
home = []

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            home.append([i + 1, j + 1])
        elif graph[i][j] == 2:
            chicken.append([i + 1, j + 1])

open_chicken = []
visited = [False for _ in range(len(chicken))]

answer = 1e9

def cal(home, chicken):
    print(chicken)
    return abs(home[0] - chicken[0]) + abs(home[1] - chicken[1])

def dfs(start):
    global answer
    if M == len(open_chicken):
        city_chicken_dis = 0
        for i in range(len(home)):
            chicken_distance = 1e9
            for j in range(len(open_chicken)):
                # 치킨 거리
                chicken_distance = min(cal(home[i], open_chicken[j]), chicken_distance)
            # 도시 치킨 거리
            city_chicken_dis += chicken_distance

        answer = min(answer, city_chicken_dis)
        return

    for i in range(start, len(chicken)):
        if not visited[i]:
            visited[i] = True
            open_chicken.append(chicken[i])
            dfs(i)
            open_chicken.pop()
            visited[i] = False

dfs(0)
print(answer)







