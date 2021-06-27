BLUE = 1
WHITE = 0
blueCnt = 0
whiteCnt = 0

def cutRectangle(x, y, size):
    global matrix, blueCnt, whiteCnt

    color = matrix[y][x]

    for i in range(x, x+size):
        for j in range(y, y+size):
            if color != matrix[j][i]:
                cutRectangle(x, y, size//2)
                cutRectangle(x + size//2, y, size//2) 
                cutRectangle(x, y + size//2, size//2) 
                cutRectangle(x + size//2, y + size//2, size//2) 
                return
    
    if matrix[y][x] == BLUE:
        blueCnt+=1
    else:
        whiteCnt+=1


N = int(input())
matrix = []
for _ in range(N):
    matrix.append(list(map(int, input())))

cutRectangle(0,0,N)
print(blueCnt)
print(whiteCnt)