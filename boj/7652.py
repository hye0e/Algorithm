#-*- coding:utf-8 -*-

""" 
DFS: stack, visited 
BFS: queue, visited 

해결방안
    1. test_case 입력 
    2. test_case 만큼 for 문으로 체스판 길이, 현재 칸, 이동하려는 칸 입력
    3.  
    4. 

    hint. visited 2차원 
"""
import sys

test_case = int(sys.stdin.readline())

visited = []
for i in range(9):
    visited.append([0] * 8)

queue = []

start_x = 0
start_y = 0

end_x = 7
end_y = 0

count = 0
queue.append([start_x, start_y])

dx = [-1, -1, 1, 1, -2, -2, 2, 2]
dy = [-2, 2, 2, -2, 1, -1, 1, -1]

while len(queue) != 0:
    x, y = queue.pop(0)
    print(x, y)
    # for
    for i in range(len(dx)):
        if x != end_x or y != end_y:
            if 0 <= x - 1 <= 7 and 0 <= y + 2 <= 7 and visited[x + dx[i]][y + dy[i]] == 0:
                queue.append([x + dx[i], y + dy[i]])
                visited[x + dx[i]][y + dy[i]] = visited[x][y] +1
    else:
        break

print(visited[end_x][end_y])

