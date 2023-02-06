import sys, heapq

input = sys.stdin.readline
make_class = []

N = int(input().strip())
class_list = []
for i in range(N):
    s, t = map(int, input().strip().split())
    class_list.append([s, t])
print(class_list)
class_list.sort(key = lambda x: x[0])

heapq.heappush(make_class, class_list[0][1])

for i in range(1, len(class_list)):
    if make_class[0] <= class_list[i][0]:
        heapq.heappop(make_class)
        heapq.heappush(make_class, class_list[i][1])
    else:
        heapq.heappush(make_class, class_list[i][1])

print(len(make_class))