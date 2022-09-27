def solution(answers):
    student = {i + 1: 0 for i in range(3)}
    one = [1, 2, 3, 4, 5] * 2 # 5 * 2
    two = [2, 1, 2, 3, 2, 4, 2, 5]# 8
    two = two + two[:2]
    three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] # 10
    
    for i in range(len(answers)):
        if one[i] == answers[i]:
            student[1] += 1
        if two[i] == answers[i]:
            student[2] += 1
        if three[i] == answers[i]:
            student[3] += 1
    
    student = sorted(student.items(), key = lambda item: item[1], reverse = True)
    first = student[0][1]
    answer = [student[0][0]]
    for key, value in range(1, len(student)):
        if first == value:
            answer.append(key)
    return answer

solution([1,2,3,4,5])