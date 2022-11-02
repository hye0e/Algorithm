from itertools import product

def letterCombinations(digits):
    digit_keypad = [[], [], ['a', 'b', 'c'], ['d', 'e', 'f'], ['g', 'h', 'i'], ['j', 'k', 'l'], ['m', 'n', 'o'],
                    ['p', 'q', 'r', 's'], ['t', 'u', 'v'], ['w', 'x', 'y', 'z']]

    keypad = []
    answer = []
    for i in digits:
        keypad.append(digit_keypad[int(i)])

    for i in list(product(*keypad)):
        answer.append(''.join(i))

    return answer if answer != [''] else []