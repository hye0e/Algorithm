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
    numbers = list(numbers)
    num = []
    for i in range(1, len(numbers) + 1):
        num += list(permutations(numbers, i))

    new_num = [int(''.join(n)) for n in num]
    prime_list = []
    for n in new_num:
        if checkPrime(n):
            prime_list.append(n)

    return len(set(prime_list))

if __name__ == '__main__':
    solution("17")