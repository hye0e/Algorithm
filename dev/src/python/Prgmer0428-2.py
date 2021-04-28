def solution(answers):
    st1 = [1, 2, 3, 4, 5]
    st2 = [2, 1, 2, 3, 2, 4, 2, 5]
    st3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    answer = []
    cnt1 = 0
    cnt2 = 0
    cnt3 = 0
    for i in range(len(answers)):
       if answers[i] == st1[len(answers)%len(st1)]:
           print(st1[len(answers)%len(st1)])
           cnt1+=1 
       if answers[i] == st2[len(answers)%len(st2)]:
           cnt2+=1 
       if answers[i] == st3[len(answers)%len(st3)]:
           cnt3+=1 
    return answer   

if __name__ == '__main__':
    print(solution([1,2,3,4,5]))
    