def solution(n):
    answer = ''

    while n > 0:
        if n % 3 != 0:
            answer += str(n % 3)
            n //= 3
        elif n % 3 == 0:
            # 마지막 숫자는 무조건 4
            answer += '4'
            n = n // 3 - 1
    return answer[::-1]


if __name__ == '__main__':
    print(solution(13))
    print(solution(14))
    print(solution(15))