import sys
import heapq as hq

input = sys.stdin.readline

X = int(input())
left_heap = []
right_heap = []


for i in range(X):
    num = int(input())
    if len(left_heap) == len(right_heap):
        hq.heappush(left_heap, (-num, num))
    else:
        hq.heappush(right_heap, (num, num))

    if right_heap and left_heap[0][1] > right_heap[0][0]:
        min = hq.heappop(right_heap)[0]
        max = hq.heappop(left_heap)[1]
        hq.heappush(left_heap, (-min, min))
        hq.heappush(right_heap, (max, max))

    print(left_heap[0][1])

