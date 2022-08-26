import sys

input = sys.stdin.readline
N = int(input())
result = []
for i in range(N):
    n = input().strip().split()
    # push 
    if len(n) > 1:
        result.append(n[1])
    # pop 
    elif n[0] == 'pop' and len(result) == 0:
        print(-1)
    elif n[0] == 'pop' and len(result) != 0:
        print(result[-1])
        result.pop()
    elif n[0] == 'top' and len(result) == 0:
        print(-1)
    elif n[0] == 'top' and len(result) != 0:
        print(result[-1])
    # size
    elif n[0] == 'size':
        print(len(result))
    # empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    elif n[0] == 'empty' and len(result) == 0:
        print(1)
    elif n[0] == 'empty' and len(result) != 0:
        print(0)
