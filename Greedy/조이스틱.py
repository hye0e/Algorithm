def solution(name):
    answer = 0
    alphabet = ['A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z']
    start = ['A' for _ in range(len(name))]
    cur_index = 0

    while True:
        move_cnt = min(26 - alphabet.index(name[cur_index]),
                       abs(alphabet.index(start[cur_index]) - alphabet.index(name[cur_index])))

        answer += move_cnt

        start[cur_index] = name[cur_index]

        if ''.join(start) == name:
            break

        # 좌우 판단
        # A 가 어느쪽에 더 많은지
        right = cur_index
        right_cnt = 0
        while start[right] == name[right]:
            right = (right + 1) % len(name)
            right_cnt += 1

        left = cur_index
        left_cnt = 0
        while start[left] == name[left]:
            left = (left - 1) % len(name)
            left_cnt += 1

        # 오른쪽으로 가는 것이 더 최소임
        if left_cnt > right_cnt:
            cur_index = right
            answer += right_cnt
        else:
            cur_index = left
            answer += left_cnt

    return answer

print(solution('BBBBAAAABA'))
# print(solution('JAN'))

