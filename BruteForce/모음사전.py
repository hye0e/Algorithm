from itertools import product

def solution(word):
    answer = 0
    dictionary = []
    for i in range(1, 6):
        for d in product(['A', 'E', 'I', 'O', 'U'], repeat = i):
            dictionary.append(''.join(list(d)))

    dictionary.sort()

    return dictionary.index(word)

print(solution('AAAA'))
