def solution(lotteries):
    answer = 1
    # 복권 당첨가능 확률
    possible = []

    for i in range(len(lotteries)):
        percentage = lotteries[i][0] / (lotteries[i][1] + 1)
        if percentage >= 1:
            percentage = 1
        possible.append([percentage, lotteries[i][2], i + 1])

    possible.sort(key = lambda x: (x[0], x[1]), reverse= True)

    return possible[0][2]

print(solution([[10, 19, 800], [20, 39, 200], [100, 199, 500]]))