import math

def solution(progresses, speeds):
    answer = [1]

    rest_progress = [math.ceil((100 - progresses[i])/speeds[i]) for i in range(len(progresses))]
    max_progress = rest_progress[0]
    for rp in rest_progress[1:]:
        if rp > max_progress:
            max_progress = max(rp, max_progress)
            answer.append(1)
        else:
            answer[-1] += 1

    return answer

print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]))