def solution(citations):
    answer = []
    """
    어떤 과학자가 발표한 논문 n편 중, 
    h번 이상 인용된 논문이 h편 이상이고 
    나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
    """
    for i in range(len(citations)):
        H = len(citations)
        if citations[i] >= H-i:
            answer.append(H-i)
    print(answer)
    return max(answer)

print(solution([3, 0, 6, 1, 5]))