from collections import deque

def solution(numbers, target):
    answer = 0
    queue = deque()
    queue.append([numbers[0], 0])
    queue.append([-1 * numbers[0], 0])
    stop = len(numbers)
    while queue:
        temp, idx = queue.popleft()
        idx += 1
        if idx < stop:
            queue.append([temp + numbers[idx], idx])
            queue.append([temp - numbers[idx], idx])
        elif temp == target:
            answer += 1

    return answer

if __name__ == '__main__':
    # print(solution([1, 1, 1, 1], 3))
    print(solution([4, 1, 2, 1], 4))