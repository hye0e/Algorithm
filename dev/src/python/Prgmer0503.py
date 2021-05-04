from collections import Counter
def solution(lottos, win_nums):
    ranking = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    c = Counter(lottos) - Counter(win_nums)
    print(c.items())

    cnt = 6 - sum([v for k, v in c.items()])
    return [ranking[cnt+c[0]], ranking[cnt]]

if __name__ == '__main__':
    print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]))