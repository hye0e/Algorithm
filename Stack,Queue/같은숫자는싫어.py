def solution(arr):
    answer = [-1]
    for i in range(len(arr)):
        num = answer[-1]
        if num != arr[i]:
            answer.append(arr[i])
            
    return answer[1:]