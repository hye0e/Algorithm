import sys
input = sys.stdin.readline

N = int(input().strip())

scores = [int(input().strip()) for _ in range(N)]

index = 0
answer = 0
last_check = False

while True:
    if last_check:
        break

    if scores[index] >= scores[index + 1]:
        scores[index] -= 1
        answer += 1
    else:
        index += 1

    if index == len(scores) - 1:
        for i in range(N - 1):
            if scores[i] >= scores[i + 1]:
                index = 0
                last_check = False
                break
            else:
                last_check = True

print(answer)

