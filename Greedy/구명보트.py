from collections import deque
from itertools import combinations


def solution(people, limit):
    # 최소 보트의 개수 = 최소 몸무게 + 최대 몸무게
    answer = 0
    people.sort()
    boat = deque(people)

    # 한명일 경우
    if len(people) == 1:
        return 1

    while boat:
        # 하나 남았을 경우 -> 홀수 일 경우
        if len(boat) == 1:
            answer += 1
            break

        if boat[0] + boat[-1] <= limit:
            answer += 1
            boat.pop()
            boat.popleft()
        else:
            answer += 1
            boat.pop()

    return answer
