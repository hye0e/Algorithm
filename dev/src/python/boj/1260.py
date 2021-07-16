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
while len(queue) != 0:
    x, y = queue.pop(0)
    print(x, y)
    if x != end_x or y != end_y:
        if 0 <= x - 1 <= 7 and 0 <= y + 2 <= 7 and visited[x-1][y+2] == 0:
            queue.append([x-1, y+2])
            visited[x-1][y+2] = visited[x][y] +1
        if 0 <= x - 1 <= 7 and 0 <= y - 2 <= 7 and visited[x-1][y-2] == 0:
            queue.append([x-1, y-2])  
            visited[x-1][y-2] = visited[x][y] +1
        if 0 <= x + 1 <= 7 and 0 <= y - 2 <= 7 and visited[x+1][y-2] == 0:
            queue.append([x+1, y-2])
            visited[x+1][y-2] = visited[x][y] +1
        if 0 <= x + 1 <= 7 and 0 <= y + 2 <= 7 and visited[x+1][y+2] == 0:
            queue.append([x+1, y+2])
            visited[x+1][y+2] = visited[x][y] +1
        if 0 <= x - 2 <= 7 and 0 <= y + 1 <= 7 and visited[x-2][y+1] == 0:
            queue.append([x-2, y+1])
            visited[x-2][y+1] = visited[x][y] +1
        if 0 <= x + 2 <= 7 and 0 <= y + 1 <= 7 and visited[x+2][y+1] == 0:
            queue.append([x+2, y+1])
            visited[x+2][y+1] = visited[x][y] +1
        if 0 <= x - 2 <= 7 and 0 <= y - 1 <= 7 and visited[x-2][y-1] == 0:
            queue.append([x-2, y-1])
            visited[x-2][y-1] = visited[x][y] +1
        if 0 <= x + 2 <= 7 and 0 <= y - 1 <= 7 and visited[x+2][y-1] == 0:
            queue.append([x+2, y-1])
            visited[x+2][y-1] = visited[x][y] +1
    else:
        break

print(visited[end_x][end_y])

