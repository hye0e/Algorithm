import sys

input = sys.stdin.readline

cnt = int(input().strip())
text = [list(input().strip()) for _ in range(cnt)]
answer = []
index = 0

for i in range(len(text[0])):
    alph = text[index][i]
    index = 0
    flag = True
    while index < cnt - 1:
        if text[index][i] != text[index + 1][i]:
            answer += '?'
            flag = False
            break

        index += 1

    if flag:
        answer += alph
print(''.join(answer))