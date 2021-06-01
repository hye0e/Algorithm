def solution(answers):
    st1 = [1, 2, 3, 4, 5]
    st2 = [2, 1, 2, 3, 2, 4, 2, 5]
    st3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    answer = []
    cnt = [0, 0, 0]
    for i in range(len(answers)):
       if answers[i] == st1[i%len(st1)]: cnt[0] += 1
       if answers[i] == st2[i%len(st2)]: cnt[1] += 1
       if answers[i] == st3[i%len(st3)]: cnt[2] += 1
    
    for i in range(len(cnt)):
        if max(cnt) == cnt[i]:
            answer.append(i+1)

    return answer   

if __name__ == '__main__':
    print(solution([1,3,2,4,2]))
    