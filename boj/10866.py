import sys
from collections import deque

input = sys.stdin.readline

N = input()
result = deque()
for i in range(N):
    st = input().split()
    if len(st) == 2:
        if st[0] == 'push_back':
            result.append(st[1])
        else:
            result.appendleft(st[1])
    else:
        if st[0] == 'pop_front':
            if len(result) == 0:
                print(-1)
            else:
                print(result.pop())
        elif st[0] == 'pop_back':
            if len(result) == 0:
                print(-1)
            else:
                print(result.pop())
        elif st[0] == 'size':
            print(len(result))
        elif st[0] == 'empty':
            if len(result) == 0:
                print(1)
            else:
                print(0)
        elif st[0] == 'front':
            if len(result) == 0:
                print(-1)
            else:
                print(result.popleft())
        elif st[0] == 'back':
            if len(result) == 0:
                print(-1)
            else:
                print(result.pop())
