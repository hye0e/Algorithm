def solution(m, n, board):
    answer = 0
    # input을 하나의 원소로 쪼갬
    for i in range(m):
        board[i] = list(board[i])

    pop_set = set()
    while True:
        for i in range(m - 1):
            for j in range(n - 1):
                target = board[i][j]
                if target == []:
                    continue

                if target == board[i][j + 1] and target == board[i + 1][j] and target == board[i + 1][j + 1]:
                    pop_set.add((i, j))
                    pop_set.add((i, j + 1))
                    pop_set.add((i + 1, j))
                    pop_set.add((i + 1, j + 1))

        if pop_set:
            answer += len(pop_set)
            for i, j in pop_set:
                board[i][j] = []
            pop_set = set()
        else:
            break

        while True:
            is_moved = False
            for i in range(m - 1):
                for j in range(n):
                    if board[i + 1][j] == [] and board[i][j]:
                        board[i + 1][j] = board[i][j]
                        board[i][j] = []
                        is_moved = True
            
            if is_moved == False:
                break

    return answer

if __name__ == '__main__':
    print(solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"]))