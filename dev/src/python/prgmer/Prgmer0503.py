def solution(lottos, win_nums):

    rank=[6,6,5,4,3,2,1]

    cnt_0 = lottos.count(0)
    ans = 0
    for x in win_nums:
        if x in lottos:
            ans += 1
    return rank[cnt_0 + ans],rank[ans]


if __name__ == '__main__':
    print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]))