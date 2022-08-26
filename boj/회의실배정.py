import sys

input = sys.stdin.readline
meet_room = []
N = int(input())
for i in range(N):
    left, right = map(int, input().split())
    meet_room.append([left, right])

min = meet_room[0][0]
max = meet_room[0][1]
cnt = 1
for i in range(1, len(meet_room) + 1):
    if max <= meet_room[i-1][0]:
        min = meet_room[i-1][0]
        max = meet_room[i-1][1]
        cnt += 1

print(cnt)


