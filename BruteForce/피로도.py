from itertools import permutations


def solution(k, dungeons):
    answer = 0
    case_list = list(permutations(dungeons))

    while case_list:
        start = k
        case = case_list.pop()
        cnt = 0
        for i in range(len(dungeons)):
            minimum, use = case[i][0], case[i][1]
            if start < minimum:
                break

            start -= use
            cnt += 1

        answer = max(answer, cnt)
