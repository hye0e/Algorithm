N, M, R = map(int, input().split())
matrix = [list(map(int, input().split())) for i in range(N)]
# new_matrix = [[0 for i in range(M)] for j in range(N)]

# 상하 반전
def R_1():
    temp = [[0] * M for _ in range(N)]
    for i in range(N):
        temp[i] = matrix[N -1 -i]
    return temp

# 좌우 반전
def R_2():
    temp = [[0] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            temp[i][j] = matrix[i][M -1 -j]

    return temp

# 오른쪽 90도 회전
# 왼쪽 90도 회전
# N/2*M/2 4개 부분 배열


