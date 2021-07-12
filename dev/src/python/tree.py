≈≈≈
# 예제 입력
# 16   : 첫줄은 쿼드 트리의 크기를 의미함
# 0000000000000011
# 0000000000000011
# 0000000000001111
# 0000000000001111
# 0000111100000000
# 0000111100000000
# 0000111100000000
# 0000111100000000
# 0011000011111111
# 1111000011111111
# 0000000011111111
# 0000000011111111
# 0000111111111111
# 0000111111111111
# 0000111111111111
# 0000111111111111

BLACK = 1
WHITE = 0

def decompress(x, y, size):
    global matrix, answer 
    color = matrix[y][x] 
    for i in range(x, x+size):            
        for j in range(y, y+size):
            if matrix[j][i] != color: 
                answer += 'x'
                decompress(x, y, size//2) 
                decompress(x + size//2, y, size//2) 
                decompress(x, y + size//2, size//2) 
                decompress(x + size//2, y + size//2, size//2) 
                return
    if matrix[y][x] == BLACK: #검정색이라면
        answer += 'b'
    else:
        answer += 'w' #흰색이라면


N = int(input())
matrix = []
answer = ''

for _ in range(N):
    matrix.append(list(map(int, str(input()))))

decompress(0,0,N)
print(answer)