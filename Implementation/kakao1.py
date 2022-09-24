def is_valid(today, day):
    # 2022 > 2021
    if today[0] > day[0]:
        return True
    # 2022 < 2023
    elif today[0] < day[0]:
        return False
    # 2022 == 2022
    else:
        # 05 > 03
        if today[1] > day[1]:
            return True
        # 05 == 05
        elif today[1] == day[1]:
            # 28 > 20
            if today[2] > day[2]:
                return True
            else:
                return False
    return False

def addDay(day, term):
    year = day[0]
    month = day[1]
    day = day[2] - 1

    month = month + term
    if day == 0: 
        day = 28
        month = month - 1

    while month > 12:
        year += 1
        month = month - 12

    return [year, month, day]

def solution(today, terms, privacies):
    answer = []
    today_list = list(map(int, today.split('.')))
    terms_dict = {}
    privacy_list = []

    for term in terms:
        k, v = term.split()
        terms_dict[k] = int(v)

    
    for privacy in privacies:
        day, no = privacy.split()
        privacy_list.append(addDay(list(map(int, day.split('.'))),terms_dict[no]))
    print(privacy_list)
    for idx, privacy_day in enumerate(privacy_list):
        flag = is_valid(today_list, privacy_day)
        if flag:
            answer.append(idx + 1)
    
    return answer


if __name__ == '__main__':
    print(solution("2022.05.19", ["A 6", "B 12", "C 3"], 
    ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]))
    print(solution("2020.01.01", ["Z 3", "D 5"], 
    ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]))