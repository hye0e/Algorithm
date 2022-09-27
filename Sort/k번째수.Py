def solution(array, commands):
    answer = []
    for cm in commands:
        cut_array = cut_array[cm[0] - 1: cm[1]]
        cut_array.sort()
        answer.append(cut_array[cm[2] - 1])
    
    return answer