import sys
input = sys.stdin.readline

R, C = map(int, input().strip().split())
visited = [False for _ in range(26)]
graph = [list(input().strip()) for _ in range(R)]

ans = 1
visited[ord(graph[0][0]) - 65] = True

def dfs(x, y, cnt):
    global ans
    ans = max(cnt, ans)
    print()
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        print(nx, ny)
        if 0 <= nx < R and 0 <= ny < C:
            if not visited[ord(graph[nx][ny]) - 65]:
                visited[ord(graph[nx][ny]) - 65] = True
                dfs(nx, ny, cnt + 1)
                visited[ord(graph[nx][ny]) - 65] = False

dfs(0, 0, 1)
print(ans)
