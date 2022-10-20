from collections import deque

def solution(maps):
    answer = 0
    m = len(maps)
    n = len(maps[0])

    def bfs(x, y):
        queue = deque([])
        queue.append([x, y])
        dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 > nx or nx >= 5 or 0 > ny or ny >= 5:
                    continue

                if maps[nx][ny] == 1:
                    queue.append([nx, ny])
                    maps[nx][ny] = maps[x][y] + 1

    bfs(0, 0)
    print(maps[n - 1][m - 1] if maps[n - 1][m - 1] != 0 else -1)
    return answer


solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]])