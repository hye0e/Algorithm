import sys

input = sys.stdin.readline

N, K = map(int, input().split())
arr = [[], []], [[], []], [[], []], [[], []], [[], []], [[], []]
for i in range(N):
    S, Y = map(int, input().split())
    arr[Y - 1][S].append(1)

roomCnt = 0
for room in arr:
    print(room)
    print('===')
    if len(room[0]) > 0: 
        print(room[0])
        roomCnt += len(room[0]) // 2
    elif len(room[1]) > 0:
        print(room[1])
        roomCnt += len(room[1]) // 2
