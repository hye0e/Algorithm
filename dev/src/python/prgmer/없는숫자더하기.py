def solution(numbers):
    answer = 0
    result = [0] * 10
    for num in numbers:
        result[num] += 1

    for index, value in enumerate(result):
        if value != 1:
            answer += index
    return answer

if __name__ == '__main__':
    print(solution([1,2,3,4,6,7,8,0]))