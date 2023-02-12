def solution(s, skip, index):
    answer = ''

    alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z']

    for i in range(len(skip)):
        alphabet.pop(alphabet.index(skip[i]))

    for i in range(len(s)):
        answer += alphabet[(alphabet.index(s[i]) + index) % len(alphabet)]

    return answer