def solution(a, b):
    maxDay=[31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day=['MON', 'TUE', 'WED', 'TUR', 'FRI', 'SAT', 'SUN']
    return day[(sum(maxDay[:a]) + b) % 7]

if __name__ == '__main__':
    print(solution(1, 7))

