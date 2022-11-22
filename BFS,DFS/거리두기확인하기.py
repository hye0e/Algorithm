from collections import deque


def solution(places):
    answer = []

    def bfs(place):
        visited = [[False] * 5 for _ in range(5)]
        queue = deque([])

        for i in range(5):
            for j in range(5):
                if place[i][j] == 'P':
                    queue.append([i, j, 0])

        while queue:
            x, y, distance = queue.pop()
            visited[x][y] = True

            dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                nd = distance + 1

                if 0 <= nx < 5 and 0 <= ny < 5 and not visited[nx][ny]:
                    visited[nx][ny] = True

                    if place[nx][ny] == 'X':
                        continue

                    if place[nx][ny] == 'P':
                        if nd <= 2:
                            return False

                    elif place[nx][ny] == 'O':
                        if nd <= 2:
                            return False
                        else:
                            queue.append([nx, ny, nd])
        return True

    for i in places:
        if not bfs(i):
            answer.append(0)
        else:
            answer.append(1)

    return answer
