#-*- coding:utf-8 -*-
BLACK = 1
WHITE = 0

def decompress(x, y, size):
    global matrix, answer 
    color = matrix[y][x] 
    for i in range(x, x+size):            
        for j in range(y, y+size):
            if matrix[j][i] != color: 
                answer += '('
                decompress(x, y, size//2) 
                decompress(x + size//2, y, size//2) 
                decompress(x, y + size//2, size//2) 
                decompress(x + size//2, y + size//2, size//2) 
                answer += ')'
                return
    if matrix[y][x] == BLACK: #검정색이라면
        answer += '1'
    else:
        answer += '0' #흰색이라면


N = int(input())
matrix = []
answer = ''

for _ in range(N):
    matrix.append(list(map(int, str(input()))))

decompress(0,0,N)
print(answer)