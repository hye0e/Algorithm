class Solution(object):
    def numIslands(self, grid):
        m = len(grid)
        n = len(grid[0])

        def dfs(x, y):
            if 0 <= x < m and 0 <= y < n:
                if grid[x][y] == '1':
                    # 방문 처리
                    grid[x][y] = '0'

                    dfs(x + 1, y)
                    dfs(x - 1, y)
                    dfs(x, y + 1)
                    dfs(x, y - 1)

                    return True
            return False

        answer = 0

        for i in range(m):
            for j in range(n):
                if dfs(i, j):
                    answer += 1

        return answer
