from itertools import permutations

def solution(numbers):
    num = []
    for i in range(len(numbers)):
        for j in permutations(map(str, numbers), i):
            num.append(j)
    print(num)
    answer = 0
    return answer