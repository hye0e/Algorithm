cnt = int(input())

def solution(num):
    if num == 1:
        return 1
    elif num == 2:
        return 2
    elif num == 3:
        return 4
    else:
        return solution(num-3) + solution(num-2) + solution(num-1)

for i in range(cnt):
    num = int(input())
    print(solution(num))