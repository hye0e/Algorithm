from hashlib import new
from itertools import permutations

def checkPrime(num):
    if num < 2:
        return False

    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    new_num = []
    for i in range(1, len(numbers) + 1):
        for j in permutations(map(str, numbers), i):
            num = int(''.join(j))
            if num not in new_num: new_num.append(num)

    print(new_num)
    for num in new_num:
        if checkPrime(num):
            answer += 1
    return answer

print(solution([0, 1, 1]))