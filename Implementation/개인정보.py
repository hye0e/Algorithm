def cal_day(today, term_month):
    year, month, day = map(int, today.split('.'))

    month += term_month

    if day == 1:
        day = 28
        month -= 1
    else:
        day -= 1

    while month > 12:
        year += 1
        month -= 12

    return [year, month, day]


# 일수로 변경해서 valid check
def valid(today, limit_day):
    day = 0
    l_day = 0

    day += (today[0] - 2000) * (12 * 28)
    l_day += (limit_day[0] - 2000) * (12 * 28)

    day += today[1] * 12
    l_day += limit_day[1] * 12

    day += today[2]
    l_day += limit_day[2]

    return day <= l_day


def solution(today, terms, privacies):
    term_dict = {}

    for term in terms:
        term_type, months = term.split()

        term_dict[term_type] = int(months)

    # 언제까지인지
    limit_day = []
    for i in range(len(privacies)):
        privacy = privacies[i].split()

        privacy_day = privacy[0]
        privacy_type = privacy[1]

        limit_day.append(cal_day(privacy_day, term_dict[privacy_type]))

    print(limit_day)
    answer = []
    for i in range(len(limit_day)):
        today_list = list(map(int, today.split('.')))
        if not valid(today_list, limit_day[i]):
            answer.append(i + 1)

    return answer

print(solution("2022.02.28", ["A 23"], ["2020.01.28 A"]))