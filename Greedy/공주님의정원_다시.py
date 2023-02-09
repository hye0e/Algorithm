"""
4
1 1 5 31
1 1 6 30
5 15 8 31
6 10 12 10
"""
import sys
from collections import deque

input = sys.stdin.readline

N = int(input().strip())
flower_calendar = []

for i in range(N):
    start_month, start_day, stop_month, stop_day = map(int, input().strip().split())
    flower_calendar.append([start_month * 100 + start_day, stop_month * 100 + stop_day])

flower_calendar.sort(key = lambda x: x[0])
# 초기화
for i in range(N):
    if flower_calendar[i][0] <= 301:
        flower_calendar[i][0] = 301
    if flower_calendar[i][1] >= 1201:
        flower_calendar[i][1] = 1201

plant = 1

# 301 에서 가장 멀리 심을 수 있는 곳에서부터 시작
start = 301
end = 0
start_index = 0

for i in range(N):
    if flower_calendar[i][0] == 301:
        end = max(end, flower_calendar[i][1])
        start_index = i

temp_start, temp_end = start, end
while True:
    if start_index >= N - 1:
        break

    for i in range(start_index + 1, N):
        if end >= flower_calendar[i][0] \
                and temp_start <= flower_calendar[i][0]\
                and temp_end <= flower_calendar[i][1]:
            temp_start = flower_calendar[i][0]
            temp_end = flower_calendar[i][1]
            start_index = i

    if temp_start != start and temp_end != end:
        start = temp_start
        end = temp_end
        plant += 1
    else:
        start_index += 1

    if end == 1201:
        break

if flower_calendar[0][0] == 301 and end == 1201:
    print(plant)
else:
    print(0)








