from collections import deque

def solution(board):
    answer = -1
    for i in range(1, len(board)):
        for j in range(1, len(board)):
            if board[i][j] == 1:
                board[i][j] = min(board[i - 1][j - 1], board[i - 1][j], board[i][j - 1]) + 1
                answer = max(answer, board[i][j])
    return answer * answer

print(solution([[0, 0]]))