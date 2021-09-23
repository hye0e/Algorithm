def solution(board, moves):
    answer = 0
    bucket = []
    for move in moves:
        for doll in board:
            if doll[move - 1] != 0:
                bucket.append(doll[move - 1])
                doll[move - 1] = 0
                if len(bucket) > 1:
                    if bucket[-1] == bucket[-2]:
                        answer += 2
                        bucket = bucket[:-2]
                break

    return answer

if __name__ == '__main__':
    print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4]))
    