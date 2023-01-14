def solution(name):
    answer = 0
    now = ['A' for _ in range(len(name))]

    alphabet = {'A': 1, 'B': 2, 'C': 3, 'D': 4, 'E': 5,
                'F': 6, 'G': 7, 'H': 8, 'I': 9, 'J': 10,
                'K': 11, 'L': 12, 'M': 13, 'N': 14, 'O': 15,
                'P': 16, 'Q': 17, 'R': 18, 'S': 19, 'T': 20,
                'U': 21, 'V': 22, 'W': 23, 'X': 24, 'Y': 25,
                'Z': 26
                }
    now_index = 0
    while True:
        if ''.join(now) == name:
            break
        right_cnt = 0
        left_cnt = 0

        # A가 어느 쪽이 더 많은지
        if name[now_index] != 'A':
            left = abs(alphabet[now[now_index]] - alphabet[name[now_index]] + 26)
            right = abs(alphabet[now[now_index]] - alphabet[name[now_index]])

            # 왼쪽으로 가는 게 빠른지 오른쪽으로 가는 게 빠른지 판단
            answer += min(left, right)
            # 마지막은 안셈
            if now_index == len(name) - 1:
                answer += 1

            if
            for i in range(now_index, len(name)):
                if name[i] == 'A':
                    right_cnt += 1

            for i in range(now_index, -1, -1):
                if name[i] == 'A':
                    left_cnt += 1

            # 왼쪽으로 가야함
            if right_cnt >= left_cnt:
                for i in range(len(name) - 1, -1, -1):
                    if name[i] != 'A':
                        now_index = i
                        break

        # 수정x
        now[now_index] = name[now_index]
        now_index += 1

    return answer

print(solution('JAN'))
# print(solution('JAN'))