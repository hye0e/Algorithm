def solution(board, moves):
    answer = 0
    bucket = []
    for j in moves:
        for i in board:
            if i[j - 1] != 0:
                bucket.append(i[j - 1])
                i[j - 1] = 0
                if len(bucket) > 1:
                    if bucket[-1] == bucket[-2]:
                        answer += 2
                        bucket = bucket[:-2]
                break

    return answer

if __name__ == '__main__':
    board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
    moves = [1,5,3,5,1,2,1,4]	

    print(solution(board, moves))