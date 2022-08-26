def solution(numbers, hand):
    answer = ''
    keypads = {1: (0, 0), 2: (0, 1), 3: (0, 2),
               4: (1, 0), 5: (1, 1), 6: (1, 2),
               7: (2, 0), 8: (2, 1), 9: (2, 2), 
               '*': (3, 0), 0: (3, 1), '#': (3, 2)}
    now_L = '*'
    now_R = '#'

    left = [1, 4, 7, '*']
    right = [3, 6, 9, '#']
    distance_L = 0
    distance_R = 0

    for number in numbers:
        if number in left:
            answer += 'L'
            distance_L = (abs(keypads[now_L][0]) - abs(keypads[number][0])) + (abs(keypads[now_L][1]) - abs(keypads[number][1])) 
            now_L = number
        elif number in right:
            answer += 'R'
            distance_R = (abs(keypads[now_R][0]) - abs(keypads[number][0])) + (abs(keypads[now_R][1]) - abs(keypads[number][1])) 
            now_R = number
        else:
            # distance
            if distance_L == distance_R and hand == 'right':
                answer += 'R'
                now_R = number
            elif distance_L == distance_R and hand == 'left':
                answer += 'L'
                now_L = number
            elif distance_L < distance_R:
                answer += 'L'
                now_L = number
            elif distance_L > distance_R:
                answer += 'R'
                now_R = number

    return answer


if __name__ == '__main__':
    print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right')) # LRLLLRLLRRL