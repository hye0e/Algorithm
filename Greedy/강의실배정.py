import sys, heapq

input = sys.stdin.readline

N = int(input().strip())

class_time = []
# answer = 0
for _ in range(N):
    class_time.append(list(map(int, input().strip().split())))

class_time.sort()

room = []
heapq.heappush(room, class_time[0][1])

print()
for i in range(1, N):
    start_time, end_time = class_time[i][0], class_time[i][1]
    if start_time < room[0]:
        heapq.heappush(room, end_time)
    else:
        heapq.heappop(room)
        heapq.heappush(room, end_time)
print(len(room))
