from collections import deque

def bfs(computer, start, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        for i in range(len(computer)):
            if computer[v][i] == 1 and not visited[i]:
                queue.append(i)
                visited[i] = True

def solution(n, computers):
    answer = 0
    visited = [False] * (n)
    
    for i in range(n):
        if visited[i] == False:
            bfs(computers, i, visited)
            answer += 1

    return answer

if __name__ == '__main__':
    print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
    print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))