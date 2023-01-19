
import sys

input = sys.stdin.readline

R, C = map(int, input().strip().split())
graph = [list(input().strip()) for _ in range(R)]
count = [[1 for _ in range(C)] for _ in range(R)]
# visited = { 'A': False, 'B': False, 'C': False, 'D': False, 'E': False, 'F': False,
# 'G': False, 'H': False, 'I': False, 'J': False, 'K': False, 'L': False,
# 'M': False, 'N': False, 'O': False, 'P': False, 'Q': False, 'R': False,
# 'S': False, 'T': False, 'U': False, 'V': False, 'W': False, 'X': False,
# 'Y': False, 'Z': False }
visited = [False for _ in range(26)]

answer = 0
def dfs(x, y, cnt):
    global answer
    answer = max(cnt, answer)
    dx, dy = [0, 0, -1, 1], [1, -1, 0, 0]
    visited[ord(graph[x][y]) - 65] = True
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        if 0 <= nx < R and 0 <= ny < C:
            if not visited[ord(graph[nx][ny]) - 65]:
                visited[ord(graph[nx][ny]) - 65] = True
                dfs(nx, ny, cnt + 1)
                visited[ord(graph[nx][ny]) - 65] = False

dfs(0, 0, 1)

print(answer)