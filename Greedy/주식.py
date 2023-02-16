import sys

input = sys.stdin.readline

T = int(input().strip())
answer_list = []
for i in range(T):
    N = int(input().strip())
    cost = list(map(int, input().strip().split()))

    answer = 0
    max_profit = cost[-1]
    # 마지막 숫자
    target = N - 1

    while True:
        if target == -1:
            break

        if max_profit > cost[target]:
            answer += max_profit - cost[target]

        elif max_profit < cost[target]:
            max_profit = cost[target]

        target -= 1

    answer_list.append(answer)

for i in answer_list:
    print(i)
