answer = 0
def DFS(numbers, target, index, temp):
    global answer
    if index == len(numbers) and temp == target:
        answer += 1
        return 

    if index == len(numbers):
        return
        
    DFS(numbers, target, index + 1, temp + numbers[index])
    DFS(numbers, target, index + 1, temp - numbers[index])

def solution(numbers, target):
    global answer
    DFS(numbers, target, 0, 0)

    return answer

if __name__ == '__main__':
    # print(solution([1, 1, 1, 1], 3))
    print(solution([4, 1, 2, 1], 4))