def solution(array, commands):
    answer = []
    tmp = array
    for command in commands:
        array = array[int(command[0])-1:command[1]]
        array.sort()
        answer.append(array[int(command[2])-1])
        array = tmp
    return answer


if __name__ == '__main__':
    print(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]))
    
