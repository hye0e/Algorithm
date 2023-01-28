# "4시까지 고민해보기"
def solution(n, computers):
    visited = [False for _ in range(n)]
    answer = 0
    for i in range(n):
        if not visited[i]:
            dfs(i, visited, computers)
            answer += 1

    return answer

def dfs(target, visited, computers):
    visited[target] = True
    for i in range(len(computers)):
        if target != i and computers[target][i] == 1:
            if not visited[i]:
                dfs(i, visited, computers)

print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))
print(solution(4, [[1, 1, 1, 0], [1, 1, 1, 0], [0, 1, 1, 0], [0,0,0, 1]]))
print(solution(4, [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0,0,0, 1]]))