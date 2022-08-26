def solution(L):
    answer = 0
    max_num = max(L)
    index = 0
    for num in L:
        index += 1
        if max_num == num:
            break
    return max_num * index

if __name__ == '__main__':
    print(solution([9, 1, 10, 9, 1, 10, 10, 2]))
    