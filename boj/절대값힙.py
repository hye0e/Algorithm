import sys
import heapq as hq

input = sys.stdin.readline

X = int(input())
heap = []
for i in range(X):
    num = int(input())
    if num != 0:
        hq.heappush(heap, (abs(num), num))
    else:
        if heap:
            print(hq.heappop(heap)[1])
        else:
            print(0)