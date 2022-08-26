import sys

input = sys.stdin.readline

n = int(input())
num_list = [int(input()) for i in range(n)]
result = []
stack = []
N = 0
for i in num_list:
    while N < i:
        N += 1
        stack.append(N)
        result.append('+')

    if stack[-1] == i:
        stack.pop()
        result.append('-')
    else:
        result.append('NO')
        break
    
if 'NO' in result:
    print('NO')
else:
    print('\n'.join(result))