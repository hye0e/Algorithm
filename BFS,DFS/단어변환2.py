from collections import deque
# 한글자 체크
def is_valid(begin, target):
    count = len(begin)

    for i in range(count):
        if begin[i] == target[i]:
            count -= 1

    return count == 1

def solution(begin, target, words):
    def bfs(word):
        visited = {word: 0}
        queue = deque([])
        queue.append(word)
        while queue:
            word = queue.popleft()
            if word == target:
                break

            for value in words:
                # visited안에 없다면 한번도 방문한적 없던 단어
                if is_valid(value, word) and value not in visited:
                    visited[value] = visited[word] + 1
                    queue.append(value)
        return visited
    return bfs(begin).get(target, 0)

solution('hit', 'cog', ["hot", "dot", "dog", "lot", "log", "cog"])