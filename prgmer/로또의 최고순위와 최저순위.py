def solution(lottos, win_nums):
    rank=[6,6,5,4,3,2,1]

    cnt_0 = lottos.count(0)
    ans = 0
    for x in win_nums:
        if x in lottos:
            ans += 1
    return rank[cnt_0 + ans], rank[ans]

def solution(lottos, win_nums):
    answer = []
    rank = 7
    for num in win_nums:
        if lottos.count(num) == 1: # if num in lottos 
            rank -= 1

    if lottos.count(0) == 6:
        answer.append(1)
    elif lottos.count(0) == 0 and rank == 7:
        answer.append(6)
    else:
        answer.append(rank - lottos.count(0))

    answer.append(6 if rank == 7 else rank)

    return answer

if __name__ == '__main__':
    print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19])) # [3, 5]

    print(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25])) # [1, 6]

    print(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35])) # [1, 1]
    print(solution([1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12])) # [6, 6]

