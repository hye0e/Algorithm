from collections import deque

def solution(maps):
    queue = deque([])
    queue.append([0, 0])
    
    M = len(maps)
    N = len(maps[0])

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
   

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < M and 0 <= ny < N and maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                queue.appendleft([nx, ny])
    
    return -1 if maps[M - 1][N - 1] == 1 else maps[M - 1][N - 1]


if __name__ == '__main__':
    print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
    # print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]))
    '''
[
[3, 0, 9, 10, 11], 
[2, 0, 8, 0, 12], 
[3, 0, 7, 8, 13], 
[4, 5, 6, 0, 14], 
[0, 0, 0, 0, 15]]
    '''