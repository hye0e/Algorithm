
from collections import deque
import queue
def solution(begin, target, words):
    answer = 0
    stop = len(begin) - 1 # 한 글자만 다른 경우
    idx = 0
    queue = deque()
    for word in words:
        count = 0
        while True:
            if idx < len(begin):
                if word[idx] == begin[idx]:
                    count += 1
            else:
                break
            idx += 1

            if count == stop:
                queue.append(word)

            
    print(queue)
            
    # queue = deque()
    # queue.append([begin[0], 0])

    # visited = [False] * len(words)

    # while queue:
    #     word, idx = queue.popleft()

    #     idx += 1
    #     if idx < stop:
    #         for w in words:
    #             if w[idx] == word and not visited[idx]:
    #                 queue.append(w[idx], idx)
    #                 visited[idx] = True
        
        
    return answer

if __name__ == '__main__':
    solution('hit', 'cog', ["hot", "dot", "dog", "lot", "log", "cog"])