def solution(answers):
    one = [1, 2, 3, 4, 5] 
    two = [2, 1, 2, 3, 2, 4, 2, 5] 
    three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] 

    score = [0, 0, 0]

    for i in range(len(answers)):
        if one[i % len(one)] == answers[i]:
            score[0] += 1
        if two[i % len(two)] == answers[i]:
            score[1] += 1
        if three[i % len(three)] == answers[i]:
            score[2] += 1

    answer = []
    for i in range(3):
        if max(score) == score[i]:
            answer.append(i + 1)

    return answer
    
def my_solution(answers):
    # dict 으로 할 필요 없이 [0, 0, 0] score만 담은 후 idx + 1 을 리턴해주자
    student = {i + 1: 0 for i in range(3)}
    one = [1, 2, 3, 4, 5] 
    two = [2, 1, 2, 3, 2, 4, 2, 5] 
    three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] 
    
    # 이렇게 복잡하게 할 필요 없이 [i%len(one)] 방식으로 해줘도 됨
    if len(answers) > 10:
        one = one * (len(answers) // len(one)) + one[:len(answers) % len(one)]
        two = two * (len(answers) // len(two)) + two[:len(answers) % len(two)]
        three = three * (len(answers) // len(three)) + three[:len(answers) % len(three)]
        
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
    for i in range(1, 3):
        if first == student[i][1]:
            answer.append(student[i][0])
    return answer